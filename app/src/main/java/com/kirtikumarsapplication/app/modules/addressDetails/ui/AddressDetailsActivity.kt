package com.kirtikumarsapplication.app.modules.addressDetails.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.base.BaseActivity
import com.kirtikumarsapplication.app.databinding.ActivityAddressDetailsBinding
import com.kirtikumarsapplication.app.appcomponents.utility.SupportFunctions
import com.kirtikumarsapplication.app.modules.addressDetails.`data`.viewmodel.AddressDetailsVMVM
import com.kirtikumarsapplication.app.modules.professional_details.ui.ProfessionalDetailsActivity
import com.kirtikumarsapplication.app.modules.splash_screen.data.model.SplashScreenModel
import kotlin.String
import kotlin.Unit

class AddressDetailsActivity :
    BaseActivity<ActivityAddressDetailsBinding>(R.layout.activity_address_details) {
  private val viewModel: AddressDetailsVMVM by viewModels<AddressDetailsVMVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.addressDetailsVM = viewModel

    val ownership: Int = mPref.getOwnership()
    val addressLine1: String = mPref.getAddress1()
    val addressLine2: String = mPref.getAddress2()
    val pincode: String = mPref.getPincode()
    val city: String = mPref.getCity()
    val buyHouse: String = mPref.getBuyHouse()

    when (ownership) {
      1 -> {
        binding.rbOwned.isChecked = true
      }
      2 -> {
        binding.rbRented.isChecked = true
      }
    }
    binding.addressDetailsVM?.addressDetailsModel?.value?.etAddressLine1Value = addressLine1
    binding.addressDetailsVM?.addressDetailsModel?.value?.etAddressLine2Value = addressLine2
    binding.addressDetailsVM?.addressDetailsModel?.value?.etPincodeValue = pincode
    binding.addressDetailsVM?.addressDetailsModel?.value?.etCityValue = city
    binding.addressDetailsVM?.addressDetailsModel?.value?.etBuyHouseValue = buyHouse

  }

  override fun setUpClicks(): Unit {
    binding.continueBtn.setOnClickListener {
      if (manualValidation()) {

        var ownershipStatusSelected = -1
        when (binding.rgOwnershipStatus.checkedRadioButtonId) {
          R.id.rbOwned -> {
            ownershipStatusSelected = 1
          }
          R.id.rbRented -> {
            ownershipStatusSelected = 2
          }
        }
        val addressLine1 = binding.addressDetailsVM?.addressDetailsModel?.value?.etAddressLine1Value
        val addressLine2 = binding.addressDetailsVM?.addressDetailsModel?.value?.etAddressLine2Value
        val pincode = binding.addressDetailsVM?.addressDetailsModel?.value?.etPincodeValue
        val city = binding.addressDetailsVM?.addressDetailsModel?.value?.etCityValue
        val buyHouse = binding.addressDetailsVM?.addressDetailsModel?.value?.etBuyHouseValue
        var buyHouseStr = ""

        if (buyHouse.equals("yes", true)) {
          buyHouseStr = "Yes"
        } else if (buyHouse.equals("no", true)) {
          buyHouseStr = "No"
        }

        val destIntent = ProfessionalDetailsActivity.getIntent(this, null)
        if (ownershipStatusSelected == 1) {
          SplashScreenModel.userDataDump.setIsRented("Owned")
        } else if (ownershipStatusSelected == 2) {
          SplashScreenModel.userDataDump.setIsRented("Rented")
        }
        SplashScreenModel.userDataDump.setCurrentAddress(city)
        SplashScreenModel.userDataDump.setPermanentAddress(buyHouseStr)
        startActivity(destIntent)
      }
    }

    binding.saveAsDraftBtn.setOnClickListener {

      var ownershipStatusSelected = -1
      when (binding.rgOwnershipStatus.checkedRadioButtonId) {
        R.id.rbOwned -> {
          ownershipStatusSelected = 1
        }
        R.id.rbRented -> {
          ownershipStatusSelected = 2
        }
      }
      val addressLine1 = binding.addressDetailsVM?.addressDetailsModel?.value?.etAddressLine1Value ?: ""
      val addressLine2 = binding.addressDetailsVM?.addressDetailsModel?.value?.etAddressLine2Value ?: ""
      val pincode = binding.addressDetailsVM?.addressDetailsModel?.value?.etPincodeValue ?: ""
      val city = binding.addressDetailsVM?.addressDetailsModel?.value?.etCityValue ?: ""
      val buyHouse = binding.addressDetailsVM?.addressDetailsModel?.value?.etBuyHouseValue ?: ""

      mPref.setOwnership(ownershipStatusSelected)
      mPref.setAddress1(addressLine1)
      mPref.setAddress2(addressLine2)
      mPref.setPincode(pincode)
      mPref.setCity(city)
      mPref.setBuyHouse(buyHouse)
      Toast.makeText(this@AddressDetailsActivity, "Data saved in locally", Toast.LENGTH_SHORT).show()
    }
  }

  companion object {
    const val TAG: String = "AddressDetailsActivity"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AddressDetailsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }


  private fun manualValidation() : Boolean {
    var errorCount = 1
    val sb = StringBuilder("")
    var ownershipStatusSelected = -1
    when (binding.rgOwnershipStatus.checkedRadioButtonId) {
      R.id.rbOwned -> {
        ownershipStatusSelected = 1
      }
      R.id.rbRented -> {
        ownershipStatusSelected = 2
      }
    }
    val addressLine1 = binding.addressDetailsVM?.addressDetailsModel?.value?.etAddressLine1Value
    val addressLine2 = binding.addressDetailsVM?.addressDetailsModel?.value?.etAddressLine2Value
    val pincode = binding.addressDetailsVM?.addressDetailsModel?.value?.etPincodeValue
    val city = binding.addressDetailsVM?.addressDetailsModel?.value?.etCityValue
    val buyHouse = binding.addressDetailsVM?.addressDetailsModel?.value?.etBuyHouseValue

    if (ownershipStatusSelected == -1) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please select Ownership Status").append("\n\n")
      errorCount++
    }

    if (addressLine1.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Address Line 1").append("\n\n")
      errorCount++
    } else {
      if (addressLine1.length < 3) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter at least 3 characters in Address Line 1").append("\n\n")
        errorCount++
      }
    }

    if (addressLine2.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Address Line 2").append("\n\n")
      errorCount++
    } else {
      if (addressLine2.length < 3) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter at least 3 characters in Address Line 2").append("\n\n")
        errorCount++
      }
    }

    if (pincode.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter Pincode").append("\n\n")
      errorCount++
    } else {
      if (pincode.length != 6) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter valid Pincode").append("\n\n")
        errorCount++
      }
    }

    if (city.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please enter City").append("\n\n")
      errorCount++
    } else {
      if (city.length < 3) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please enter at least 3 characters in City").append("\n\n")
        errorCount++
      }
    }

    if (buyHouse.isNullOrBlank()) {
      sb.append(errorCount).append(getString(R.string.error_space))
        .append("Please let us know if you want to buy house? Yes/No").append("\n\n")
      errorCount++
    } else {
      if (!(buyHouse.equals("yes", true) || buyHouse.equals("no", true))) {
        sb.append(errorCount).append(getString(R.string.error_space))
          .append("Please let us know if you want to buy house? Yes/No").append("\n\n")
        errorCount++
      }
    }

    if (errorCount > 1) {
      SupportFunctions.showAlert(sb.toString(), this@AddressDetailsActivity)
      return false
    }
    return true
  }

}
