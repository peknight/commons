package com.peknight.commons.bigint

import scodec.bits.ByteVector

object BigIntOps:
  def fromUnsignedBytes(magnitude: ByteVector): BigInt = BigInt(1, magnitude.toArray)

  def toUnsignedBytes(bigInt: BigInt): ByteVector =
    val twosComplementBytes = ByteVector(bigInt.toByteArray)
    if bigInt.bitLength % 8 == 0 && twosComplementBytes.length > 1 && twosComplementBytes.head == 0 then
      twosComplementBytes.tail
    else
      twosComplementBytes

  def toUnsignedBytes(bigInt: BigInt, minLength: Int): ByteVector =
    val notPadded = toUnsignedBytes(bigInt)
    if notPadded.length >= minLength then notPadded
    else ByteVector.fill(minLength - notPadded.length)(0) ++ notPadded
end BigIntOps