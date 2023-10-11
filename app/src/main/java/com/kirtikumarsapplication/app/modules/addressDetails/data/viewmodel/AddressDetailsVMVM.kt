package com.kirtikumarsapplication.app.modules.addressDetails.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kirtikumarsapplication.app.modules.addressDetails.`data`.model.AddressDetailsModel
import org.koin.core.KoinComponent

class AddressDetailsVMVM : ViewModel(), KoinComponent {
  val addressDetailsModel: MutableLiveData<AddressDetailsModel> =
      MutableLiveData(AddressDetailsModel())

  var navArguments: Bundle? = null
}
