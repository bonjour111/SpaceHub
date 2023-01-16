package com.lpirro.launches.upcoming.presentation

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
import com.lpirro.launches.databinding.FragmentUpcomingLaunchesBinding
import com.lpirro.launches.upcoming.viewmodel.UpcomingLaunchesUiState
import com.lpirro.launches.upcoming.viewmodel.UpcomingLaunchesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UpcomingLaunchesFragment : BaseFragment<FragmentUpcomingLaunchesBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUpcomingLaunchesBinding
        get() = FragmentUpcomingLaunchesBinding::inflate

    private val viewModel: UpcomingLaunchesViewModel by viewModels()
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

    private fun onUiUpdate(uiState: UpcomingLaunchesUiState) {
        resetViews()
        when (uiState) {
            is UpcomingLaunchesUiState.Error -> binding.errorView.show()
            is UpcomingLaunchesUiState.Loading -> binding.progressBar.show()
            is UpcomingLaunchesUiState.Success -> launchesAdapter.submitList(uiState.launches)
            is UpcomingLaunchesUiState.Refresh -> binding.swipeRefresh.isRefreshing = uiState.isRefreshing
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
