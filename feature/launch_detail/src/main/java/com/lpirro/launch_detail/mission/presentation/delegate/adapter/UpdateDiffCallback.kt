package com.lpirro.launch_detail.mission.presentation.delegate.adapter

import androidx.recyclerview.widget.DiffUtil
import com.lpirro.domain.models.Update

object UpdateDiffCallback : DiffUtil.ItemCallback<Update>() {

    override fun areItemsTheSame(oldItem: Update, newItem: Update): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Update, newItem: Update): Boolean {
        return oldItem == newItem
    }
}
