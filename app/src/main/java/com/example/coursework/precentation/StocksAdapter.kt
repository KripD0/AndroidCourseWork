package com.example.coursework.precentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.coursework.R
import com.example.coursework.data.entity.StockDescription
class StocksAdapter(
    private var stocks: List<StockDescription>,
    private val save: (String, Boolean) -> (Unit)
) :
    RecyclerView.Adapter<StocksAdapter.StockViewHolder>() {
    class StockViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stock_item, parent, false)
        return StockViewHolder(view)
    }
    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        if (stocks[position].ticket.isEmpty()) return
        val stock = stocks[position].ticket
        val textView = holder.view.findViewById<TextView>(R.id.text_view)
        val btn = holder.view.findViewById<ImageButton>(R.id.imageButton)
        setImgBtn(btn, stocks[position].favorit)
        textView.setOnClickListener {
            it.findNavController().navigate(R.id.stocksDescriptionFragment, Bundle().apply {
                putString("StockName", stock)
            })
        }
        btn.setOnClickListener {
            stocks[position].favorit = !stocks[position].favorit
            setImgBtn(btn, stocks[position].favorit)
            save(stock, stocks[position].favorit)
        }
        textView.text = stock
    }
    private fun setImgBtn(btn: ImageButton, favorites: Boolean) {
        if (favorites)
            btn.setImageResource(R.drawable.remove)
        else
            btn.setImageResource(R.drawable.add)
    }
    override fun getItemCount(): Int {
        return stocks.size
    }
    fun updateStocks(stocks: List<StockDescription>) {
        this.stocks = stocks
        notifyDataSetChanged()
    }
}