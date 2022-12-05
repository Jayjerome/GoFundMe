package com.gads.crowdfunding.viewmodel.onboardingviewmodel

import androidx.lifecycle.ViewModel

class OnboardingViewModel : ViewModel() {

//SignUp Fragment

    //Updated through databinding in real time
    var firstName = ""
    var lastName = ""
    var email = ""
    var password = ""
    private var name = "$firstName $lastName"


    fun isFirstNameBlank(): Boolean = firstName.isBlank()

    fun isLastNameBlank(): Boolean = lastName.isBlank()

    fun isNameCharactersValid(): Boolean = onlyLetters(firstName) && onlyLetters(lastName)

    private fun onlyLetters(string: String): Boolean {
        for (c in string)
        {
            if (c !in 'A'..'Z' && c !in 'a'..'z') {
                return false
            }
        }
        return true
    }

    fun isPasswordValid(): Boolean = onlyLetters(password)

    fun isPasswordBlank(): Boolean = password.isBlank()

    fun isEmailBlank(): Boolean = email.isBlank()





//Verification Fragment
    var verification_code = ""

    fun isVerififcationMatching(): Boolean{
        //Check matching with generated code from backend

        return true
    }


}