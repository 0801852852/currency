package com.example.alexey.currency.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SimpleItemAnimator
import com.example.alexey.currency.R
import com.example.alexey.currency.main.adapter.CurrencyItem
import com.example.alexey.currency.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scope = Toothpick.openScopes(application, this)
        scope.installModules(MainModule(this))
        Toothpick.inject(this, scope)
        adapter = MainAdapter {
            presenter.onBaseMultiplierChanged(it)
        }
        adapter.itemClickListener = {
            presenter.onItemClicked(it as CurrencyItem)
        }
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = this@MainActivity.adapter
            setHasFixedSize(true)
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        }
        presenter.start()
    }

    override fun updateItems(items: List<CurrencyItem>) {
        adapter.items = items
        adapter.notifyItemRangeChanged(1, items.size)
    }

    override fun setInitItems(items: List<CurrencyItem>) {
        adapter.items = items
        adapter.notifyDataSetChanged()
        recyclerView.scrollToPosition(0)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.stopPolling()
        Toothpick.closeScope(this)
    }
}
