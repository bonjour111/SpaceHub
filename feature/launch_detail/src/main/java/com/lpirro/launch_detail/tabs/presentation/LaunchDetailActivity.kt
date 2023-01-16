package com.lpirro.launch_detail.tabs.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.tabs.TabLayoutMediator
import com.lpirro.domain.models.Launch
import com.lpirro.launch_detail.R
import com.lpirro.launch_detail.databinding.ActivityLaunchDetailBinding
import com.lpirro.launch_detail.tabs.viewmodel.LaunchDetailUiState
import com.lpirro.launch_detail.tabs.viewmodel.LaunchDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LaunchDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLaunchDetailBinding
    private val args: LaunchDetailActivityArgs by navArgs()
    private val viewModel: LaunchDetailViewModel by viewModels()

    private lateinit var adapter: LaunchDetailViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding = ActivityLaunchDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        var maxDeltaPadding = 0
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            maxDeltaPadding = insets.top
            binding.root.updatePadding(bottom = insets.bottom)
            WindowInsetsCompat.CONSUMED
        }

        val appBarTotalScrollRange: Float by lazy {
            binding.appBar.totalScrollRange.toFloat()
        }

        binding.appBar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            val percentOfScrollRange = (-verticalOffset / appBarTotalScrollRange)
            val deltaPadding = maxDeltaPadding * percentOfScrollRange
            val newTopPadding = deltaPadding.toInt()
            if (newTopPadding != appBarLayout.paddingTop) {
                appBarLayout.updatePadding(top = newTopPadding)
            }
        }

        registerObservers()
        setupTabs()
        viewModel.getLaunch(args.launchId)
    }

    private fun registerObservers() {
        lifecycleScope.launchWhenCreated {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { viewModel.uiState.collect { onUiUpdate(it) } }
            }
        }
    }

    private fun onUiUpdate(uiState: LaunchDetailUiState) {
        when (uiState) {
            is LaunchDetailUiState.Error -> {}
            is LaunchDetailUiState.Loading -> {}
            is LaunchDetailUiState.Success -> {
                updateUi(uiState.launch)
            }
        }
    }

    private fun updateUi(launch: Launch) {
        binding.collapsingToolbar.title = launch.name
        binding.status.text = launch.status.name
        Glide.with(this)
            .load(launch.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.launchCover)
    }

    private fun setupTabs() {
        val launchId = args.launchId
        adapter = LaunchDetailViewPagerAdapter(launchId, this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = resources.getString(R.string.tab_launch_detail_overview)
                1 -> tab.text = resources.getString(R.string.tab_launch_detail_mission)
                2 -> tab.text = resources.getString(R.string.tab_launch_detail_vehicles)
            }
        }.attach()
    }
}
