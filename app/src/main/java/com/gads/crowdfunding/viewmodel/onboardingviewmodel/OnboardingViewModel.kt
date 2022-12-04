package com.gads.crowdfunding.viewmodel.onboardingviewmodel

import androidx.lifecycle.ViewModel

class OnboardingViewModel : ViewModel() {
//Login Fragment

    //The email and password are being recorded from the View using Data binding
    var email = ""
    var password = ""


    fun isCredentialsValid(): Boolean {
        //Return true if backend returns true else return false

        return true
    }

    fun isFieldsEmpty(): Boolean = email.isBlank() && password.isBlank()




//SignUp Fragment

    var firstName = ""
    var lastName = ""
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

        return false
    }


}