package uk.co.sevrin.pxbeam.leafapi

/** Class to implement a dummy API, which is visible to the Library,
 * and transitively to the clients of that Library.
 */
@Suppress("KDocMissingDocumentation", "UseExpressionBody")
class LeafApi {
    fun start(): Boolean {
        return true
    }
}