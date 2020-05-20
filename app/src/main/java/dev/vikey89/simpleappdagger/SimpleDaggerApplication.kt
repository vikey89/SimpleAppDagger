package dev.vikey89.simpleappdagger

import android.app.Application
import dev.vikey89.core.di.CoreComponent
import dev.vikey89.core.di.CoreComponentProvider
import dev.vikey89.core.di.DaggerCoreComponent

class SimpleDaggerApplication : Application(),
    CoreComponentProvider {

    private val coreComponent by lazy {
        DaggerCoreComponent.create()
    }

    override fun provideCoreComponent(): CoreComponent = coreComponent
}