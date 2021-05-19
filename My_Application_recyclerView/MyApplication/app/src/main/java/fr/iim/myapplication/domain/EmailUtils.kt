package fr.iim.myapplication.domain

import android.util.Patterns

object EmailUtils {

    fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}