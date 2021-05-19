package fr.iim.myapplication.domain

import android.util.Patterns

object EmailUtils {

    fun isEmailValid(email: CharSequence) = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();


}