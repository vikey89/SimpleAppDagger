package dev.vikey89.categories.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.vikey89.categories.di.CategoryScope
import dev.vikey89.core.ext.default
import javax.inject.Inject

@CategoryScope
class CategoryViewModel @Inject constructor() : ViewModel() {

    private val _statusView = MutableLiveData<StatusView>().default(StatusView.ListCategories)

    val observerStatusView: LiveData<StatusView> = _statusView

    fun changeView(statusView: StatusView) {
        _statusView.value = statusView
    }
}

sealed class StatusView {

    object ListCategories : StatusView()

    data class DetailCategory(val id: Int) : StatusView()
}
