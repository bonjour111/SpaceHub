package com.lpirro.launch_detail.overview.presentation.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.launch_detail.databinding.ItemTrajectoryBinding
import com.lpirro.launch_detail.overview.model.LaunchOverviewItem
import com.lpirro.launch_detail.overview.model.TrajectoryUi

fun trajectoryDelegate(itemClickedListener: (String) -> Unit) = adapterDelegateViewBinding<TrajectoryUi, LaunchOverviewItem, ItemTrajectoryBinding>(
    { layoutInflater, root -> ItemTrajectoryBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        itemView.setOnClickListener { itemClickedListener.invoke(item.flightClubUrl) }
    }
}
