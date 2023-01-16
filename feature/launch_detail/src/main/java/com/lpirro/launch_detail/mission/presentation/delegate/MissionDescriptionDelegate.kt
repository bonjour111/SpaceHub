package com.lpirro.launch_detail.mission.presentation.delegate

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.core.extensions.visible
import com.lpirro.launch_detail.databinding.ItemMissionDescriptionBinding
import com.lpirro.launch_detail.mission.model.DescriptionUi
import com.lpirro.launch_detail.mission.model.LaunchMissionItem

fun missionDescriptionDelegate(infoUrlClickListener: (url: String) -> Unit) =
    adapterDelegateViewBinding<DescriptionUi, LaunchMissionItem, ItemMissionDescriptionBinding>({ layoutInflater, root ->
        ItemMissionDescriptionBinding.inflate(layoutInflater, root, false)
    }) {
        bind {
            binding.missionDescriptionValue.text = item.description
            binding.missionDescriptionMoreButton.visible = item.infoUrl != null
            binding.missionDescriptionMoreButton.setOnClickListener {
                infoUrlClickListener.invoke(item.infoUrl!!)
            }
        }
    }
