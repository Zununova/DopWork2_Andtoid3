package com.example.homework2_andtoid3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework2_andtoid3.databinding.OneItemBinding
import com.example.homework2_andtoid3.models.CharacterModel

class CharacterAPIAdapter :
    ListAdapter<CharacterModel, CharacterAPIAdapter.ViewHolder>(DiffUtilCallback()) {
    class ViewHolder(private val binding: OneItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: CharacterModel?) {
            Glide.with(binding.itemCharacterImage).load(item?.image)
                .into(binding.itemCharacterImage)
            binding.textViewCharacter.text = item?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            OneItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
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