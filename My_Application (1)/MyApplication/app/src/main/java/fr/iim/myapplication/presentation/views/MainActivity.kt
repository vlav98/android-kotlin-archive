package fr.iim.myapplication.presentation.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.iim.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_button_login.setOnClickListener {
            val intent = Intent(this@MainActivity, FeedActivity::class.java)
            startActivity(intent)
        }


    }

}



