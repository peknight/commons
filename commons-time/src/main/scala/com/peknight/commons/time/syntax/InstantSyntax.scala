package com.peknight.commons.time.syntax

import java.time.Instant
import scala.concurrent.duration.*

trait InstantSyntax:
  extension (instant: Instant)
    def toDuration: FiniteDuration = instant.getEpochSecond.seconds + instant.getNano.nanos
    def minus(that: Instant): FiniteDuration = toDuration - that.toDuration
    def -(that: Instant): FiniteDuration = minus(that)
  end extension
end InstantSyntax
object InstantSyntax extends InstantSyntax
