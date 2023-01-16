package com.lpirro.launches.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.lpirro.domain.models.Launch
import com.lpirro.domain.models.Status
import com.lpirro.launches.CountdownTimerTextView
import com.lpirro.launches.R
import com.lpirro.launches.databinding.ItemLaunchBinding

class LaunchesAdapter(
    private val launchClick: (launchId: String) -> Unit,
    private val launchStatusClick: (status: Status) -> Unit,
) :
    ListAdapter<Launch, LaunchesAdapter.LaunchesViewHolder>(LaunchDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchesViewHolder {
        val binding = ItemLaunchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LaunchesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaunchesViewHolder, position: Int) {
        val launch = getItem(position)

        holder.binding.launchTitle.text = launch.name
        holder.binding.agencyName.text = launch.launchServiceProvider.name
        holder.binding.location.text = launch.pad.location.name
        holder.binding.date.text = launch.net
        holder.binding.status.text = launch.status.abbrev

        holder.binding.status.setOnClickListener { launchStatusClick.invoke(launch.status) }
        holder.itemView.setOnClickListener { launchClick.invoke(launch.id) }

        val roundCornerSize =
            holder.itemView.context.resources.getDimensionPixelSize(R.dimen.launch_image_corners)

        val requestOptions = RequestOptions().transform(CenterCrop(), RoundedCorners(roundCornerSize))

        Glide.with(holder.itemView.context)
            .load(launch.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .apply(requestOptions)
            .into(holder.binding.launchImage)

        holder.countdownTimerTextView?.cancel()

        holder.countdownTimerTextView =
            CountdownTimerTextView(launch.netMillis!!, System.currentTimeMillis(), holder.binding.countdownText) // TODO remove evils operator !!
        holder.countdownTimerTextView?.start()
    }

    inner class LaunchesViewHolder(val binding: ItemLaunchBinding) : RecyclerView.ViewHolder(binding.root) {
        var countdownTimerTextView: CountdownTimerTextView? = null
    }
}
