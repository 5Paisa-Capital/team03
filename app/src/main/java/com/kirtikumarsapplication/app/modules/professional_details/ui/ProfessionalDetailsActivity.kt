package com.kirtikumarsapplication.app.modules.professional_details.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
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
  }

  override fun setUpClicks(): Unit {
    binding.continueBtn.setOnClickListener {

      SplashScreenModel.userDataDump.setIncome(binding.etGroup48103701.text.toString())
      val destIntent = LoanDetailsActivity.getIntent(this, null)
      startActivity(destIntent)
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
}
