package com.lpirro.launch_detail.mission.presentation.delegate

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.launch_detail.databinding.ItemMissionUnavailableBinding
import com.lpirro.launch_detail.mission.model.LaunchMissionItem
import com.lpirro.launch_detail.mission.model.MissionDetailsUnavailableUi

fun missionDetailsUnavailableDelegate() =
    adapterDelegateViewBinding<MissionDetailsUnavailableUi, LaunchMissionItem, ItemMissionUnavailableBinding>({ layoutInflater, root ->
        ItemMissionUnavailableBinding.inflate(layoutInflater, root, false)
    }) {}
