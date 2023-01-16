package com.lpirro.launch_detail.overview.presentation.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.core.extensions.visible
import com.lpirro.launch_detail.databinding.ItemLaunchpadBinding
import com.lpirro.launch_detail.overview.model.LaunchOverviewItem
import com.lpirro.launch_detail.overview.model.LaunchpadUi

fun launchpadDelegate(
    mapsClickListener: (String) -> Unit,
    wikipediaClickListener: (String) -> Unit,
    infoClickListener: (String) -> Unit
) = adapterDelegateViewBinding<LaunchpadUi, LaunchOverviewItem, ItemLaunchpadBinding>(
    { layoutInflater, root -> ItemLaunchpadBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.launchPadNameValue.text = item.name
        binding.launchPadLocationValue.text = item.locationName
        binding.launchPadTotalLaunchesValue.text = item.totalLaunchCount
        binding.chipInfo.visible = item.infoUrl?.isNotEmpty() ?: false
        binding.chipMaps.visible = item.mapUrl?.isNotEmpty() ?: false
        binding.chipWikipedia.visible = item.wikiUrl?.isNotEmpty() ?: false
        binding.chipMaps.setOnClickListener {
            mapsClickListener.invoke(item.mapUrl!!)
        }
        binding.chipWikipedia.setOnClickListener {
            wikipediaClickListener.invoke(item.wikiUrl!!)
        }
        binding.chipInfo.setOnClickListener {
            infoClickListener.invoke(item.infoUrl!!)
        }
    }
}
