package uk.co.sevrin.pxbeamservice

import android.app.Service
import android.content.Intent
import android.os.*
import android.os.Looper.myLooper
import android.util.Log
import uk.co.sevrin.pxbcommon.*

class PxBeamService : Service() {

    override fun onCreate() { logD("onCreate()"); super.onCreate() }
    override fun onDestroy() { logD("onDestroy()"); super.onDestroy() }

    override fun onBind(p0: Intent?) : IBinder {
        return setupBinder()
    }

    private fun setupBinder() : IBinder {
        val looper = myLooper()
        if (looper == null)
            throw(RuntimeException())
        else
            return Messenger(IncomingHandler(looper)).getBinder()
    }
}

fun logD(s:String) {
    Log.d("pxbeamservice",s)
}


private class IncomingHandler(loop: Looper) : Handler(loop) {

    val clients = ClientRegistry()

    override fun handleMessage(command: Message) {
        val responseMessenger = command.replyTo
        when (command.what) {
            CommandCode.registerClient -> {
                responseMessenger.send(
                    Message.obtain(null, ResponseCode.clientRegistrationIndex).also {
                        it.arg1=clients.getOrAddClientIndex(responseMessenger)
                    })
            }
            CommandCode.unregisterClient -> {
                clients.removeClient(responseMessenger)
                responseMessenger.send(
                    Message.obtain(null, ResponseCode.clientRegistrationIndex).also {
                        it.arg1=clients.getClientIndex(responseMessenger)
                    })
            }
            else -> {
                super.handleMessage(command)
            }
        }
    }
}
