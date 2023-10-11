package com.kirtikumarsapplication.app.modules.addressDetails.`data`.model

import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class AddressDetailsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAddressDetails: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_address_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_where_s_your_ho)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtShareyouaddre: String? =
      MyApp.getInstance().resources.getString(R.string.msg_share_you_addre)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDataSecur: String? =
      MyApp.getInstance().resources.getString(R.string.msg_100_data_secur)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOwnershipstatu: String? =
      MyApp.getInstance().resources.getString(R.string.msg_ownership_statu)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup48103698Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup48103699Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup48103700Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup48103701Value: String? = null
)
