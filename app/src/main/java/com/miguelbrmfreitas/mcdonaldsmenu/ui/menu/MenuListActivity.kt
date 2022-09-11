package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.miguelbrmfreitas.mcdonaldsmenu.R
import com.miguelbrmfreitas.mcdonaldsmenu.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuListActivity : AppCompatActivity() {

    private val menuListViewModel: MenuListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)

        menuListViewModel.setupView()
    }
}