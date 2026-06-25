package com.peknight.commons.text.syntax

import com.peknight.commons.text.escape.escape as apply

trait EscapeSyntax:
  extension (value: String)
    def escape(charsToEscape: Set[Char], escapeChar: Char = '\\'): String =
      apply(value, charsToEscape, escapeChar)
  end extension
end EscapeSyntax
object EscapeSyntax extends EscapeSyntax
