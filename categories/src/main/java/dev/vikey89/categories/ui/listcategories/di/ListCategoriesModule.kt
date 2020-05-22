package dev.vikey89.categories.ui.listcategories.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.vikey89.categories.ui.listcategories.ListCategoriesViewModel
import dev.vikey89.core.ViewModelKey

@Module
abstract class ListCategoriesModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListCategoriesViewModel::class)
    internal abstract fun bindListCategoriesViewModel(viewModel: ListCategoriesViewModel): ViewModel
}