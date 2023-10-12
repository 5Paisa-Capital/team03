package com.kirtikumarsapplication.app.modules.professional_details.`data`.model

import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ProfessionalDetailsModel(
  var txtProfessionalDe: String? = MyApp.getInstance().resources.getString(R.string.msg_professional_de),
  var txtAlmostthere: String? = MyApp.getInstance().resources.getString(R.string.lbl_almost_there),
  var txtLetsknowyour: String? = MyApp.getInstance().resources.getString(R.string.msg_let_s_know_your),
  var txtShareyourprof: String? = MyApp.getInstance().resources.getString(R.string.msg_share_your_prof),
  var txt100Datasecur: String? = MyApp.getInstance().resources.getString(R.string.msg_100_data_secur),
  var etOccupationValue: String? = null,
  var etIncomeTypeValue: String? = null,
  var etMonthlyIncomeValue: String? = null
)
