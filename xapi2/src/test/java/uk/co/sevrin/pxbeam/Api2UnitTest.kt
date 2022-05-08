package uk.co.sevrin.pxbeam

import org.junit.Test
import org.junit.Assert.*

class Api2UnitTest {
    /**
     * Simple test, to make sure that the BeamCycle class has its members
     *   in the expected order!
     */
    @Test
    fun use_BeamCycle() {
        val s = BeamCycle(100, 20, 8, 30, 40)
        assertEquals(s.bitTime, 100)
        assertEquals(s.symbolsPerGroup, 20)
        assertEquals(s.symbolOffTime, 8)
        assertEquals(s.groupCount, 30)
        assertEquals(s.groupOffTime, 40)
    }
}