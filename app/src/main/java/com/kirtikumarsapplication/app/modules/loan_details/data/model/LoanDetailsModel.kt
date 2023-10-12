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
  var txtShareyourloan: String? = MyApp.getInstance().resources.getString(R.string.msg_share_your_loan),
  var txt100Datasecur: String? = MyApp.getInstance().resources.getString(R.string.msg_100_data_secur),
  var etLoanTypeValue: String? = null,
  var etLoanAmountValue: String? = null
)
