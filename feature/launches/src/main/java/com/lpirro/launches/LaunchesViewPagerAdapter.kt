package com.lpirro.launches

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lpirro.launches.past.presentation.PastLaunchesFragment
import com.lpirro.launches.upcoming.presentation.UpcomingLaunchesFragment

private const val NUM_TABS = 2

class LaunchesViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return UpcomingLaunchesFragment()
            1 -> return PastLaunchesFragment()
        }
        return UpcomingLaunchesFragment()
    }
}
