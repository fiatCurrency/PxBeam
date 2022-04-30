package uk.co.sevrin.pxbeam.service

import android.os.IBinder
import android.os.Messenger

class ClientRegistry : HashMap<IBinder,Int>() {
    fun removeClient(msgr : Messenger) {
        this.remove(msgr.getBinder())
    }
    fun getClientIndex(msgr : Messenger) : Int {
        return ( this[msgr.getBinder()] ?: 0 )
    }
    private fun addNewClientIndex(msgr : Messenger) : Int {
        this[msgr.getBinder()] = bumpIndex()
        return newIndex
    }
    fun getOrAddClientIndex(msgr : Messenger) : Int {
        val ci = getClientIndex(msgr)
        assert(ci>=0)   // Note "greater than, or equal to", in this case
        return ( if (ci!=0) ci else addNewClientIndex(msgr) )
    }
    private fun bumpIndex() : Int {
        if ((++newIndex) <= 0 )
            newIndex = 1
        assert(newIndex>0)
        return newIndex
    }
    private var newIndex = 0
}