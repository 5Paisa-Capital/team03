package com.kirtikumarsapplication.app.modules.personalDetails.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.databinding.ActivityPersonalDetailsBinding
import com.kirtikumarsapplication.app.modules.personalDetails.`data`.viewmodel.PersonalDetailsVM
import com.kirtikumarsapplication.app.modules.identity_proof.ui.IdentityProofActivity
import com.kirtikumarsapplication.app.modules.splash_screen.data.model.SplashScreenModel
import kotlin.String
import kotlin.Unit

class PersonalDetailsActivity :
    BaseActivity<ActivityPersonalDetailsBinding>(R.layout.activity_personal_details) {
  private val viewModel: PersonalDetailsVM by viewModels()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.personalDetailsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.continueBtn.setOnClickListener {
      SplashScreenModel.userDataDump.setName("${binding.etFN.text} ${binding.etLN.text}")
      val destIntent = IdentityProofActivity.getIntent(this, null)
      startActivity(destIntent)
    }
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
