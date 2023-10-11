package com.kirtikumarsapplication.app.modules.loan_details.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.databinding.ActivityLoanDetailsBinding
import com.kirtikumarsapplication.app.modules.loan_details.`data`.viewmodel.LoanDetailsVM
import com.kirtikumarsapplication.app.modules.androidlarge777.ui.AndroidLarge777Activity
import kotlin.String
import kotlin.Unit

class LoanDetailsActivity :
    BaseActivity<ActivityLoanDetailsBinding>(R.layout.activity_loan_details) {
  private val viewModel: LoanDetailsVM by viewModels<LoanDetailsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loanDetailsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.continueBtn.setOnClickListener {
      val destIntent = AndroidLarge777Activity.getIntent(this, null)
      startActivity(destIntent)
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
}
