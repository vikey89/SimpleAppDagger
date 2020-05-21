package dev.vikey89.categories.ui.detailcategory

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.vikey89.categories.R
import dev.vikey89.categories.ui.detailcategory.di.inject
import kotlinx.android.synthetic.main.detail_category_fragment.id_field
import kotlinx.android.synthetic.main.detail_category_fragment.name_field
import javax.inject.Inject

class DetailCategoryFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: DetailCategoryViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_category_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailCategoryViewModel::class.java)

        viewModel.observerInfoCategory.observe(viewLifecycleOwner, Observer { category ->
            id_field.text = category.id.toString()
            name_field.text = category.name
        })

        val id = arguments?.getInt(ID_EXTRA, -1) ?: -1
        viewModel.loadInfoCategory(id)
    }

    companion object {

        private const val ID_EXTRA = "DetailCategoryFragment.idExtra"

        fun newInstance(id: Int) = DetailCategoryFragment().apply {
            arguments = Bundle().apply {
                putInt(ID_EXTRA, id)
            }
        }
    }
}
