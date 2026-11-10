package com.uno.lock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootResetReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            // Reboot selalu menonaktifkan lock. Tidak ada auto-launch setelah boot.
            LockPrefs.setEnabled(context, false)
        }
    }
}
