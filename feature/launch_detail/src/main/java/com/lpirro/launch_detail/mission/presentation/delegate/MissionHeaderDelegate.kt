package com.lpirro.launch_detail.mission.presentation.delegate

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.core.util.glide.RemovePaddingTransformation
import com.lpirro.launch_detail.R
import com.lpirro.launch_detail.databinding.ItemMissionHeaderBinding
import com.lpirro.launch_detail.mission.model.LaunchMissionItem
import com.lpirro.launch_detail.mission.model.MissionHeaderUi

fun missionHeaderDelegate() =
    adapterDelegateViewBinding<MissionHeaderUi, LaunchMissionItem, ItemMissionHeaderBinding>({ layoutInflater, root ->
        ItemMissionHeaderBinding.inflate(layoutInflater, root, false)
    }) {
        bind {
            val resources = context.resources
            binding.missionName.text = item.name
            binding.missionOrbit.text = resources.getString(R.string.mission_header_orbit, item.orbit)
            binding.missionType.text = resources.getString(R.string.mission_header_type, item.missionType)
            binding.missionAgency.text = resources.getString(R.string.mission_header_agency, item.agencyName)

            Glide.with(itemView.context)
                .load(item.missionPatchUrl)
                .transform(RemovePaddingTransformation())
                .into(binding.missionPatchImage)
        }
    }
