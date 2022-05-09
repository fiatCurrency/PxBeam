package uk.co.sevrin.pxbeam

import org.hamcrest.CoreMatchers.`is`
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import uk.co.sevrin.pxbeam.leafapi.LeafApi

/**
 * Class to test that the class LibraryMain works in-module. If it doesn't,
 * then there's not much point trying to connect to it as part of the
 * library's API.
 *
 * The class also tests for access to the API which should be exposed to
 * this module from :leafapi
 */
class LibraryUnitTest {
    @Test
    fun test_LibraryMain() {
        assertThat(LibraryMain().start(), `is`(true))
    }

    @Test
    fun test_LeafApi() {
        assertThat(LeafApi().start(), `is`(true))
    }
}