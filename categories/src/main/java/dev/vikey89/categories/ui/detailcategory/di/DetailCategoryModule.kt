package dev.vikey89.categories.ui.detailcategory.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.vikey89.categories.ui.detailcategory.DetailCategoryViewModel
import dev.vikey89.core.ViewModelKey

@Module
abstract class DetailCategoryModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailCategoryViewModel::class)
    internal abstract fun bindDetailCategoryViewModel(viewModel: DetailCategoryViewModel): ViewModel
}