package com.kirtikumarsapplication.app.modules.identity_proof.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.databinding.ActivityIdentityProofBinding
import com.kirtikumarsapplication.app.modules.identity_proof.`data`.viewmodel.IdentityProofVM
import com.kirtikumarsapplication.app.modules.addressDetails.ui.AddressDetailsActivity
import com.kirtikumarsapplication.app.modules.splash_screen.data.model.SplashScreenModel
import kotlin.String
import kotlin.Unit

class IdentityProofActivity :
    BaseActivity<ActivityIdentityProofBinding>(R.layout.activity_identity_proof) {
  private val viewModel: IdentityProofVM by viewModels<IdentityProofVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.identityProofVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.continueBtn.setOnClickListener {
      SplashScreenModel.userDataDump.setAadhaarNo(binding.etGroup48103694.text.toString());
      SplashScreenModel.userDataDump.setPanNo(binding.etGroup48103696.text.toString())
      val destIntent = AddressDetailsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "IdentityProofActivity"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, IdentityProofActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
