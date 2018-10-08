package com.example.alexey.currency.main.adapter

import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.alexey.currency.R
import com.example.alexey.currency.base.format
import com.example.alexey.currency.base.hideKeyboard
import com.example.alexey.currency.base.inflate
import com.example.alexey.currency.base.safeToBigDecimal
import com.example.alexey.currency.main.adapter.SimpleDelegateAdapter.Companion.INPUT_DEBOUNCE
import com.jakewharton.rxbinding2.widget.RxTextView
import com.mvideo.rtd_android.core.adapter.BaseHolder
import com.mvideo.rtd_android.core.adapter.IDelegateAdapter
import com.mvideo.rtd_android.core.adapter.IItemType
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import kotlinx.android.synthetic.main.item_base.view.*
import kotlinx.android.synthetic.main.item_simple.view.*
import java.math.BigDecimal
import java.util.*
import java.util.concurrent.TimeUnit


/**
 * Created by Alexey Osminin on 06.10.2018.
 */
class SimpleDelegateAdapter : IDelegateAdapter {

    companion object {
        const val INPUT_DEBOUNCE = 200L //millis
    }

    override fun onCreateViewHolder(parent: ViewGroup) = MainHolder(parent)

    class MainHolder(parent: ViewGroup) : BaseHolder(parent.inflate(R.layout.item_simple)) {
        override fun bind(item: IItemType) = with(itemView) {
            super.bind(item)
            item as CurrencyItem
            code.text = item.currency.currency.string
            name.setText(item.nameId)
            value.text =  item.currency.value.format()
            Glide.with(context).load(item.imageId).apply(RequestOptions.circleCropTransform()).into(icon)
            Unit
        }

        override fun unbind() {}
    }
}

class BaseItemDelegateAdapter(private val baseValueListener: (value: BigDecimal) -> Unit) : IDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = BaseItemHolder(parent, baseValueListener)

    class BaseItemHolder(parent: ViewGroup, private val baseValueListener: (value: BigDecimal) -> Unit) : BaseHolder(parent.inflate(R.layout.item_base)) {

        private var disposable = Disposables.disposed()

        override fun bind(item: IItemType) = with(itemView) {
            super.bind(item)
            item as CurrencyItem
            codeBase.text = item.currency.currency.string
            nameBase.setText(item.nameId)
            valueEdit.apply {
                setText(item.currency.value.format())
                setSelection(text.length)
            }
            disposable = RxTextView.textChanges(valueEdit)
                    .debounce(INPUT_DEBOUNCE, TimeUnit.MILLISECONDS)
                    .map { it.toString().safeToBigDecimal() }
                    .distinctUntilChanged()
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnDispose { hideKeyboard() }
                    .subscribe { baseValueListener(it) }

            Glide.with(context).load(item.imageId).apply(RequestOptions.circleCropTransform()).into(iconBase)
            Unit
        }

        override fun unbind() {
            disposable.dispose()
        }
    }
}
