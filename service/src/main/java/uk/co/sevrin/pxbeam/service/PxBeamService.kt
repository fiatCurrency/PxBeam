package uk.co.sevrin.pxbeam.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * The remote service implementing the beaming operation.
 * Other client applications will connect to this.
 */
class PxBeamService : Service() {

    @Suppress("KDocMissingDocumentation")
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}