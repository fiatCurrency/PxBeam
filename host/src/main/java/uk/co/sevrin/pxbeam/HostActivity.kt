package uk.co.sevrin.pxbeam

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

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
