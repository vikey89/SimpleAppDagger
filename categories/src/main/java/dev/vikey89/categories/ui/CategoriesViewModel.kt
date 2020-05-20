package dev.vikey89.categories.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.vikey89.core.data.CategoriesRepository
import dev.vikey89.core.data.Category
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(
    private val categoryRepository: CategoriesRepository
) : ViewModel() {

    private val _categories = MutableLiveData<List<Category>>()

    val observerCategories: LiveData<List<Category>> = _categories

    fun load() {
        _categories.value = categoryRepository.getCategories()
    }
}