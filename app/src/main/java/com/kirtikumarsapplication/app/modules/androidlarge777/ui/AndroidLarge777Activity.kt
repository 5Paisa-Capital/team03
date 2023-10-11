package com.kirtikumarsapplication.app.modules.androidlarge777.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.compliancereporthomefinance.DataSource
import com.example.compliancereporthomefinance.Message
import com.example.compliancereporthomefinance.Parameters
import com.example.compliancereporthomefinance.ResponseData
import com.example.compliancereporthomefinance.Root
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.databinding.ActivityAndroidLarge777Binding
import com.kirtikumarsapplication.app.modules.androidlarge777.`data`.viewmodel.AndroidLarge777VM
import com.kirtikumarsapplication.app.modules.splash_screen.data.model.SplashScreenModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.String
import kotlin.Unit

class AndroidLarge777Activity :
    BaseActivity<ActivityAndroidLarge777Binding>(R.layout.activity_android_large_777) {
  private val viewModel: AndroidLarge777VM by viewModels<AndroidLarge777VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLarge777VM = viewModel
    binding.checkComplianceBtn.setOnClickListener {
      val apiService = RetrofitClient.apiService

      val dataSources: ArrayList<DataSource> = ArrayList()
      val dataSource = DataSource()
      dataSource.setType("AzureCognitiveSearch")

      val parameters = Parameters()
      parameters.endpoint = "https://eaccou.search.windows.net";
      parameters.key = "O2fG6XSa05v1K9fM5EjMhD1LihiT8pCHqmw2oFxZlNAzSeB2YxZh";
      parameters.indexName = "newindex01";
      dataSource.setParameters(parameters)

      dataSources.add(dataSource)
      val finalMessage = "My name is ${SplashScreenModel.userDataDump.getName()}, aadhaar number is ${SplashScreenModel.userDataDump.getAadhaarNo()}, PAN card no is ${SplashScreenModel.userDataDump.getPanNo()}.My age is 22. My Income is ${SplashScreenModel.userDataDump.getIncome()} per month. I want direct housing finance a house.I have a ${SplashScreenModel.userDataDump.getIsRented()} house in ${SplashScreenModel.userDataDump.getCurrentAddress()} City and I want to finance another house in ${SplashScreenModel.userDataDump.getPermanentAddress()} City. Can I pursue the loan? Answer in one word."
      val messages: ArrayList<Message> = ArrayList()
      val msg = Message()
      msg.role = "user"
      msg.content = finalMessage
      messages.add(msg)

      val requestUserData = Root()
      requestUserData.dataSources = dataSources
      requestUserData.messages = messages

      apiService.getSomeData(requestUserData).enqueue(object : Callback<ResponseData> {
        override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
          if (response.isSuccessful) {
            val userData = response.body()
            showDialog(finalMessage, userData?.choices?.get(0)?.messages?.get(1)?.content.toString())
          } else {
            Toast.makeText(
              this@AndroidLarge777Activity,
              "200: Error",
              Toast.LENGTH_SHORT
            ).show()
          }
        }

        override fun onFailure(call: Call<ResponseData>, t: Throwable) {
          Toast.makeText(
            this@AndroidLarge777Activity,
            "Error: ${t.message}",
            Toast.LENGTH_SHORT
          ).show()

        }

      })
    }
  }

  private fun showDialog(title: String, result: String) {
    val dialog = Dialog(this@AndroidLarge777Activity)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setContentView(R.layout.custom_layout)

    val body = dialog.findViewById(R.id.comp_parameter) as TextView
    body.text = title
    val compResult = dialog.findViewById(R.id.comp_result) as TextView
    compResult.text = result
    dialog.show()
  }
  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE777ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLarge777Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
