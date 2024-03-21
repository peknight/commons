package com.peknight.commons.string.syntax

import com.peknight.commons.string.escape.EscapeOps

trait EscapeSyntax:
  extension (value: String)
    def escape(charsToEscape: Set[Char], escapeChar: Char = '\\'): String =
      EscapeOps.escape(value, charsToEscape, escapeChar)
  end extension
end EscapeSyntax
object EscapeSyntax extends EscapeSyntax
