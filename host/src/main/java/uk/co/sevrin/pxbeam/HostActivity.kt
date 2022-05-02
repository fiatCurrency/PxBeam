package uk.co.sevrin.pxbeam

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import java.util.*

class HostActivity : AppCompatActivity() {

    private val tag = "HostActivity"
    private lateinit var txv: TextView
    override fun onCreate(sis: Bundle?) {
        Log.d(tag,">>onCreate()")
        super.onCreate(sis)
        setContentView(R.layout.activity_host)
        txv = this.findViewById(R.id.txvTime)
        Log.d(tag,"<<onCreate()")
    }
}
    override fun onStart() {
        Log.d(tag,">>onStart()")
        super.onStart()
        Log.d(tag,"<<onStart()")
    }

    override fun onResume() {
        Log.d(tag,">>onResume()")
        super.onResume()
        Log.d(tag,"<<onResume()")
    }

    override fun onPause() {
        Log.d(tag,">>onPause()")
        super.onPause()
        Log.d(tag,"<<onPause()")
    }

    override fun onStop() {
        Log.d(tag,">>onStop()")
        super.onStop()
        Log.d(tag,"<<onStop()")
    }

    private fun onTick() {
        Log.d(tag,">>onTick()")
        val gc = GregorianCalendar()
        val h = gc.get(GregorianCalendar.HOUR_OF_DAY)
        val m = gc.get(GregorianCalendar.MINUTE)
        val s = gc.get(GregorianCalendar.SECOND)
        val str = String.format("%02d:%02d:%02d",h,m,s)
        txv.text = str
        Log.d(tag,"<<onTick()")
    }

    inner class UpdaterThread(
        looper: Looper,
        private val sleepMillis: Long,
        private val func: ()->Unit) : Thread()
    {
        private val handler = Handler(looper)
        private val tag = "UpdaterThread()"
        @Volatile private var exitRequest = false
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
            }
            Log.d(tag,"Infinite loop exited")
        }
    }

}
