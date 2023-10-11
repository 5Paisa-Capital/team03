package com.kirtikumarsapplication.app.data


/**
 * Created by brain_atul.a on 07-10-2023.
 */
class UserDatum {
    private var id: Int? = null
    private var name: String? = null
    private var email: String? = null
    private var aadhaarNo: String? = null
    private var panNo: String? = null
    private var currentAddress: String? = null
    private var permanentAddress: String? = null
    private var occupation: String? = null
    private var income: String? = null
    private var incomeType: String? = null
    private var isRented: String? = null
    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getAadhaarNo(): String? {
        return aadhaarNo
    }

    fun setAadhaarNo(aadhaarNo: String?) {
        this.aadhaarNo = aadhaarNo
    }

    fun getPanNo(): String? {
        return panNo
    }

    fun setPanNo(panNo: String?) {
        this.panNo = panNo
    }

    fun getCurrentAddress(): String? {
        return currentAddress
    }

    fun setCurrentAddress(currentAddress: String?) {
        this.currentAddress = currentAddress
    }

    fun getPermanentAddress(): String? {
        return permanentAddress
    }

    fun setPermanentAddress(permanentAddress: String?) {
        this.permanentAddress = permanentAddress
    }

    fun getOccupation(): String? {
        return occupation
    }

    fun setOccupation(occupation: String?) {
        this.occupation = occupation
    }

    fun getIncome(): String? {
        return income
    }

    fun setIncome(income: String?) {
        this.income = income
    }

    fun getIncomeType(): String? {
        return incomeType
    }

    fun setIncomeType(incomeType: String?) {
        this.incomeType = incomeType
    }

    fun getIsRented(): String? {
        return isRented
    }

    fun setIsRented(isRented: String?) {
        this.isRented = isRented
    }
}
