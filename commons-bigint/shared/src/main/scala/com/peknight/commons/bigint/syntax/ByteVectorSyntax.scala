package com.peknight.commons.bigint.syntax

import com.peknight.commons.bigint.BigIntOps
import scodec.bits.ByteVector

trait ByteVectorSyntax:
  extension (bytes: ByteVector)
    def toUnsignedBigInt: BigInt = BigIntOps.fromUnsignedBytes(bytes)
  end extension
end ByteVectorSyntax
object ByteVectorSyntax extends ByteVectorSyntax
