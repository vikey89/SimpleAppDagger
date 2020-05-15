package dev.vikey89.categories.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.vikey89.categories.R
import kotlinx.android.synthetic.main.activity_categories.recycler_view_categories

class CategoriesActivity : AppCompatActivity() {

    private lateinit var viewModel: CategoriesViewModel
    private val recyclerViewCategories by lazy { recycler_view_categories }
    private val categoriesAdapter = CategoriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        viewModel = ViewModelProvider(this, ViewModelFactory()).get(CategoriesViewModel::class.java)

        recyclerViewCategories.setup()
        with(viewModel) {
            observerCategories()
            load()
        }
    }

    private fun RecyclerView.setup() = apply {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this@CategoriesActivity)
        adapter = categoriesAdapter
    }

    private fun CategoriesViewModel.observerCategories() {
        observerCategories.observe(this@CategoriesActivity, Observer { categories ->
            categoriesAdapter.updateCategories(categories)
        })
    }
}
