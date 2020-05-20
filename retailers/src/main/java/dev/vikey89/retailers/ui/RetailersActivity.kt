package dev.vikey89.retailers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.vikey89.retailers.R
import dev.vikey89.retailers.utils.inject
import kotlinx.android.synthetic.main.activity_retailers.recycler_view_retailers
import javax.inject.Inject

class RetailersActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: RetailerViewModel
    private val recyclerViewCategories by lazy { recycler_view_retailers }
    private val retailersAdapter = RetailersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retailers)
        viewModel = ViewModelProvider(this, viewModelFactory).get(RetailerViewModel::class.java)

        recyclerViewCategories.setup()
        with(viewModel) {
            observerCategories()
            load()
        }
    }

    private fun RecyclerView.setup() = apply {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this@RetailersActivity)
        adapter = retailersAdapter
    }

    private fun RetailerViewModel.observerCategories() {
        observerRetailers.observe(this@RetailersActivity, Observer { retailers ->
            retailersAdapter.updateRetailers(retailers)
        })
    }
}
