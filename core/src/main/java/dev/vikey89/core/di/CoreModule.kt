package dev.vikey89.core.di

import dagger.Module
import dagger.Provides
import dev.vikey89.core.data.CategoriesRepository
import dev.vikey89.core.data.CategoriesRepositoryImpl
import dev.vikey89.core.data.RetailersRepository
import dev.vikey89.core.data.RetailersRepositoryImpl
import javax.inject.Singleton

@Module
class CoreModule {

    @Provides
    @Singleton
    fun provideRetailersRepository(): RetailersRepository = RetailersRepositoryImpl()

    @Provides
    @Singleton
    fun provideCategoriesRepository(): CategoriesRepository = CategoriesRepositoryImpl()
}
