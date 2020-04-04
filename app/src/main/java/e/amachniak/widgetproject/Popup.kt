package e.amachniak.widgetproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class Popup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popup_window)

        var display = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(display)

        var width = display.widthPixels
        var height = display.heightPixels

        window.setLayout((width*.8).toInt(), (height*.6).toInt())

        var rating = intent.getStringExtra(ACTIVITY_MESSAGES)

        var message = "Are you sure you want to give a $rating star rating?"
        var areYouSureText = findViewById<TextView>(R.id.areYouSure)
        areYouSureText.setText(message)

        var yesButton = findViewById<Button>(R.id.yes)
        var noButton = findViewById<Button>(R.id.no)

        yesButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                var randomNumber = Random.nextInt(1, 5)
                when (randomNumber) {
                    1 -> message = "Are you really really sure?"
                    2 -> message = "I don't think this app is less than $rating stars"
                    3 -> message = "Have you changed your mind yet?"
                    4 -> message = "My mother told me it was a 5 star app."
                    5 -> message = "I really need a good rating for this app."
                }

                areYouSureText.setText(message)
            }
        })

        intent = Intent(this, MainActivity::class.java)
        noButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                startActivity(intent)
            }
        })
    }
}
