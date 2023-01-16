package com.lpirro.launches.past.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lpirro.core.base.BaseFragment
import com.lpirro.core.extensions.hide
import com.lpirro.core.extensions.show
import com.lpirro.core.navigation.NavigationUtil
import com.lpirro.core.ui.recyclerview.decorator.VerticalSpaceItemDecoration
import com.lpirro.domain.models.Status
import com.lpirro.launches.adapter.LaunchesAdapter
import com.lpirro.launches.databinding.FragmentPastLaunchesBinding
import com.lpirro.launches.past.viewmodel.PastLaunchesUiState
import com.lpirro.launches.past.viewmodel.PastLaunchesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PastLaunchesFragment : BaseFragment<FragmentPastLaunchesBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPastLaunchesBinding
        get() = FragmentPastLaunchesBinding::inflate

    private val viewModel: PastLaunchesViewModel by viewModels()
    private lateinit var launchesAdapter: LaunchesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerObservers()
        setupRecyclerView()
        binding.errorView.retryClickListener = viewModel::refresh
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refresh()
        }
    }

    override fun onPause() {
        super.onPause()
        binding.swipeRefresh.isRefreshing = false
    }

    private fun registerObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { viewModel.uiState.collect { onUiUpdate(it) } }
            }
        }
    }

    private fun onUiUpdate(uiState: PastLaunchesUiState) {
        resetViews()
        when (uiState) {
            is PastLaunchesUiState.Error -> binding.errorView.show()
            is PastLaunchesUiState.Loading -> binding.progressBar.show()
            is PastLaunchesUiState.Success -> launchesAdapter.submitList(uiState.launches)
            is PastLaunchesUiState.Refresh -> binding.swipeRefresh.isRefreshing = uiState.isRefreshing
        }
    }

    private fun showStatusDialog(status: Status) {
        val builder = MaterialAlertDialogBuilder(requireContext())
        builder.setTitle(status.name)
        builder.setMessage(status.description)
        builder.setPositiveButton(android.R.string.ok) { dialog, _ -> dialog.dismiss() }
        builder.show()
    }

    private fun goToLaunchDetail(launchId: String) {
        findNavController().navigate(NavigationUtil.launchDetailDeeplink(launchId))
    }

    private fun setupRecyclerView() {
        val spacing = resources.getDimensionPixelSize(com.lpirro.core.R.dimen.margin_16dp)
        launchesAdapter = LaunchesAdapter(::goToLaunchDetail, ::showStatusDialog)
        binding.launchesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(VerticalSpaceItemDecoration(spaceSize = spacing, edgeSpacing = spacing))
            adapter = launchesAdapter
        }
    }

    private fun resetViews() {
        binding.progressBar.hide()
        binding.errorView.hide()
    }
}
