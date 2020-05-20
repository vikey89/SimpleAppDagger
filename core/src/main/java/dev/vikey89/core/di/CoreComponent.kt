package dev.vikey89.core.di

import dagger.Component
import dev.vikey89.core.data.CategoriesRepository
import dev.vikey89.core.data.RetailersRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(): CoreComponent
    }

    fun provideRetailersRepository(): RetailersRepository

    fun provideCategoriesRepository(): CategoriesRepository
}