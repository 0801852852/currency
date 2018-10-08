package com.example.alexey.currency.data

import com.example.alexey.currency.data.local.IMemoryRepository
import com.example.alexey.currency.data.local.model.CurrencyLocal
import com.example.alexey.currency.data.polling.IPollingInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
class RepositoryImpl @Inject constructor(private val polling: IPollingInteractor,
                                         private val memoryRepo: IMemoryRepository) : IRepository {

    override fun getCurrencyObservable(base: CurrencyLocal): Observable<List<CurrencyLocal>> {
        //on start it will send cached items immediately in case cache exists
        return Observable.concat(memoryRepo.getItems(base).toObservable(),
                //after that it switches on fetching of fresh currency list
                polling.getPollingObservable(base)
                        //save items for future using
                        .doOnNext(memoryRepo::saveItems))
                //in case if memoryRepo returns single base item
                .filter { it.size > 1 }

    }
}