package com.kirtikumarsapplication.app.modules.professional_details.`data`.model

import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ProfessionalDetailsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtProfessionalDe: String? =
      MyApp.getInstance().resources.getString(R.string.msg_professional_de)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAlmostthere: String? = MyApp.getInstance().resources.getString(R.string.lbl_almost_there)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLetsknowyour: String? =
      MyApp.getInstance().resources.getString(R.string.msg_let_s_know_your)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtShareyourprof: String? =
      MyApp.getInstance().resources.getString(R.string.msg_share_your_prof)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt100Datasecur: String? =
      MyApp.getInstance().resources.getString(R.string.msg_100_data_secur)
  ,
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
