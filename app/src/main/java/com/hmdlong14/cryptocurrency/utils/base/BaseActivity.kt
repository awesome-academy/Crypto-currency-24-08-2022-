package com.hmdlong14.cryptocurrency.utils.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.hmdlong14.cryptocurrency.utils.Constants.VIEW_BINDING_EXCEPTION
import com.hmdlong14.cryptocurrency.utils.exceptions.NullViewBindingException

typealias ActivityInflate<T> = (LayoutInflater) -> T

abstract class BaseActivity<VB : ViewBinding>(
    private val activityInflate: ActivityInflate<VB>
) : AppCompatActivity() {
    private var _binding : VB? = null
    protected val binding
        get() = _binding ?: throw NullViewBindingException(VIEW_BINDING_EXCEPTION)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = activityInflate.invoke(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
    }

    abstract fun initView()
    abstract fun initData()
}
