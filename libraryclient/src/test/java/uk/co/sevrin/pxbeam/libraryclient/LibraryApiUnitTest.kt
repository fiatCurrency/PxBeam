package uk.co.sevrin.pxbeam.libraryclient

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import uk.co.sevrin.pxbeam.*
import uk.co.sevrin.pxbeam.leafapi.LeafApi

/**
 * Class to test that the API from Library is accessible to a client (which
 * this is).
 */
class LibraryApiUnitTest {
    @Test
    fun test_LibraryMain() {
        assertThat(LibraryMain().start(), `is`(true))
    }

    @Test
    fun test_LeafApi() {
        assertThat(LeafApi().start(), `is`(true))
    }
}