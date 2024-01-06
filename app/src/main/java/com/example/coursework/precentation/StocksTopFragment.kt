package com.example.coursework.precentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coursework.databinding.FragmentStocksBinding
import com.example.coursework.domain.utils.Rezult
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
class StocksTopFragment : Fragment() {
    private val viewModel by viewModel<StocksTopViewModel>()
    private lateinit var viewAdapter: StocksAdapter
    private lateinit var binding: FragmentStocksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStocksBinding.inflate(inflater)
        binding.model = viewModel
        viewAdapter = StocksAdapter(listOf()) { ticket: String, favorite: Boolean ->
            viewModel.saveStockDescriptionBd(
                ticket,
                favorite
            )
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(binding.recyclerView.context)
        binding.recyclerView.adapter = viewAdapter
        viewModel.getTopStocks()
        updateListName()
        return binding.root
    }
    private fun updateListName() {
        lifecycleScope.launch {
            viewModel.topStocks.onEach {
                when (it) {
                    is Rezult.Success ->
                        viewAdapter.updateStocks(it.data)
                    is Rezult.Error -> {
                    }
                }
            }.collect()
        }
    }
}