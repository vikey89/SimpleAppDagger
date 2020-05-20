package dev.vikey89.retailers.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.vikey89.core.data.Retailer
import dev.vikey89.retailers.R
import kotlinx.android.synthetic.main.item_retailer.view.retailer_id
import kotlinx.android.synthetic.main.item_retailer.view.retailer_name

class RetailersAdapter : RecyclerView.Adapter<RetailersViewHolder>() {

    private val retailers = mutableListOf<Retailer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetailersViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_retailer, parent, false)

        return RetailersViewHolder(layout)
    }

    override fun getItemCount() = retailers.size

    override fun onBindViewHolder(holder: RetailersViewHolder, position: Int) {
        val retailer = retailers[position]
        holder.fill(retailer)
    }

    fun updateRetailers(newCategories: List<Retailer>) {
        retailers.addAll(newCategories)
        notifyDataSetChanged()
    }
}

class RetailersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val idView by lazy { view.retailer_id }
    private val nameView by lazy { view.retailer_name }

    fun fill(retailer: Retailer) {
        idView.text = retailer.id.toString()
        nameView.text = retailer.name
    }
}
