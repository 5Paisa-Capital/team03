package com.kirtikumarsapplication.app.modules.final_decision.ui

import RetrofitClient
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.compliancereporthomefinance.DataSource
import com.example.compliancereporthomefinance.Message
import com.example.compliancereporthomefinance.Parameters
import com.example.compliancereporthomefinance.ResponseData
import com.example.compliancereporthomefinance.Root
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.databinding.ActivityFinalDecisionBinding
import com.kirtikumarsapplication.app.modules.final_decision.data.viewmodel.FinalDecisionVM
import com.kirtikumarsapplication.app.modules.splash_screen.data.model.SplashScreenModel
import com.strawberry.pdfgenerator.ComplianceDetails
import com.strawberry.pdfgenerator.PDFConverter
import com.strawberry.pdfgenerator.PdfDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Calendar


class FinalDecisionActivity :
    BaseActivity<ActivityFinalDecisionBinding>(R.layout.activity_final_decision) {
  private val viewModel: FinalDecisionVM by viewModels()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.finalDecisionVM = viewModel
    Glide.with(this).asGif().load(R.raw.green_tick).into(binding.tickView)
    binding.checkComplianceBtn.setOnClickListener {
      generateReport()
    }
  }

  private fun generateReport() {
    binding.progressView.visibility = View.VISIBLE;
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
    val message = "My name is ${SplashScreenModel.userDataDump.getName()}, aadhaar number is ${SplashScreenModel.userDataDump.getAadhaarNo()}, PAN card no is ${SplashScreenModel.userDataDump.getPanNo()}.My age is 22. My Income is ${SplashScreenModel.userDataDump.getIncome()} per month. I want direct housing finance a house.I have a ${SplashScreenModel.userDataDump.getIsRented()} house in ${SplashScreenModel.userDataDump.getCurrentAddress()} City and I want to finance another house in ${SplashScreenModel.userDataDump.getPermanentAddress()} City."
    val finalMessage = "$message Can I pursue the loan? Answer in one word."
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
          val complianceDetailsList = mutableListOf<ComplianceDetails>()
          complianceDetailsList.add(
            ComplianceDetails(
              1,
              message,
              userData?.choices?.get(0)?.messages?.get(1)?.content.toString()
            )
          )
          val pdfDetails = PdfDetails(getCurrentDate(), 0, complianceDetailsList)
          val pdfConverter = PDFConverter()
          pdfConverter.createPdf(
            this@FinalDecisionActivity,
            pdfDetails,
            this@FinalDecisionActivity,
            getCurrentDate()
          )

          binding.progressView.visibility = View.GONE;
        } else {
          binding.progressView.visibility = View.GONE;
          Toast.makeText(
            this@FinalDecisionActivity,
            "200: Error",
            Toast.LENGTH_SHORT
          ).show()
        }
      }

      override fun onFailure(call: Call<ResponseData>, t: Throwable) {
        binding.progressView.visibility = View.GONE;
        Toast.makeText(
          this@FinalDecisionActivity,
          "Error: ${t.message}",
          Toast.LENGTH_SHORT
        ).show()

      }

    })
  }

  private fun showDialog(title: String, result: String) {
    val dialog = Dialog(this@FinalDecisionActivity)
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
      val destIntent = Intent(context, FinalDecisionActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }

  @SuppressLint("SimpleDateFormat")
  private fun getCurrentDate(): String {
    val time = Calendar.getInstance().time
    val formatter = SimpleDateFormat("dd MMM yyyy HH:mm")
    return formatter.format(time)
  }

}
