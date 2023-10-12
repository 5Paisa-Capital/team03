package com.kirtikumarsapplication.app.modules.professional_details.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.appcomponents.utility.SupportFunctions
import com.kirtikumarsapplication.app.databinding.ActivityProfessionalDetailsBinding
import com.kirtikumarsapplication.app.modules.professional_details.`data`.viewmodel.ProfessionalDetailsVM
import com.kirtikumarsapplication.app.modules.loan_details.ui.LoanDetailsActivity
import com.kirtikumarsapplication.app.modules.splash_screen.data.model.SplashScreenModel
import kotlin.String
import kotlin.Unit

class ProfessionalDetailsActivity :
    BaseActivity<ActivityProfessionalDetailsBinding>(R.layout.activity_professional_details) {
  private val viewModel: ProfessionalDetailsVM by viewModels<ProfessionalDetailsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.professionalDetailsVM = viewModel

    val occupation: String = mPref.getOccupation()
    val incomeType: String = mPref.getIncomeType()
    val monthlyIncome: String = mPref.getMonthlyIncome()

    binding.professionalDetailsVM?.professionalDetailsModel?.value?.etOccupationValue = occupation
    binding.professionalDetailsVM?.professionalDetailsModel?.value?.etIncomeTypeValue = incomeType
    binding.professionalDetailsVM?.professionalDetailsModel?.value?.etMonthlyIncomeValue = monthlyIncome
  }

  override fun setUpClicks(): Unit {
    binding.continueBtn.setOnClickListener {
      if (manualValidation()) {
        SplashScreenModel.userDataDump.setIncome(binding.etMonthlyIncome.text.toString())
        val destIntent = LoanDetailsActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    binding.saveAsDraftBtn.setOnClickListener {
      val occupation = binding.professionalDetailsVM?.professionalDetailsModel?.value?.etOccupationValue ?: ""
      val incomeType = binding.professionalDetailsVM?.professionalDetailsModel?.value?.etIncomeTypeValue ?: ""
      val monthlyIncome = binding.professionalDetailsVM?.professionalDetailsModel?.value?.etMonthlyIncomeValue ?: ""
      mPref.setOccupation(occupation)
      mPref.setIncomeType(incomeType)
      mPref.setMonthlyIncome(monthlyIncome)
      Toast.makeText(this@ProfessionalDetailsActivity, "Data saved in locally", Toast.LENGTH_SHORT).show()
    }
  }

  companion object {
    const val TAG: String = "ProfessionalDetailsActivity"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ProfessionalDetailsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }

  private fun manualValidation() : Boolean {
    var errorCount = 1
    val sb = StringBuilder("")

    val occupation = binding.professionalDetailsVM?.professionalDetailsModel?.value?.etOccupationValue
    val incomeType = binding.professionalDetailsVM?.professionalDetailsModel?.value?.etIncomeTypeValue
    val monthlyIncome = binding.professionalDetailsVM?.professionalDetailsModel?.value?.etMonthlyIncomeValue

    if (occupation.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Occupation").append("\n\n")
      errorCount++
    } else {
      if (occupation.length < 3) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter at least 3 characters in Occupation").append("\n\n")
        errorCount++
      }
    }

    if (incomeType.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Income Type").append("\n\n")
      errorCount++
    } else {
      if (incomeType.length < 3) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter at least 3 characters in Income Type").append("\n\n")
        errorCount++
      }
    }

    if (monthlyIncome.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Monthly Income").append("\n\n")
      errorCount++
    } else {
      if (monthlyIncome.length < 3) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter at least 3 characters in Monthly Income").append("\n\n")
        errorCount++
      }
    }


    if (errorCount > 1) {
      SupportFunctions.showAlert(sb.toString(), this@ProfessionalDetailsActivity)
      return false
    }
    return true
  }
}
