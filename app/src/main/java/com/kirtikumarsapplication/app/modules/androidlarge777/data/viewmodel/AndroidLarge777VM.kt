package com.kirtikumarsapplication.app.modules.androidlarge777.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirtikumarsapplication.app.modules.androidlarge777.`data`.model.AndroidLarge777Model
import org.koin.core.KoinComponent

class AndroidLarge777VM : ViewModel(), KoinComponent {
  val androidLarge777Model: MutableLiveData<AndroidLarge777Model> =
      MutableLiveData(AndroidLarge777Model())

  var navArguments: Bundle? = null
}
