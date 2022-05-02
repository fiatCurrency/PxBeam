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