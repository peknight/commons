package com.peknight.commons.string.escape

object EscapeOps:
  def escape(input: String, charsToEscape: Set[Char], escapeChar: Char = '\\'): String =
    input.flatMap(ch => if charsToEscape.contains(ch) then s"$escapeChar$ch" else s"$ch")
end EscapeOps
