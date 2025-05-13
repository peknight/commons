package com.peknight.commons.text.syntax

import com.peknight.commons.text.cases.TextCase

trait TextCaseSyntax:
  extension (value: String)
    def capitalize: String = com.peknight.commons.text.cases.capitalize(value)
    def to(textCase: TextCase): String = com.peknight.commons.text.cases.to(value, textCase)
    def splitByCase: List[String] = com.peknight.commons.text.cases.split(value)
  end extension
end TextCaseSyntax
object TextCaseSyntax extends TextCaseSyntax