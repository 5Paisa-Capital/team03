package com.kirtikumarsapplication.app.modules.personalDetails.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirtikumarsapplication.app.modules.personalDetails.`data`.model.PersonalDetailsModel
import org.koin.core.KoinComponent

class PersonalDetailsVM : ViewModel(), KoinComponent {
  val personalDetailsVMModel: MutableLiveData<PersonalDetailsModel> =
      MutableLiveData(PersonalDetailsModel())

  var navArguments: Bundle? = null
}
