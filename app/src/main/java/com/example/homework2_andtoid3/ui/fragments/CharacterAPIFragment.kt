package com.example.homework2_andtoid3.ui.fragments

import com.example.homework2_andtoid3.ui.adapters.CharacterAPIAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework2_andtoid3.databinding.FragmentCharacterAPIBinding

class CharacterAPIFragment : Fragment() {

    private lateinit var binding: FragmentCharacterAPIBinding
    private val characterAPIAdapter = CharacterAPIAdapter()
    private var viewModel: CharacterAPIViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterAPIBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[CharacterAPIViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpObserve()
    }

    private fun initialize() {
        binding.characterRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAPIAdapter
        }
    }

    private fun setUpObserve() {
        viewModel?.fetchCharacters()?.observe(viewLifecycleOwner) {
            characterAPIAdapter.submitList(it?.result)
        }
    }

}