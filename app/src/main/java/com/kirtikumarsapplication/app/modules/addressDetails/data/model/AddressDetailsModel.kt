package com.kirtikumarsapplication.app.modules.addressDetails.`data`.model

import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class AddressDetailsModel(
  var txtAddressDetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_address_details),
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_where_s_your_ho),
  var txtShareyouaddre: String? = MyApp.getInstance().resources.getString(R.string.msg_share_you_addre),
  var txtDataSecur: String? = MyApp.getInstance().resources.getString(R.string.msg_100_data_secur),
  var txtOwnershipStatu: String? = MyApp.getInstance().resources.getString(R.string.msg_ownership_statu),
  var etAddressLine1Value: String? = null,
  var etAddressLine2Value: String? = null,
  var etPincodeValue: String? = null,
  var etCityValue: String? = null,
  var etBuyHouseValue: String? = null
)
