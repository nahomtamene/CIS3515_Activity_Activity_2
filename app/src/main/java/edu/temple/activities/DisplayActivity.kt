package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class DisplayActivity : AppCompatActivity() {
    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            it.data?.apply {
                val selectedSize = getFloatExtra("fontSize", 16f) // Default to 16f if not found
                lyricsDisplayTextView.textSize = selectedSize
            }
        }
    }
    // TODO Step 3: Use returned value for lyricsDisplayTextView text size



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        Log.d("Fired", "onCreate()")

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        findViewById<Button>(R.id.textSizeSelectorButton).setOnClickListener {
            val launchIntent = Intent(this@DisplayActivity, TextSizeActivity::class.java)
            launchIntent.putExtra("Message", "Message to second activity")
            launcher.launch(launchIntent)
        }

    }
}