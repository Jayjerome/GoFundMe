package com.gads.crowdfunding.util

import android.text.TextUtils
import android.util.Patterns
import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class Constants {

    companion object {

        const val BASE_URL = "https://fintech21.uc.r.appspot.com/v1/api/"

        const val TAG = "GoFundMe"

        private val c = charArrayOf('k', 'm', 'b', 't')

        fun coolFormat(n: Double, iteration: Int): String? {
            val d = n.toLong() / 100 / 10.0
            val isRound =
                d * 10 % 10 == 0.0 //true if the decimal part is equal to 0 (then it's trimmed anyway)
            return (if (d < 1000) //this determines the class, i.e. 'k', 'm' etc
                (if (d > 99.9 || isRound || !isRound && d > 9.99) //this decides whether to trim the decimals
                    d.toInt() * 10 / 10 else d.toString() + "" // (int) d * 10 / 10 drops the decimal
                        ).toString() + "" + c[iteration] else coolFormat(d, iteration + 1))
        }

        fun isValidEmail(email: String): Boolean {
            return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isValidPassword(password: String): Boolean {
            val pattern: Pattern
            val passwordPattern =
                "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&+=!_])(?=\\S+$).{4,}$"
            pattern = Pattern.compile(passwordPattern)
            val matcher: Matcher = pattern.matcher(password)
            return matcher.matches()
        }

        fun getRandomNumberString(): String {
            val rnd = Random()
            val number: Int = rnd.nextInt(999999)
            return String.format("%06d", number)
        }
    }
}