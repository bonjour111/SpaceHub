package com.lpirro.launch_detail.overview.presentation.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.core.extensions.visible
import com.lpirro.launch_detail.databinding.ItemCountdownHeaderBinding
import com.lpirro.launch_detail.overview.model.CountdownHeaderUi
import com.lpirro.launch_detail.overview.model.LaunchOverviewItem

fun countDownHeaderDelegate(addToCalendarListener: (launchName: String, launchDateMillis: Long) -> Unit) =
    adapterDelegateViewBinding<CountdownHeaderUi, LaunchOverviewItem, ItemCountdownHeaderBinding>(
        { layoutInflater, root -> ItemCountdownHeaderBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.launchDate.text = item.launchDate
            item.netMillis?.let { netMillis ->
                binding.launchCountdownView.visible = netMillis - System.currentTimeMillis() > 0
                binding.launchCountdownView.startCountdown(netMillis)
                binding.addToCalendarButton.setOnClickListener {
                    addToCalendarListener.invoke(item.name, netMillis)
                }
            }
        }
    }
