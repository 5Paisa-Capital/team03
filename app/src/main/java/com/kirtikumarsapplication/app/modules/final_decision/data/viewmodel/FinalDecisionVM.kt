package com.kirtikumarsapplication.app.modules.final_decision.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirtikumarsapplication.app.modules.final_decision.`data`.model.FinalDecisionModel
import org.koin.core.KoinComponent

class FinalDecisionVM : ViewModel(), KoinComponent {
  val finalDecisionModel: MutableLiveData<FinalDecisionModel> =
      MutableLiveData(FinalDecisionModel())

  var navArguments: Bundle? = null
}
