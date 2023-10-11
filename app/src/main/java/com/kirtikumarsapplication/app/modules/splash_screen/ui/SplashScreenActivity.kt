package com.kirtikumarsapplication.app.modules.splash_screen.ui

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.databinding.ActivitySplashScreenBinding
import com.kirtikumarsapplication.app.modules.splash_screen.`data`.viewmodel.SplashScreenVM
import com.kirtikumarsapplication.app.modules.personalDetails.ui.PersonalDetailsActivity
import kotlin.String
import kotlin.Unit

class SplashScreenActivity :
    BaseActivity<ActivitySplashScreenBinding>(R.layout.activity_splash_screen) {
  private val viewModel: SplashScreenVM by viewModels<SplashScreenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashScreenVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = PersonalDetailsActivity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
    }

    companion object {
      const val TAG: String = "SplashScreenActivity"

    }
  }
