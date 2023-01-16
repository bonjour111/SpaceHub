package com.lpirro.launches.adapter

import androidx.recyclerview.widget.DiffUtil
import com.lpirro.domain.models.Launch

object LaunchDiffCallback : DiffUtil.ItemCallback<Launch>() {

    override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem == newItem
    }
}
