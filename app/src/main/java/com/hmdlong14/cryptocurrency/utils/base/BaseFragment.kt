package com.hmdlong14.cryptocurrency.utils.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hmdlong14.cryptocurrency.utils.Constants.VIEW_BINDING_EXCEPTION
import com.hmdlong14.cryptocurrency.utils.exceptions.NullViewBindingException


typealias FragmentInflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T


abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: FragmentInflate<VB>
) : Fragment() {
    private var _binding : VB? = null
    protected val binding
        get() = _binding ?: throw NullViewBindingException(VIEW_BINDING_EXCEPTION)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        initView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    abstract fun initView()
    abstract fun initData()
}
