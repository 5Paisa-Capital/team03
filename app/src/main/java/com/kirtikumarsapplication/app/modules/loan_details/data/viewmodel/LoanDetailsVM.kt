package com.kirtikumarsapplication.app.modules.loan_details.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirtikumarsapplication.app.modules.loan_details.`data`.model.LoanDetailsModel
import org.koin.core.KoinComponent

class LoanDetailsVM : ViewModel(), KoinComponent {
  val loanDetailsModel: MutableLiveData<LoanDetailsModel> =
      MutableLiveData(LoanDetailsModel())

  var navArguments: Bundle? = null
}
