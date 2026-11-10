package com.uno.lock

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LockActivity : Activity() {

    companion object {
        private const val PIN = "1234"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!LockPrefs.isEnabled(this)) {
            finish()
            return
        }

        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            )
        window.addFlags(
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
        )

        setContentView(R.layout.activity_lock)

        val pinInput = findViewById<EditText>(R.id.pinInput)
        val errorText = findViewById<TextView>(R.id.errorText)
        val unlockButton = findViewById<Button>(R.id.unlockButton)

        unlockButton.setOnClickListener {
            if (pinInput.text.toString() == PIN) {
                LockPrefs.setEnabled(this, false)
                Toast.makeText(this, "Berhasil dibuka", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                errorText.text = "PIN salah. Coba lagi."
                pinInput.text?.clear()
            }
        }
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        // Tombol Back tidak menutup layar lock; PIN tetap menjadi jalur normal.
        // Restart perangkat tetap dapat digunakan sebagai jalur pemulihan.
    }
}
