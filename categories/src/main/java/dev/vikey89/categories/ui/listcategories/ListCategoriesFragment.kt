package dev.vikey89.categories.ui.listcategories

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import dev.vikey89.categories.R
import dev.vikey89.categories.ui.CategoryViewModel
import dev.vikey89.categories.ui.StatusView
import dev.vikey89.categories.ui.listcategories.di.inject
import kotlinx.android.synthetic.main.list_categories_fragment.recycler_view_categories
import javax.inject.Inject

class ListCategoriesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var categoryViewModel: CategoryViewModel

    private lateinit var viewModel: ListCategoriesViewModel

    private val categoriesAdapter by lazy {
        ListCategoriesAdapter { id ->
            categoryViewModel.changeView(StatusView.DetailCategory(id))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_categories_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryViewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(CategoryViewModel::class.java)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListCategoriesViewModel::class.java)

        recycler_view_categories.setup()
        with(viewModel) {
            observerCategories()
            load()
        }
    }

    private fun RecyclerView.setup() = apply {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(requireContext())
        adapter = categoriesAdapter
    }

    private fun ListCategoriesViewModel.observerCategories() {
        observerCategories.observe(viewLifecycleOwner, Observer { categories ->
            categoriesAdapter.updateCategories(categories)
        })
    }

    companion object {
        fun newInstance() = ListCategoriesFragment()
    }

}
