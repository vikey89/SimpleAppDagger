package dev.vikey89.categories.di.component

import dagger.Component
import dev.vikey89.categories.di.module.CategoryModule
import dev.vikey89.categories.ui.CategoriesActivity
import dev.vikey89.categories.utils.CategoryScope
import dev.vikey89.core.di.CoreComponent

@CategoryScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        CategoryModule::class
    ]
)
interface CategoryComponent {

    fun inject(activity: CategoriesActivity)
}