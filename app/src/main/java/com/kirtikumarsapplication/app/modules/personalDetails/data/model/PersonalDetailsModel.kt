package com.kirtikumarsapplication.app.modules.personalDetails.`data`.model

import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class PersonalDetailsModel(
  var txtPersonalDetail: String? = MyApp.getInstance().resources.getString(R.string.msg_personal_detail),
  var txtLetsgettokn: String? = MyApp.getInstance().resources.getString(R.string.msg_let_s_get_to_kn),
  var txtStartbytellin: String? = MyApp.getInstance().resources.getString(R.string.msg_start_by_tellin),
  var txtDataSecurity: String? = MyApp.getInstance().resources.getString(R.string.msg_100_data_secur),
  var etFirstNameValue: String? = null,
  var etLastNameValue: String? = null,
  var etMobileNoValue: String? = null
)
