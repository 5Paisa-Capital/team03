package com.kirtikumarsapplication.app.modules.identity_proof.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.databinding.ActivityIdentityProofBinding
import com.kirtikumarsapplication.app.appcomponents.utility.SupportFunctions
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


    val aadhaarNo: String = mPref.getAadhaarNo()
    val panNo: String = mPref.getPanNo()

    binding.identityProofVM?.identityProofModel?.value?.etAadhaarNoValue = aadhaarNo
    binding.identityProofVM?.identityProofModel?.value?.etPANNumberValue = panNo
  }

  override fun setUpClicks(): Unit {
    binding.continueBtn.setOnClickListener {
      if (manualValidation()) {
        val aadhaarNo = binding.identityProofVM?.identityProofModel?.value?.etAadhaarNoValue
        val panNo = binding.identityProofVM?.identityProofModel?.value?.etPANNumberValue

        SplashScreenModel.userDataDump.setAadhaarNo(aadhaarNo);
        SplashScreenModel.userDataDump.setPanNo(panNo)
        val destIntent = AddressDetailsActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    binding.saveAsDraftBtn.setOnClickListener {
      val aadhaarNo = binding.identityProofVM?.identityProofModel?.value?.etAadhaarNoValue ?: ""
      val panNo = binding.identityProofVM?.identityProofModel?.value?.etPANNumberValue ?: ""
      mPref.setAadhaarNo(aadhaarNo)
      mPref.setPanNo(panNo)
      Toast.makeText(this@IdentityProofActivity, "Data saved in locally", Toast.LENGTH_SHORT).show()
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

  private fun manualValidation() : Boolean {
    var errorCount = 1
    val sb = StringBuilder("")

    val aadhaarNo = binding.identityProofVM?.identityProofModel?.value?.etAadhaarNoValue
    val panNo = binding.identityProofVM?.identityProofModel?.value?.etPANNumberValue

    if (aadhaarNo.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Aadhaar Number").append("\n\n")
      errorCount++
    } else {
      if (!SupportFunctions.validateAadharNumber(aadhaarNo)) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter valid Aadhaar Number").append("\n\n")
        errorCount++
      }
    }

    if (panNo.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter PAN Number").append("\n\n")
      errorCount++
    } else {
      if (!SupportFunctions.validatePanNo(panNo)) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter valid PAN Number").append("\n\n")
        errorCount++
      }
    }

    if (errorCount > 1) {
      SupportFunctions.showAlert(sb.toString(), this@IdentityProofActivity)
      return false
    }
    return true
  }

}
