package com.peknight.commons.bigint.syntax

import com.peknight.commons.bigint.BigIntOps
import scodec.bits.ByteVector

trait BigIntSyntax:
  extension (bigInt: BigInt)
    def toUnsignedBytes: ByteVector = BigIntOps.toUnsignedBytes(bigInt)
    def toUnsignedBytes(minLength: Int): ByteVector = BigIntOps.toUnsignedBytes(bigInt, minLength)
  end extension
end BigIntSyntax
object BigIntSyntax extends BigIntSyntax
