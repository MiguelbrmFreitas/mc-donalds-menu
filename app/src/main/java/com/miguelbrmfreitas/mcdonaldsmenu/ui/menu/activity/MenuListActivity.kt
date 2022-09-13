package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.activity

import android.os.Bundle
import com.miguelbrmfreitas.mcdonaldsmenu.R
import com.miguelbrmfreitas.mcdonaldsmenu.BR
import com.miguelbrmfreitas.mcdonaldsmenu.ui.base.BaseActivity
import com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.fragments.ItemDetailBottomSheetFragment
import com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.viewmodel.MenuListViewModel
import com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.extensions.addOnPropertyChanged
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuListActivity() : BaseActivity<MenuListViewModel>() {

    companion object {
        const val MENU_TAG = "MENU_LIST"
    }

    override val viewModel: MenuListViewModel by viewModel(owner = this)

    override fun layoutId() = R.layout.activity_menu_list

    override fun bindingVariable() = BR.viewModel

    private val itemDetailBottomSheetFragment by lazy { ItemDetailBottomSheetFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.startView()
        observeFields()
    }

    private fun observeFields() {
        viewModel.menuListData.bottomSheetVisibility.addOnPropertyChanged {
            it.get()?.let { show ->
                if(show) {
                    itemDetailBottomSheetFragment.show(supportFragmentManager, MENU_TAG)
                }
            }
        }
    }
}