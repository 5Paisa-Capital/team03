package com.kirtikumarsapplication.app.modules.personalDetails.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.databinding.ActivityPersonalDetailsBinding
import com.kirtikumarsapplication.app.appcomponents.utility.SupportFunctions
import com.kirtikumarsapplication.app.modules.identity_proof.ui.IdentityProofActivity
import com.kirtikumarsapplication.app.modules.personalDetails.data.viewmodel.PersonalDetailsVM
import com.kirtikumarsapplication.app.modules.splash_screen.data.model.SplashScreenModel

class PersonalDetailsActivity :
    BaseActivity<ActivityPersonalDetailsBinding>(R.layout.activity_personal_details) {
  private val viewModel: PersonalDetailsVM by viewModels()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.personalDetailsVM = viewModel

    val firstName: String = mPref.getFirstName()
    val lastName: String = mPref.getLastName()
    val mobileNo: String = mPref.getMobileNo()

    binding.personalDetailsVM?.personalDetailsVMModel?.value?.etFirstNameValue = firstName
    binding.personalDetailsVM?.personalDetailsVMModel?.value?.etLastNameValue = lastName
    binding.personalDetailsVM?.personalDetailsVMModel?.value?.etMobileNoValue = mobileNo
  }

  override fun setUpClicks(): Unit {
    binding.continueBtn.setOnClickListener {
      if (manualValidation()) {
        SplashScreenModel.userDataDump.setName("${binding.etFN.text} ${binding.etLN.text}")
        val destIntent = IdentityProofActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    binding.saveAsDraftBtn.setOnClickListener {
      val firstName: String = binding.personalDetailsVM?.personalDetailsVMModel?.value?.etFirstNameValue ?: ""
      val lastName: String = binding.personalDetailsVM?.personalDetailsVMModel?.value?.etLastNameValue ?: ""
      val mobileNo: String = binding.personalDetailsVM?.personalDetailsVMModel?.value?.etMobileNoValue ?: ""
      mPref.setFirstName(firstName)
      mPref.setLastName(lastName)
      mPref.setMobileNo(mobileNo)
      Toast.makeText(this@PersonalDetailsActivity, "Data saved in locally", Toast.LENGTH_SHORT).show()
    }
  }

  private fun manualValidation() : Boolean {
    var errorCount = 1
    val sb = StringBuilder("")

    val firstName = binding.personalDetailsVM?.personalDetailsVMModel?.value?.etFirstNameValue
    val lastName = binding.personalDetailsVM?.personalDetailsVMModel?.value?.etLastNameValue
    val mobileNo = binding.personalDetailsVM?.personalDetailsVMModel?.value?.etMobileNoValue

    if (firstName.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter First Name").append("\n\n")
      errorCount++
    } else {
      if (firstName.length < 3) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter at least 3 characters in First Name").append("\n\n")
        errorCount++
      }
    }

    if (lastName.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Last Name").append("\n\n")
      errorCount++
    } else {
      if (lastName.length < 3) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter at least 3 characters in Last Name").append("\n\n")
        errorCount++
      }
    }

    if (mobileNo.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Mobile No").append("\n\n")
      errorCount++
    } else {
      if (!SupportFunctions.validateMobileNo(mobileNo)) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please Enter Valid Mobile No").append("\n\n")
        errorCount++
      }
    }

    if (errorCount > 1) {
      SupportFunctions.showAlert(sb.toString(), this@PersonalDetailsActivity)
      return false
    }
    return true
  }

  companion object {
    const val TAG: String = "PersonalDetailsActivity"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PersonalDetailsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
