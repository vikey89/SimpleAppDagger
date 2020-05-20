package dev.vikey89.retailers.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.vikey89.core.ViewModelFactory
import dev.vikey89.core.ViewModelKey
import dev.vikey89.retailers.ui.RetailerViewModel

@Module
abstract class RetailerModule {

    @Binds
    internal abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RetailerViewModel::class)
    internal abstract fun retailersViewModel(viewModel: RetailerViewModel): ViewModel
}