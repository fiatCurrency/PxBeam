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
        assertEquals(s.innerLoopCount,20)
        assertEquals(s.innerLoopOffTime,8)
        assertEquals(s.outerLoopCount,30)
        assertEquals(s.outerLoopOffTime,40)
    }
}