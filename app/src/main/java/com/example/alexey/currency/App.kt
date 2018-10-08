package com.example.alexey.currency

import android.app.Application
import com.example.alexey.currency.data.RepositoryModule
import com.example.alexey.currency.data.network.NetworkModule
import com.example.alexey.currency.main.MainModule
import timber.log.Timber
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.registries.FactoryRegistryLocator
import toothpick.registries.MemberInjectorRegistryLocator

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //init Timber logger
            Timber.plant(Timber.DebugTree())
            // init Toothpick DI
            Toothpick.setConfiguration(Configuration.forDevelopment()
                    .disableReflection())
        } else {
            Toothpick.setConfiguration(Configuration.forProduction()
                    .disableReflection())
        }
        MemberInjectorRegistryLocator.setRootRegistry(com.example.alexey.currency.MemberInjectorRegistry())
        FactoryRegistryLocator.setRootRegistry(com.example.alexey.currency.FactoryRegistry())
        val appScope = Toothpick.openScope(this)
        appScope.installModules(NetworkModule(), RepositoryModule())
        Toothpick.inject(this, appScope)
    }
}