package uk.co.sevrin.pxbeam
/**
 A Packet is the same barcode symbol transmitted multiple times sequentially.
 A PacketLoop is the same Packet transmitted mutiple times sequentially.

 @param bitTime the time corresponding to the transmission of one bit, out of the
 bytes that form the barcode symbol.
 @param symbolsPerPacket the number of times the barcode symbol is transmitted in
 one packet.
 @param symbolOffTime the time after each symbol in a packet, where the LED is off.
 @param packetsPerLoop the number of Packets that are transmitted in one PacketLoop.
 @param packetOffTime the time after each Packet in a PacketLoop, where the LED is off.

 The barcode symbol is thus transmitted symbolsPerPacket * packetsPerLoop times.

 The units of time in bitTime, symbolOffTime, and packetOffTime are implementation
 dependent.

 This is a simple data class, with no restrictions on the contents, other than that they
 fit within an Int
*/

public data class PacketLoop(
    var bitTime: Int,
    var symbolsPerPacket: Int,
    var symbolOffTime: Int,
    var packetsPerLoop: Int,
    var packetOffTime: Int
)