package com.alakhaly.assistant

import android.app.Service
import android.content.Intent
import android.os.IBinder

class AlAkhalyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Handle background speech listening, floating UI button, and system actions
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
