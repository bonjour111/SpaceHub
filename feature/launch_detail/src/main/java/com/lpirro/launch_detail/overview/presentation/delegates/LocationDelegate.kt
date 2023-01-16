package com.lpirro.launch_detail.overview.presentation.delegates

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.lpirro.launch_detail.databinding.ItemLocationBinding
import com.lpirro.launch_detail.overview.model.LaunchOverviewItem
import com.lpirro.launch_detail.overview.model.LocationUi

fun locationDelegate() =
    adapterDelegateViewBinding<LocationUi, LaunchOverviewItem, ItemLocationBinding>(
        { layoutInflater, root -> ItemLocationBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.mapsCardValue.text = item.name
            binding.googleMap.onCreate(null)
            binding.googleMap.onResume()
            binding.googleMap.getMapAsync { map ->
                map.addMarker(MarkerOptions().position(item.latLng))
                map.moveCamera(CameraUpdateFactory.newLatLng(item.latLng))
                map.uiSettings.isMapToolbarEnabled = false
            }
        }
    }
