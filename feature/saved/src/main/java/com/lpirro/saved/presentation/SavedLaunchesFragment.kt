package com.lpirro.saved.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lpirro.core.base.BaseFragment
import com.lpirro.saved.databinding.FragmentSavedLaunchesBinding

class SavedLaunchesFragment : BaseFragment<FragmentSavedLaunchesBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSavedLaunchesBinding
        get() = FragmentSavedLaunchesBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
