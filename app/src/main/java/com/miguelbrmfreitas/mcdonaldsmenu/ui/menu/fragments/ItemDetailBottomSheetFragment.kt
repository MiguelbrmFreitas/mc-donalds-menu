package com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.miguelbrmfreitas.mcdonaldsmenu.ui.menu.viewmodel.MenuListViewModel
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.miguelbrmfreitas.mcdonaldsmenu.BR
import com.miguelbrmfreitas.mcdonaldsmenu.R
import com.miguelbrmfreitas.mcdonaldsmenu.databinding.BottomSheetItemDetailBinding
import com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.extensions.addOnPropertyChanged
import com.miguelbrmfreitas.mcdonaldsmenu.ui.utils.extensions.setImageUrl

class ItemDetailBottomSheetFragment : BottomSheetDialogFragment()
{
    private val viewModel: MenuListViewModel by activityViewModels()

    private lateinit var bottomSheetBinding: BottomSheetItemDetailBinding

    private lateinit var bottomSheetDialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        bottomSheetBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.bottom_sheet_item_detail,
            container,
            true
        )

        bottomSheetBinding.setLifecycleOwner { this.lifecycle }
        bottomSheetBinding.setVariable(BR.viewModel, this.viewModel)
        bottomSheetBinding.executePendingBindings()

        return bottomSheetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomSheetBehavior = BottomSheetBehavior.from(view.parent as View)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        observeFields()
        viewModel.setBottomSheetData()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        return bottomSheetDialog
    }

    private fun observeFields() {
        viewModel.itemDetailData.imageUrl.addOnPropertyChanged {
            it.get()?.let { url ->
                bottomSheetBinding.ivItem.setImageUrl(requireActivity(), url)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.menuListData.bottomSheetVisibility.set(false)
    }
}