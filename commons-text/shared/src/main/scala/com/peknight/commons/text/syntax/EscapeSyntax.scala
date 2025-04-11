package com.peknight.commons.text.syntax

import com.peknight.commons.text.escape.EscapeOps

trait EscapeSyntax:
  extension (value: String)
    def escape(charsToEscape: Set[Char], escapeChar: Char = '\\'): String =
      EscapeOps.escape(value, charsToEscape, escapeChar)
  end extension
end EscapeSyntax
object EscapeSyntax extends EscapeSyntax
