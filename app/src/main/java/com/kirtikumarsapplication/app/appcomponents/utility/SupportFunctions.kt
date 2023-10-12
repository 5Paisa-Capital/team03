package com.kirtikumarsapplication.app.appcomponents.utility

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.TextView
import com.kirtikumarsapplication.app.R
import java.util.regex.Pattern

/**
 * Created by brain_atul.a on 11-10-2023.
 */

class SupportFunctions {
    companion object {
        fun validateMobileNo(mobileNumber: String?): Boolean {
            val pattern = Pattern.compile("^[6789]\\d{9}$")
            val matcher = pattern.matcher(mobileNumber)
            return if (matcher.matches()) {
                true
            } else {
                false
            }
        }

        fun showAlert(msg: String?, context: Context?) {
            val dialog = Dialog(context!!)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.layout_error_dialog_red)
            val error_msg = dialog.findViewById<TextView>(R.id.errorMsg)
            error_msg.text = msg
            dialog.show()
        }

        fun validateAadharNumber(aadharNumber: String): Boolean {
            var aadharNumber = aadharNumber
            val aadharPattern = Pattern.compile("\\d{12}")
            aadharNumber = aadharNumber.replace("-".toRegex(), "")
            var isValidAadhar = aadharPattern.matcher(aadharNumber).matches()
            if (isValidAadhar) {
                isValidAadhar = ValidateAadharAlgo.validateVerhoeff(aadharNumber)
            }
            return isValidAadhar
        }

        fun validatePanNo(panNumber: String?): Boolean {
            val pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}")
            val matcher = pattern.matcher(panNumber)
            return if (matcher.matches()) {
                true
            } else {
                false
            }
        }
    }
}
