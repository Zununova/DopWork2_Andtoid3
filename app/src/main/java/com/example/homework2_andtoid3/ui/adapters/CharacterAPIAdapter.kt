package com.example.homework2_andtoid3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework2_andtoid3.databinding.BottomButtonBinding
import com.example.homework2_andtoid3.databinding.OneItemBinding
import com.example.homework2_andtoid3.models.CharacterModel

class CharacterAPIAdapter :
    ListAdapter<CharacterModel, RecyclerView.ViewHolder>(DiffUtilCallback()) {

    companion object {
        private const val VIEW_TYPE_ITEM = 0
        private const val VIEW_TYPE_BUTTON = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                val binding = OneItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ViewHolder(binding)
            }
            VIEW_TYPE_BUTTON -> {
                val binding = BottomButtonBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ButtonViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> holder.bind(getItem(position))
            is ButtonViewHolder -> holder.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == itemCount - 1) {
            VIEW_TYPE_BUTTON
        } else {
            VIEW_TYPE_ITEM
        }
    }

    inner class ViewHolder(private val binding: OneItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterModel?) {
            Glide.with(binding.itemCharacterImage)
                .load(item?.image)
                .into(binding.itemCharacterImage)
            binding.textViewCharacter.text = item?.name
        }
    }

    inner class ButtonViewHolder(private val binding: BottomButtonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {

            binding.bottomButton.setOnClickListener {
                val recyclerView = binding.root.parent as RecyclerView
                recyclerView.smoothScrollToPosition(0)
            }
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<CharacterModel>() {
        override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem == newItem
        }
    }
}
