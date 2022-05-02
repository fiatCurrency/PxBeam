package uk.co.sevrin.pxbeam

import android.os.Handler
import android.os.Looper
import android.util.Log

internal class UpdaterThread(
    looper: Looper,
    private val sleepMillis: Long,
    private val func: ()->Unit) : Thread() {

    private val handler = Handler(looper)
    private val tag = "UpdaterThread()"
    @Volatile private var exitRequest = false

    fun stopSynchronously() {
        exitRequest = true
        this.interrupt()
        this.join()
    }

    override fun run() {
        Log.d(tag,"Infinite loop entered")
        while (!exitRequest) {
            try {
                Log.d(tag,"Posting runnable to handler")
                handler.post(func)
                Log.d(tag, "Entering sleep")
                sleep(sleepMillis)
                Log.d(tag, "Sleep exited normally")
            } catch (e: InterruptedException) {
                Log.d(tag, "Sleep interrupted")
            }
            Log.d(tag,"Infinite loop exited")
        }
    }
}
