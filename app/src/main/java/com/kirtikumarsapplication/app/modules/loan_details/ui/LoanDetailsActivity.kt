package com.kirtikumarsapplication.app.modules.loan_details.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.appcomponents.utility.SupportFunctions
import com.kirtikumarsapplication.app.databinding.ActivityLoanDetailsBinding
import com.kirtikumarsapplication.app.modules.loan_details.`data`.viewmodel.LoanDetailsVM
import com.kirtikumarsapplication.app.modules.final_decision.ui.FinalDecisionActivity
import kotlin.String
import kotlin.Unit

class LoanDetailsActivity : BaseActivity<ActivityLoanDetailsBinding>(R.layout.activity_loan_details) {
  private val viewModel: LoanDetailsVM by viewModels<LoanDetailsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loanDetailsVM = viewModel

    val loanType: String = mPref.getLoanType()
    val loanAmount: String = mPref.getLoanAmount()

    binding.loanDetailsVM?.loanDetailsModel?.value?.etLoanTypeValue = loanType
    binding.loanDetailsVM?.loanDetailsModel?.value?.etLoanAmountValue = loanAmount
  }

  override fun setUpClicks(): Unit {
    binding.continueBtn.setOnClickListener {
      if (manualValidation()) {
        val destIntent = FinalDecisionActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    binding.saveAsDraftBtn.setOnClickListener {
      val loanType = binding.loanDetailsVM?.loanDetailsModel?.value?.etLoanTypeValue ?: ""
      val loanAmount = binding.loanDetailsVM?.loanDetailsModel?.value?.etLoanAmountValue ?: ""
      mPref.setLoanType(loanType)
      mPref.setLoanAmount(loanAmount)
      Toast.makeText(this@LoanDetailsActivity, "Data saved in locally", Toast.LENGTH_SHORT).show()
    }
  }

  companion object {
    const val TAG: String = "LoanDetailsActivity"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LoanDetailsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }

  private fun manualValidation() : Boolean {
    var errorCount = 1
    val sb = StringBuilder("")

    val loanType = binding.loanDetailsVM?.loanDetailsModel?.value?.etLoanTypeValue
    val loanAmount = binding.loanDetailsVM?.loanDetailsModel?.value?.etLoanAmountValue

    if (loanType.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Loan Type").append("\n\n")
      errorCount++
    } else {
      if (loanType.length < 3) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter at least 3 characters in Loan Type").append("\n\n")
        errorCount++
      }
    }

    if (loanAmount.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Loan Amount").append("\n\n")
      errorCount++
    } else {
      if (loanAmount.length < 3) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter at least 3 characters in Loan Amount").append("\n\n")
        errorCount++
      }
    }

    if (errorCount > 1) {
      SupportFunctions.showAlert(sb.toString(), this@LoanDetailsActivity)
      return false
    }
    return true
  }
}
