package com.todo.presentation.list

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.todo.databinding.ItemContentBinding
import com.todo.domain.model.Content

class ContentViewHolder(
    private val binding: ItemContentBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Content) {
        binding.item = item

        binding.contentCheckBox.paintFlags = if (item.isDone) {
            binding.contentCheckBox.paintFlags + Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            0
        }
    }
}