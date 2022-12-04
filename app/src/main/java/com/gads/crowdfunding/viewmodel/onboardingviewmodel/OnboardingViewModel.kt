package com.gads.crowdfunding.viewmodel.onboardingviewmodel

import androidx.lifecycle.ViewModel

class OnboardingViewModel : ViewModel() {
//Login Fragment

    //The email and password are being recorded from the View using Data binding
    var email = ""
    var password = ""


    fun isCredentialsValid(): Boolean {
        //Return true if backend returns true else return false

        return false
    }




//SignUp Fragment

    var firstName = ""
    var lastName = ""
    private var name = "$firstName $lastName"


    fun isNameBlank(): Boolean =  true //firstName.isBlank() && lastName.isBlank()

    fun isNameCharactersValid(): Boolean{
       return onlyLetters(name)
    }

    private fun onlyLetters(s: String): Boolean = (s.firstOrNull { !it.isLetter() } == null)




//Verification Fragment
    var verification_code = ""

    fun isVerififcationMatching(): Boolean{
        //Check matching with generated code from backend

        return false
    }


}