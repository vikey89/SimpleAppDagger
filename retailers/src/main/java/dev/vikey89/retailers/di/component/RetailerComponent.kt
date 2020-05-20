package dev.vikey89.retailers.di.component

import dagger.Component
import dev.vikey89.core.di.CoreComponent
import dev.vikey89.retailers.di.module.RetailerModule
import dev.vikey89.retailers.ui.RetailersActivity
import dev.vikey89.retailers.utils.RetailerScope

@RetailerScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        RetailerModule::class
    ]
)
interface RetailerComponent {
    fun inject(activity: RetailersActivity)
}