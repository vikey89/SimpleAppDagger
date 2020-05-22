package dev.vikey89.categories.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.vikey89.categories.ui.CategoryViewModel
import dev.vikey89.core.ViewModelFactory
import dev.vikey89.core.ViewModelKey

@Module
abstract class CategoryModule {

    @Binds
    internal abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    internal abstract fun bindCategoryViewModel(viewModel: CategoryViewModel): ViewModel

}