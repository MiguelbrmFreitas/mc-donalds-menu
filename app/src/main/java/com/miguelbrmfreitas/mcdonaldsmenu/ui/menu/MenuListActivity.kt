package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miguelbrmfreitas.mcdonaldsmenu.R
import com.miguelbrmfreitas.mcdonaldsmenu.ui.base.BaseActivity

class MenuListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)
    }
}