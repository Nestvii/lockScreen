package com.uno.lock

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val statusText = findViewById<TextView>(R.id.statusText)
        val activateButton = findViewById<Button>(R.id.activateButton)

        fun refreshStatus() {
            statusText.text = if (LockPrefs.isEnabled(this)) {
                "Status: lock aktif"
            } else {
                "Status: tidak terkunci"
            }
        }

        activateButton.setOnClickListener {
            LockPrefs.setEnabled(this, true)
            startActivity(Intent(this, LockActivity::class.java))
        }

        refreshStatus()
    }

    override fun onResume() {
        super.onResume()
        if (LockPrefs.isEnabled(this)) {
            // Status aktif tidak otomatis memunculkan layar lock kembali.
            // LockActivity hanya dibuka melalui tombol aktivasi.
        }
        findViewById<TextView>(R.id.statusText).text =
            if (LockPrefs.isEnabled(this)) "Status: lock aktif" else "Status: tidak terkunci"
    }
}
