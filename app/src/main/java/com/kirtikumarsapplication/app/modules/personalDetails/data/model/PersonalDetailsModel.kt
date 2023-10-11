package com.kirtikumarsapplication.app.modules.personalDetails.`data`.model

import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class PersonalDetailsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPersonalDetail: String? =
      MyApp.getInstance().resources.getString(R.string.msg_personal_detail)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLetsgettokn: String? =
      MyApp.getInstance().resources.getString(R.string.msg_let_s_get_to_kn)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStartbytellin: String? =
      MyApp.getInstance().resources.getString(R.string.msg_start_by_tellin)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDataSecurity: String? =
      MyApp.getInstance().resources.getString(R.string.msg_100_data_secur)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etLanguageValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etLanguageOneValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etMobileNoValue: String? = null
)
