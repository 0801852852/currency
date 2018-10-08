package com.example.alexey.currency.main

import com.example.alexey.currency.data.IRepository
import com.example.alexey.currency.data.local.model.Currency
import com.example.alexey.currency.data.local.model.CurrencyLocal
import com.example.alexey.currency.main.adapter.CurrencyItem
import com.example.alexey.currency.main.adapter.getIcon
import com.example.alexey.currency.main.adapter.getName
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import timber.log.Timber
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
class MainPresenter @Inject constructor(private val view: MainContract.View,
                                        private val repo: IRepository) : MainContract.Presenter {

    companion object {
        private val DEFAULT_CURRENCY = Currency.EUR
    }

    private var baseItem = CurrencyLocal(DEFAULT_CURRENCY, true, BigDecimal.ONE)
    private var disposable = Disposables.disposed()
    private var needUpdateBaseItem: Boolean = true

    override fun start() {
        restartPolling()
    }

    override fun onItemClicked(item: CurrencyItem) {
        stopPolling()
        baseItem = CurrencyLocal(item.currency.currency, true, item.currency.value)
        needUpdateBaseItem = true
        restartPolling()
    }

    override fun stopPolling() {
        disposable.dispose()
    }

    override fun onBaseMultiplierChanged(value: BigDecimal) {
        if (baseItem.value != value) {
            baseItem = CurrencyLocal(baseItem.currency, baseItem.isBase, value)
            restartPolling()
        }
    }

    private fun restartPolling() {
        disposable.dispose()
        disposable = repo.getCurrencyObservable(baseItem)
                .map { items ->
                    items.map { item ->
                        if (item.isBase) {
                            CurrencyItem(item, getIcon(item.currency), getName(item.currency))
                        } else {
                            CurrencyItem(CurrencyLocal(item.currency, false, baseItem.value.multiply(item.value)),
                                    getIcon(item.currency), getName(item.currency))
                        }
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (needUpdateBaseItem) {
                        view.setInitItems(it)
                        needUpdateBaseItem = false
                    } else {
                        view.updateItems(it)
                    }
                }, {
                    Timber.e(it)
                })
    }
}

