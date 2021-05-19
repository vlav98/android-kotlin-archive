package fr.iim.myapplication.presentation.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.iim.myapplication.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        main_button_login.setOnClickListener {

            val intent = Intent(this@LoginActivity, FeedActivity::class.java)
            startActivity(intent)
        }


    }

}



