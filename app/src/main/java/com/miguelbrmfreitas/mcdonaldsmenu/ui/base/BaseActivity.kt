package com.miguelbrmfreitas.mcdonaldsmenu.ui.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity()
{
    lateinit var viewDataBinding: T

    @LayoutRes
    abstract fun layoutId(): Int

    abstract val viewModel: V

    abstract fun bindingVariable(): Int
}