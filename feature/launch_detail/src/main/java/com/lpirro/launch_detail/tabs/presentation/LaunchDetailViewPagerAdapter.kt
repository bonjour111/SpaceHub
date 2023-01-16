package com.lpirro.launch_detail.tabs.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lpirro.launch_detail.mission.presentation.LaunchDetailMissionFragment
import com.lpirro.launch_detail.overview.presentation.LaunchDetailOverviewFragment

private const val NUM_TABS = 3

class LaunchDetailViewPagerAdapter(
    private val launchId: String,
    fragmentActivity: FragmentActivity,
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return LaunchDetailOverviewFragment.newInstance(launchId)
            1 -> return LaunchDetailMissionFragment.newInstance(launchId)
            2 -> return LaunchDetailMissionFragment.newInstance(launchId)
        }
        return LaunchDetailOverviewFragment()
    }
}
