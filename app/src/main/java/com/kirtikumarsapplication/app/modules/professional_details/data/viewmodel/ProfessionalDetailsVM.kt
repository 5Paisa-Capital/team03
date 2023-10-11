package com.kirtikumarsapplication.app.modules.professional_details.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirtikumarsapplication.app.modules.professional_details.`data`.model.ProfessionalDetailsModel
import org.koin.core.KoinComponent

class ProfessionalDetailsVM : ViewModel(), KoinComponent {
  val professionalDetailsModel: MutableLiveData<ProfessionalDetailsModel> =
      MutableLiveData(ProfessionalDetailsModel())

  var navArguments: Bundle? = null
}
