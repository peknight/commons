package com.peknight.commons.text.syntax

import com.peknight.commons.text.cases
import com.peknight.commons.text.cases.StringCase

trait StringCaseSyntax:
  extension (value: String)
    def capitalize: String = cases.capitalize(value)
    def to(stringCase: StringCase): String = cases.to(value, stringCase)
    def splitByCase: Seq[String] = cases.split(value)
  end extension
end StringCaseSyntax
object StringCaseSyntax extends StringCaseSyntax