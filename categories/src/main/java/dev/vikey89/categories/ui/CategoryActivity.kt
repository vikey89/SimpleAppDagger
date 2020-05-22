@file:Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")

package dev.vikey89.categories.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.vikey89.categories.R
import dev.vikey89.categories.ui.detailcategory.DetailCategoryFragment
import dev.vikey89.categories.di.inject
import dev.vikey89.categories.ui.listcategories.ListCategoriesFragment
import javax.inject.Inject

class CategoryActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CategoryViewModel::class.java)
        viewModel.observerStatusView()
    }

    private fun CategoryViewModel.observerStatusView() {
        observerStatusView.observe(this@CategoryActivity, Observer { statusView ->

            val fragment = when(statusView) {
                StatusView.ListCategories -> ListCategoriesFragment.newInstance()
                is StatusView.DetailCategory -> DetailCategoryFragment.newInstance(statusView.id)
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
        })
    }
}
