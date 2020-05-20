package dev.vikey89.categories.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.vikey89.categories.R
import dev.vikey89.core.data.Category
import kotlinx.android.synthetic.main.item_category.view.category_id
import kotlinx.android.synthetic.main.item_category.view.category_name

class CategoriesAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    private val categories = mutableListOf<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)

        return CategoryViewHolder(layout)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.fill(category)
    }

    fun updateCategories(newCategories: List<Category>) {
        categories.addAll(newCategories)
        notifyDataSetChanged()
    }
}

class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val idView by lazy { view.category_id }
    private val nameView by lazy { view.category_name }

    fun fill(category: Category) {
        idView.text = category.id.toString()
        nameView.text = category.name
    }
}
