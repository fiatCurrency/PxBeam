package uk.co.sevrin.pxbeam
/**
 * Class holding timing and repetition information for transmitting a (barcode) *Symbol*
 * a large number of times, to make for an easier capture by laser-reading devices.
 *
 * The repetition is broken into *Group*s, each of which transmits the *Symbol*
 * a constant number of times.
 *
 * @param bitTime the time corresponding to one bit in the pattern of bytes that
 * represent the *Symbol*; this is PCM.
 * @param symbolsPerGroup the number of times the *Symbol* is transmitted within
 * a *Group*.
 * @param symbolOffTime the time delay between successive transmissions of the
 * *Symbol* within each *Group*.
 * @param groupCount the number of *Group*s within the whole [BeamCycle]
 * @param groupOffTime the time delay between *Group*s within the whole [BeamCycle]
 *
 * For a given [BeamCycle], the *Symbol* is thus transmitted
 * [symbolsPerGroup] * [groupCount] times.
 *
 * During [symbolOffTime] and [groupOffTime], the LED is dark.
 *
 * The units of time for [bitTime], [symbolOffTime], [groupOffTime] are implementation
 * dependent.
 *
 * This is a simple data class: no restriction is placed on the contents, save that they
 * all fit into the range of an [Int].
 */

public data class BeamCycle(
    var bitTime: Int,
    var symbolsPerGroup: Int,
    var symbolOffTime: Int,
    var groupCount: Int,
    var groupOffTime: Int
)