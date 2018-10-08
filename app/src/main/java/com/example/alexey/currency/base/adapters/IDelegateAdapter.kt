package com.mvideo.rtd_android.core.adapter

import android.view.ViewGroup

/**
 * Created by Alexey Osminin on 06.10.2018.
 */
interface IDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): BaseHolder
}