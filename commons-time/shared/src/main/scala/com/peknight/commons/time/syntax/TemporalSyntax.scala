package com.peknight.commons.time.syntax

import java.time.temporal.Temporal
import scala.concurrent.duration.FiniteDuration
import scala.jdk.DurationConverters.*

trait TemporalSyntax:
  extension [T <: Temporal] (temporal: T)
    def plus(duration: FiniteDuration): T = temporal.plus(duration.toJava).asInstanceOf[T]
    def +(duration: FiniteDuration): T = plus(duration)
    def minus(duration: FiniteDuration): T = temporal.minus(duration.toJava).asInstanceOf[T]
    def -(duration: FiniteDuration): T = minus(duration)
  end extension
end TemporalSyntax
object TemporalSyntax extends TemporalSyntax
