package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.miguelbrmfreitas.mcdonaldsmenu.R
import com.miguelbrmfreitas.mcdonaldsmenu.BR
import com.miguelbrmfreitas.mcdonaldsmenu.databinding.ActivityMenuListBinding
import com.miguelbrmfreitas.mcdonaldsmenu.ui.base.BaseActivity
import com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.viewmodel.MenuListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuListActivity() : BaseActivity<MenuListViewModel>() {

    override val viewModel: MenuListViewModel by viewModel(owner = this)

    override fun layoutId() = R.layout.activity_menu_list

    override fun bindingVariable() = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setupView()
    }
}