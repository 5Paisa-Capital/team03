package com.kirtikumarsapplication.app.modules.identity_proof.`data`.model

import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class IdentityProofModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtIdentityProof: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_identity_proof)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtProvideYourGo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_verify_your_ide)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtProvideyourgo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_provide_your_go)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDatasecur: String? =
      MyApp.getInstance().resources.getString(R.string.msg_100_data_secur)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup48103694Value: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etGroup48103696Value: String? = null
)
