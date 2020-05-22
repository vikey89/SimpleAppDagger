package dev.vikey89.categories.ui.detailcategory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.vikey89.core.data.CategoriesRepository
import dev.vikey89.core.data.Category
import javax.inject.Inject

class DetailCategoryViewModel @Inject constructor(
    private val categoryRepository: CategoriesRepository
) : ViewModel() {

    private val _singleCategory = MutableLiveData<Category>()

    val observerInfoCategory: LiveData<Category> = _singleCategory

    fun loadInfoCategory(id: Int) {
        _singleCategory.value = categoryRepository.getCategories().find { category -> category.id == id }
    }
}