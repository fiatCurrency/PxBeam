package uk.co.sevrin.pxbeam

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Handler
import android.os.IBinder
import android.os.Looper.getMainLooper
import android.os.Message
import android.os.Messenger
import uk.co.sevrin.pxbcommon.ResponseCode

class BeamClientAdaptor(private val context: Context) :
        ServiceConnection, Handler.Callback {

    private val servicePackage = "uk.co.sevrin.pxbeamservice"
    private val serviceClass = ".PxBeamService"
    private val theCallback: IBeamClientCallback = (context as IBeamClientCallback)

        // These are the state variable corresponding to the various stages of connection.
        //   It is possible that we can do without the explicit machineState.
    private var machineState: Int = 0

    private var bindingFlag : Boolean = false
    private var theService: Messenger? = null
    private var clientIndex: Int = -1

        // Machine States
        // 1 = binding flag (not yet implemented) is true.
        // 2 = as 1, and theService has been set to a non-null value.
        // 3 = as 2, and clientIndex has been set to a positive value.
        // So, we can get rid of machineState, as it can be inferred from all the above.

        // This is the handler for messages FROM the Service, TO the Client (this). It is also
        //   what gives this particular client its registration and identity.
    private var theMessenger = Messenger(Handler(getMainLooper())
        { msg -> this.handleMessage(msg) })

        // First stage of connection attempt
        //
    fun connect() : Boolean {
        if (!bindingFlag) {
            val intent = Intent().setClassName(servicePackage, servicePackage + serviceClass)
            bindingFlag = context.bindService(intent, this, Context.BIND_AUTO_CREATE)
            setMachineState( if (bindingFlag) 1 else 0 )
        }
        return bindingFlag
    }
        // Second stage of connection attempt
        //
    override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
        if (p1!=null && machineState==1) {
            val service = Messenger(p1)
            val msg = Message.obtain(null, 1).also { it.replyTo = theMessenger }
            service.send(msg)
            theService = service
            setMachineState(2)
        }  // what do we do if the service connection arrives in the wrong state ?
    }

    // Third stage of connection attempt
    //
    private fun onServiceRegistered(cix : Int) {
        if (machineState==2) {
            clientIndex = cix // We shouldn't get a <=0 value here, so we'll need an assert.
            setMachineState(3)
        }
    }

    // First stage of disconnection attempt
    private fun onServiceUnregistered() {
        if (machineState==3) {  // What do we do if it isn't ?
            clientIndex = -1
            setMachineState(2)
        }
    }

    // TODO. Not quite sure WTD with this, yet. I want to get the whole connect/bind/register/unbind
    //   life-cycle clear first.
    // Second stage of disconnection attempt
    override fun onServiceDisconnected(p0: ComponentName?) {
        TODO("Not yet implemented")
    }

        // Despatch incoming messages from Service to their handlers, irrespective of which
        //   machineState we are in
    override fun handleMessage(p0: Message) : Boolean {
        return when(p0.what) {
            ResponseCode.clientRegistrationIndex -> {
                val cix = p0.arg1
                if (cix>0)
                    onServiceRegistered(cix) else onServiceUnregistered()
                true
            }
            else -> false
        }
    }

        // Set the machineState, and signal that new state to the client.
        //   Setting a particular machineState assumes all the parameters and conditions
        //     pertaining to that machineState have already been set-up; that does not
        //     get enforced here.
        //   We may decide to get rid of the idea of a numeric machineState, and just have
        //     the machine's state inferred from the setting of other pertinent parameters.
    private fun setMachineState(newState: Int) {
        machineState = newState
        theCallback.onBeamClientStatusChanged(newState)
    }

}