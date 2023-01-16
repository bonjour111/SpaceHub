package com.lpirro.core.ui.recyclerview

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class GenericViewHolder<T : ViewBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
