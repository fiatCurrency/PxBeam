package uk.co.sevrin.pxbeam

import org.junit.Test
import org.junit.Assert.*

class Api2UnitTest {
    /**
     * Simple test, to make sure that the Sweep class has its members
     *   in the expected order!
     */
    @Test
    fun use_Sweep() {
        val s = Sweep(100,20,8,30,40)
        assertEquals(s.bitTime,100)
        assertEquals(s.symbolsPerPacket,20)
        assertEquals(s.postSymbolTime,8)
        assertEquals(s.packetsInPacketLoop,30)
        assertEquals(s.postPacketTime,40)
    }
}