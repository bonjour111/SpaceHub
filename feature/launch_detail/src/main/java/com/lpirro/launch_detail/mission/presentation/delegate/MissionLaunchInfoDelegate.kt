package com.lpirro.launch_detail.mission.presentation.delegate

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.launch_detail.databinding.ItemMissonLaunchInfoBinding
import com.lpirro.launch_detail.mission.model.LaunchInfoUi
import com.lpirro.launch_detail.mission.model.LaunchMissionItem

fun missionLaunchInfoDelegate() =
    adapterDelegateViewBinding<LaunchInfoUi, LaunchMissionItem, ItemMissonLaunchInfoBinding>({ layoutInflater, root ->
        ItemMissonLaunchInfoBinding.inflate(layoutInflater, root, false)
    }) {
        bind {
            binding.launchStatusView.text = item.status
            binding.launchStatusDescription.text = item.statusDescription
            binding.netValue.text = item.net
            binding.windowStartValue.text = item.windowStart
            binding.windowEndValue.text = item.windowEnd
        }
    }
