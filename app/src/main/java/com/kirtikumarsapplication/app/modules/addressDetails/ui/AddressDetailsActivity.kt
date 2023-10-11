package com.kirtikumarsapplication.app.modules.addressDetails.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.databinding.ActivityAddressDetailsBinding
import com.kirtikumarsapplication.app.modules.addressDetails.`data`.viewmodel.AddressDetailsVMVM
import com.kirtikumarsapplication.app.modules.personalDetails.ui.PersonalDetailsActivity
import com.kirtikumarsapplication.app.modules.professional_details.ui.ProfessionalDetailsActivity
import com.kirtikumarsapplication.app.modules.splash_screen.data.model.SplashScreenModel
import kotlin.String
import kotlin.Unit

class AddressDetailsActivity :
    BaseActivity<ActivityAddressDetailsBinding>(R.layout.activity_address_details) {
  private val viewModel: AddressDetailsVMVM by viewModels<AddressDetailsVMVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.addressDetailsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.continueBtn.setOnClickListener {
      val destIntent = ProfessionalDetailsActivity.getIntent(this, null)
      if (binding.rbPlaceholdertex.isChecked) {
        SplashScreenModel.userDataDump.setIsRented("Owned")
      } else if (binding.rbPlaceholdertexOne.isChecked) {
        SplashScreenModel.userDataDump.setIsRented("Rented")
      }
      SplashScreenModel.userDataDump.setCurrentAddress(binding.etGroup48103701.text.toString())
      SplashScreenModel.userDataDump.setPermanentAddress(binding.etBuyHouse.text.toString())
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "AddressDetailsActivity"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AddressDetailsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
