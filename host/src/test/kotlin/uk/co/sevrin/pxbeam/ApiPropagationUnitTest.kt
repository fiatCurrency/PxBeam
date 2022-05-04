package uk.co.sevrin.pxbeamhost

import org.junit.Test
import org.junit.Assert.*

class ApiPropagationUnitTest {
    @Test
        fun test_Sweep() {
        var s = Sweep(10,20,30,40,50)
        assertEquals(10,s.bitTime)
        assertEquals(20,s.innerLoopCount)
        assertEquals(30,s.innerLoopOffTime)
        assertEquals(40,s.outerLoopCount)
        assertEquals(50,s.outerLoopOffTime)
    }
}
