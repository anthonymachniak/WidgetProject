package e.amachniak.widgetproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView

const val ACTIVITY_MESSAGES = "AppDictionary"

class MainActivity : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.onRatingBarChangeListener = this
    }

    override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
        val text = findViewById<TextView>(R.id.textView)

        var rating = 0F
        if (p0?.rating != null)
        {
            rating = p0?.rating
        }

        if (rating == 0F)
        {
            text.setText("Please rate this app")
        }
        else if (rating < 5)
        {
            saveRating(rating)
            startActivity(intent)
        }
        else
        {
            text.setText("Thank you for the 5 star rating!")
        }
    }

    fun saveRating(rating: Float) {
        var savedRating = rating.toString()

        intent = Intent(this, Popup::class.java).apply {
            putExtra(ACTIVITY_MESSAGES, savedRating)
        }
    }
}
