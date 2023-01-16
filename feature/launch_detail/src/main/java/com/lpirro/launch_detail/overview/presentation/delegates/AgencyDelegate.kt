package com.lpirro.launch_detail.overview.presentation.delegates

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.core.extensions.countryCodeToEmoji
import com.lpirro.core.util.glide.RemovePaddingTransformation
import com.lpirro.launch_detail.databinding.ItemAgencyBinding
import com.lpirro.launch_detail.overview.model.AgencyUi
import com.lpirro.launch_detail.overview.model.LaunchOverviewItem

@SuppressLint("SetTextI18n")
fun agencyDelegate() =
    adapterDelegateViewBinding<AgencyUi, LaunchOverviewItem, ItemAgencyBinding>({ layoutInflater, root ->
        ItemAgencyBinding.inflate(layoutInflater, root, false)
    }) {
        bind {
            binding.agencyNameValue.text = item.name
            binding.agencyCountryValue.text =
                "${item.countryCode} ${item.countryCode.countryCodeToEmoji()}"
            binding.agencyAdministratorValue.text = item.administrator
            binding.agencyFoundedValue.text = item.foundingYear
            binding.agencyTotalLaunchesValue.text = item.totalLaunchCount
            Glide.with(itemView.context)
                .load(item.logoUrl)
                .transform(RemovePaddingTransformation())
                .into(binding.agencyLogo)
        }
    }
