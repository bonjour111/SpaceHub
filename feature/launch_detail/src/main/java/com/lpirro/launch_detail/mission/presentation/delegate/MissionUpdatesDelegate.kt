package com.lpirro.launch_detail.mission.presentation.delegate

import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.core.ui.recyclerview.decorator.VerticalSpaceItemDecoration
import com.lpirro.launch_detail.R
import com.lpirro.launch_detail.databinding.ItemMissionUpdatesBinding
import com.lpirro.launch_detail.mission.model.LaunchMissionItem
import com.lpirro.launch_detail.mission.model.UpdatesUi
import com.lpirro.launch_detail.mission.presentation.delegate.adapter.UpdateAdapter

fun missionUpdatesDelegate() =
    adapterDelegateViewBinding<UpdatesUi, LaunchMissionItem, ItemMissionUpdatesBinding>({ layoutInflater, root ->
        ItemMissionUpdatesBinding.inflate(layoutInflater, root, false)
    }) {
        bind {
            val edgeSpacing = itemView.context.resources.getDimensionPixelSize(com.lpirro.core.R.dimen.margin_16dp)
            val spacing = itemView.context.resources.getDimensionPixelSize(com.lpirro.core.R.dimen.margin_12dp)
            val updateAdapter = UpdateAdapter()
            binding.missionUpdatesRecyclerView.adapter = updateAdapter
            binding.missionUpdatesRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
            binding.missionUpdatesRecyclerView.addItemDecoration(VerticalSpaceItemDecoration(edgeSpacing = edgeSpacing, spaceSize = spacing))
            updateAdapter.submitList(item.updates)
        }
    }
