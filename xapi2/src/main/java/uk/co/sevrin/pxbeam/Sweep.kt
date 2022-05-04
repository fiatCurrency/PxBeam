package uk.co.sevrin.pxbeam

/**
 * Class representing the set of five parameters which define how a barcode
 * (also called a <i>Symbol</i>) is transmitted from a LED, to ensure a better capture
 * by the laser-based reader.
 * <br>
 * A <i>Packet</i> is a sequential transmission of a number of Symbols.
 * A <i>Sweep</i> (also called a <i>Packet Loop</i>) is a sequential transmission of
 * a number of Packets.
 * <br>
 * Breaking it down into Packets means that there can be a different dark interval
 * <i>within</i> a Packet to that <i>between</i> Packets.
 * <br>
 * @param[bitTime]<br><br><p>the time to which a single bit (a black or white element) corresponds.
 * @param[symbolsPerPacket]<br><br>the number of barcode symbols in a Packet.
 * @param[postSymbolTime] the time after each symbol within a Packet, for which the LED is off.
 * @param[packetsInPacketLoop] the number of Packets in the whole Sweep
 * @param[postPacketTime] the time after each Packet within the Sweep, for which the LED is off.
 * <br>
 * <br>
 * The symbol is thus transmitted [symbolsPerPacket] * [packetsInPacketLoop] times
 *
 * The actual time units corresponding to [postSymbolTime] and [postPacketTime]
 * is implementation dependent; they may or may not be interpreted as multiples
 * of [bitTime]
 * <br>
 * There is no restriction on the values of the parameters, save that they
 * fit in the size of an [Int].
 * It is assumed that the implementation will perform its own validation on
 * these parameters.
 * <br>
 * There is no special constructor; all the elements can be accessed as read/write
 * properties, independent from each other, from the outside.
 */
public class Sweep(
    public var bitTime: Int,
    public var symbolsPerPacket: Int,
    public var postSymbolTime: Int,
    public var packetsInPacketLoop: Int,
    public var postPacketTime: Int
)