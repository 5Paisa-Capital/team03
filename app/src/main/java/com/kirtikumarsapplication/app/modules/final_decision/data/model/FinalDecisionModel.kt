package com.kirtikumarsapplication.app.modules.final_decision.`data`.model

import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class FinalDecisionModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtYourapplicatio: String? =
      MyApp.getInstance().resources.getString(R.string.msg_your_applicatio)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt27thJunTwentyThree: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_27th_jun_23)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_12_34pm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYoullreceive: String? =
      MyApp.getInstance().resources.getString(R.string.msg_you_ll_receive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNeedassistance: String? =
      MyApp.getInstance().resources.getString(R.string.msg_need_assistance)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtIfyouhaveany: String? =
      MyApp.getInstance().resources.getString(R.string.msg_if_you_have_any)

)
