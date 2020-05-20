package dev.vikey89.categories.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.vikey89.categories.R
import dev.vikey89.categories.utils.inject
import kotlinx.android.synthetic.main.activity_categories.recycler_view_categories
import javax.inject.Inject

class CategoriesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: CategoriesViewModel

    private val recyclerViewCategories by lazy { recycler_view_categories }
    private val categoriesAdapter = CategoriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CategoriesViewModel::class.java)
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
