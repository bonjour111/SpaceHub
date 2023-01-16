package com.lpirro.launch_detail.mission.presentation.delegate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lpirro.core.ui.recyclerview.GenericViewHolder
import com.lpirro.domain.models.Update
import com.lpirro.launch_detail.databinding.ItemUpdateRowBinding

class UpdateAdapter : ListAdapter<Update, GenericViewHolder<ItemUpdateRowBinding>>(UpdateDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<ItemUpdateRowBinding> {
        val binding = ItemUpdateRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<ItemUpdateRowBinding>, position: Int) {
        val update = getItem(position)
        holder.binding.updateDate.text = update.createdOn
        holder.binding.updateComment.text = update.comment
    }
}
