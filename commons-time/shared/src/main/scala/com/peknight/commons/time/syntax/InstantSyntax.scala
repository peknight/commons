package com.peknight.commons.time.syntax

import java.time.Instant
import scala.concurrent.duration.*

trait InstantSyntax:
  extension (instant: Instant)
    def toDuration: FiniteDuration = instant.getEpochSecond.seconds + instant.getNano.nanos
  end extension
end InstantSyntax
object InstantSyntax extends InstantSyntax
