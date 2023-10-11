package com.kirtikumarsapplication.app.modules.loan_details.`data`.model

import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class LoanDetailsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLoanDetails: String? = MyApp.getInstance().resources.getString(R.string.lbl_loan_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTellusabouty: String? =
      MyApp.getInstance().resources.getString(R.string.msg_tell_us_about_y)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtShareyourloan: String? =
      MyApp.getInstance().resources.getString(R.string.msg_share_your_loan)
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
  var etGroup48103700Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup48103708Value: String? = null
)
