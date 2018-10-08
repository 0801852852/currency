package com.example.alexey.currency.main

import com.example.alexey.currency.main.adapter.MainAdapter
import toothpick.config.Module

/**
 * Created by Alexey Osminin on 04.10.2018.
 */
class MainModule(view: MainContract.View) : Module() {
    init {
        bind(MainContract.Presenter::class.java).to(MainPresenter::class.java)
        bind(MainContract.View::class.java).toInstance(view)
    }
}