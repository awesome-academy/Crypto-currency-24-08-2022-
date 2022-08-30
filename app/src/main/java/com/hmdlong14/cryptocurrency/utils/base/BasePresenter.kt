package com.hmdlong14.cryptocurrency.utils.base

interface BasePresenter<T> {
    fun onStart()
    fun onStop()
    fun setView(view: T?)
}
