package uk.co.sevrin.pxbeam.leafapi

import org.junit.Test
import org.hamcrest.Matchers.`is`
import org.hamcrest.MatcherAssert.assertThat

/**
 * In-module unit test to make sure we can see the LeafApi module. If
 * we can't do this, there's no point in trying to see it in (and through)
 * the Library (and its associated tests)
 */
class LeafApiUnitTest {
    @Test
    fun test_LeafApi() {
        assertThat(LeafApi().start(), `is`(true))
    }
}