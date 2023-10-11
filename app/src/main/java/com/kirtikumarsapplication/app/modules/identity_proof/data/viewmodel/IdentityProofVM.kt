package com.kirtikumarsapplication.app.modules.identity_proof.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirtikumarsapplication.app.modules.identity_proof.`data`.model.IdentityProofModel
import org.koin.core.KoinComponent

class IdentityProofVM : ViewModel(), KoinComponent {
  val identityProofModel: MutableLiveData<IdentityProofModel> =
      MutableLiveData(IdentityProofModel())

  var navArguments: Bundle? = null
}
