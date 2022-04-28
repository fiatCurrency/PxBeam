package uk.co.sevrin.pxbeamtest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import uk.co.sevrin.pxbeam.BeamClientAdaptor
import uk.co.sevrin.pxbeam.IBeamClientCallback

class MainActivity :
    IBeamClientCallback,
    AppCompatActivity()
{
    private lateinit var beamer : BeamClientAdaptor
    private lateinit var console : Console
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        console = Console(this,R.id.txvConsole)
        beamer = BeamClientAdaptor(this)
    }

    override fun onBeamClientStatusChanged(newStatus: Int) {
        console.print ("Client status: $newStatus")
    }

    fun onBtnConnectClick(view: View) {
        beamer.connect()
    }

}

class Console (private val context : AppCompatActivity, private val txv : Int)
{
    private var consoleText : String = ""
    private val textView = context.findViewById<TextView>(txv)
    fun print( s : String )
    {
        if (consoleText!="") consoleText += "\n"
        consoleText += s
        textView.text = consoleText;
    }
}