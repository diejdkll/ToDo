package com.todo.presentation.list

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.todo.databinding.ItemContentBinding
import com.todo.domain.model.Content
import com.todo.presentation.ui.MainActivity

class ContentViewHolder(
    private val binding: ItemContentBinding,
    private val handler: MainActivity.Handler
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Content) {
        binding.item = item
        binding.handler = handler

        binding.contentCheckBox.paintFlags = if (item.isDone) {
            binding.contentCheckBox.paintFlags + Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            0
        }
    }
}