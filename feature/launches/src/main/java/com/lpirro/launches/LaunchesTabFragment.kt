package com.lpirro.launches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.lpirro.core.base.BaseFragment
import com.lpirro.launches.databinding.FragmentLaunchesBinding

class LaunchesTabFragment : BaseFragment<FragmentLaunchesBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLaunchesBinding
        get() = FragmentLaunchesBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTabs()
    }

    private fun setupTabs() {
        val adapter = LaunchesViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = resources.getString(R.string.tab_launches_upcoming)
                    tab.icon = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.selector_calendar_clock
                    )
                }
                1 -> {
                    tab.text = resources.getString(R.string.tab_launches_past)
                    tab.icon = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.selector_rocket
                    )
                }
            }
        }.attach()
    }
}
