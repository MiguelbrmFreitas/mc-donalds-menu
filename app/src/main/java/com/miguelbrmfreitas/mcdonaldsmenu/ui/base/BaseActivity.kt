package com.miguelbrmfreitas.mcdonaldsmenu.ui.base

import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.miguelbrmfreitas.mcdonaldsmenu.databinding.ActivityMenuListBinding


abstract class BaseActivity<V : BaseViewModel> : AppCompatActivity()
{
    @LayoutRes
    abstract fun layoutId(): Int

    abstract val viewModel: V

    private lateinit var binding: ActivityMenuListBinding

    abstract fun bindingVariable(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setupDataBinding()
    }

    private fun setupDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId())
        binding.setLifecycleOwner { this.lifecycle }
        binding.setVariable(bindingVariable(), this.viewModel)
        binding.executePendingBindings()
    }
}