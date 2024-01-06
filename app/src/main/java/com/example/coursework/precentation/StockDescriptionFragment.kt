package com.example.coursework.precentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coursework.databinding.FragmentStockDescriptionBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
class StockDescriptionFragment : Fragment() {
    private lateinit var binding: FragmentStockDescriptionBinding
    private val viewModel by viewModel<StockDescriptionViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStockDescriptionBinding.inflate(inflater)
        binding.model = viewModel
        binding.lifecycleOwner = this
        val ticket = arguments?.getString("StockName", "")
        viewModel.favorite = arguments?.getBoolean("Favorite", false) == true
        binding.ticket.text = ticket
        viewModel.getStockInfo(ticket)
        return binding.root
    }
}