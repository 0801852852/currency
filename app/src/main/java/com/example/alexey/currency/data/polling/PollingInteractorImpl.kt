package com.example.alexey.currency.data.polling

import com.example.alexey.currency.data.local.model.CurrencyLocal
import com.example.alexey.currency.data.network.IRemoteRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
class PollingInteractorImpl @Inject constructor(private val repo: IRemoteRepository) : IPollingInteractor {

    companion object {
        private const val POLLING_INTERVAL = 1L //Seconds
    }

    override fun getPollingObservable(base: CurrencyLocal) = Observable.interval(0, POLLING_INTERVAL, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .flatMapSingle { repo.getCurrencyRate(base) }
            .map {
                listOf(CurrencyLocal(base.currency, true, base.value)).plus(it)
            }!!
}