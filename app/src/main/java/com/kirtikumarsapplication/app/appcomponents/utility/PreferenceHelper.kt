package com.kirtikumarsapplication.app.appcomponents.utility

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.kirtikumarsapplication.app.R
import com.kirtikumarsapplication.app.appcomponents.di.MyApp

/**
 * class which used to manage application shared preference
 */
class PreferenceHelper() {
    private val masterKeyAlias: String = createGetMasterKey()
    private var editor: SharedPreferences.Editor? = null
    private val FIRST_NAME_KEY: String = "first_name_key"
    private val LAST_NAME_KEY: String = "last_name_key"
    private val MOBILE_NO_KEY: String = "mobile_no_key"
    private val AADHAAR_NO_KEY: String = "aadhaar_no_key"
    private val PAN_NO_KEY: String = "pan_no_key"
    private val OWNERSHIP_KEY: String = "ownership_key"
    private val ADDRESS_1_KEY: String = "address_1_key"
    private val ADDRESS_2_KEY: String = "address_2_key"
    private val PINCODE_KEY: String = "pincode_key"
    private val CITY_KEY: String = "city_key"
    private val BUY_HOUSE_KEY: String = "buy_house_key"
    private val OCCUPATION_KEY: String = "occupation_key"
    private val INCOME_TYPE_KEY: String = "income_type_key"
    private val MONTHLY_INCOME_KEY: String = "monthly_income_key"
    private val LOAN_TYPE_KEY: String = "loan_type_key"
    private val LOAN_AMMOUNT_KEY: String = "loan_ammount_key"

    private val sharedPreference: SharedPreferences = EncryptedSharedPreferences.create(
        MyApp.getInstance().resources.getString(R.string.app_name),
        masterKeyAlias,
        MyApp.getInstance().applicationContext,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    /**
     * Creates or gets the master key provided,
     * The encryption scheme is required fields to ensure that the type of encryption used is clear to developers.
     *
     * @return the string value of encrypted key
     */
    private fun createGetMasterKey(): String {
        return MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    }

    fun setFirstName(firstName: String) {
        editor = sharedPreference.edit()
        editor?.putString(FIRST_NAME_KEY, firstName)
        editor?.apply()
    }

    fun getFirstName() : String {
        return sharedPreference.getString(FIRST_NAME_KEY, "") ?: ""
    }

    fun setLastName(lastName: String) {
        editor = sharedPreference.edit()
        editor?.putString(LAST_NAME_KEY, lastName)
        editor?.apply()
    }

    fun getLastName() : String {
        return sharedPreference.getString(LAST_NAME_KEY, "") ?: ""
    }

    fun setMobileNo(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(MOBILE_NO_KEY, data)
        editor?.apply()
    }

    fun getMobileNo() : String {
        return sharedPreference.getString(MOBILE_NO_KEY, "") ?: ""
    }

    fun setAadhaarNo(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(AADHAAR_NO_KEY, data)
        editor?.apply()
    }

    fun getAadhaarNo() : String {
        return sharedPreference.getString(AADHAAR_NO_KEY, "") ?: ""
    }

    fun setPanNo(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(PAN_NO_KEY, data)
        editor?.apply()
    }

    fun getPanNo() : String {
        return sharedPreference.getString(PAN_NO_KEY, "") ?: ""
    }

    fun setOwnership(data: Int) {
        editor = sharedPreference.edit()
        editor?.putInt(OWNERSHIP_KEY, data)
        editor?.apply()
    }

    fun getOwnership() : Int {
        return sharedPreference.getInt(OWNERSHIP_KEY, -1)
    }

    fun setAddress1(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(ADDRESS_1_KEY, data)
        editor?.apply()
    }

    fun getAddress1() : String {
        return sharedPreference.getString(ADDRESS_1_KEY, "") ?: ""
    }

    fun setAddress2(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(ADDRESS_2_KEY, data)
        editor?.apply()
    }

    fun getAddress2() : String {
        return sharedPreference.getString(ADDRESS_2_KEY, "") ?: ""
    }

    fun setPincode(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(PINCODE_KEY, data)
        editor?.apply()
    }

    fun getPincode() : String {
        return sharedPreference.getString(PINCODE_KEY, "") ?: ""
    }

    fun setCity(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(CITY_KEY, data)
        editor?.apply()
    }

    fun getCity() : String {
        return sharedPreference.getString(CITY_KEY, "") ?: ""
    }

    fun setBuyHouse(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(BUY_HOUSE_KEY, data)
        editor?.apply()
    }

    fun getBuyHouse() : String {
        return sharedPreference.getString(BUY_HOUSE_KEY, "") ?: ""
    }

    fun setOccupation(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(OCCUPATION_KEY, data)
        editor?.apply()
    }

    fun getOccupation() : String {
        return sharedPreference.getString(OCCUPATION_KEY, "") ?: ""
    }

    fun setIncomeType(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(INCOME_TYPE_KEY, data)
        editor?.apply()
    }

    fun getIncomeType() : String {
        return sharedPreference.getString(INCOME_TYPE_KEY, "") ?: ""
    }

    fun setMonthlyIncome(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(MONTHLY_INCOME_KEY, data)
        editor?.apply()
    }

    fun getMonthlyIncome() : String {
        return sharedPreference.getString(MONTHLY_INCOME_KEY, "") ?: ""
    }

    fun setLoanType(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(LOAN_TYPE_KEY, data)
        editor?.apply()
    }

    fun getLoanType() : String {
        return sharedPreference.getString(LOAN_TYPE_KEY, "") ?: ""
    }

    fun setLoanAmount(data: String) {
        editor = sharedPreference.edit()
        editor?.putString(LOAN_AMMOUNT_KEY, data)
        editor?.apply()
    }

    fun getLoanAmount() : String {
        return sharedPreference.getString(LOAN_AMMOUNT_KEY, "") ?: ""
    }

}