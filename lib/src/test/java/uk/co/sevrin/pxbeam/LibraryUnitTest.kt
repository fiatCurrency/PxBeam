package uk.co.sevrin.pxbeam

import org.junit.Assert.assertEquals
import org.junit.Test

class LibraryUnitTest {
    // This is simply to check that the class is accessible
    @Test
    fun test_BeamCycle() {
        val s = BeamCycle(1, 2, 3, 4, 5)
        assertEquals(s.bitTime, 1)
    }
}