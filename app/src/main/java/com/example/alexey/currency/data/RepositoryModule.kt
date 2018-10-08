package com.example.alexey.currency.data

import com.example.alexey.currency.data.local.IMemoryRepository
import com.example.alexey.currency.data.local.MemoryRepositoryImpl
import com.example.alexey.currency.data.network.IRemoteRepository
import com.example.alexey.currency.data.network.RemoteRepositoryImpl
import com.example.alexey.currency.data.polling.IPollingInteractor
import com.example.alexey.currency.data.polling.PollingInteractorImpl
import toothpick.config.Module

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
class RepositoryModule : Module() {
    init {
        bind(IRepository::class.java).to(RepositoryImpl::class.java).singletonInScope()
        bind(IPollingInteractor::class.java).to(PollingInteractorImpl::class.java).singletonInScope()
        bind(IMemoryRepository::class.java).to(MemoryRepositoryImpl::class.java).singletonInScope()
        bind(IRemoteRepository::class.java).to(RemoteRepositoryImpl::class.java).singletonInScope()
    }
}