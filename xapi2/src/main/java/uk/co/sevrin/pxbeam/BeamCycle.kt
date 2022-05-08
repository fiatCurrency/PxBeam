package uk.co.sevrin.pxbeam

/**
 * Class holding timing and repetition information for transmitting a (barcode) *Symbol*
 * to make for an easier capture by laser-reading devices.
 * Each *Symbol* is transmitted using [bitTime] to represent the LED on/off period for each bit in
 * the bytes that make up the *Symbol* pattern.
 *
 * There are [groupCount] *Group*s in a [BeamCycle] and each *Group* consists of [symbolsPerGroup]
 * identical transmissions of the *Symbol*.
 *
 * Within each *Group*, transmission of each *Symbol* is followed by a period [symbolOffTime], where
 * the LED is dark.
 *
 * Transmission of each *Group* is followed by a period [groupOffTime], where the LED is dark.
 *
 * The units of time for [bitTime], [symbolOffTime], [groupOffTime] are implementation
 * dependent.
 *
 * This is a simple data class: no restriction is placed on the contents, save that they
 * all fit into the range of an [Int].
 */

@Suppress("KDocMissingDocumentation")
public data class BeamCycle(
    var bitTime: Int,
    var symbolsPerGroup: Int,
    var symbolOffTime: Int,
    var groupCount: Int,
    var groupOffTime: Int
)