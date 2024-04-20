package com.peknight.commons.string.syntax

import com.peknight.commons.string.cases.{StringCase, StringCaseOps}

trait StringCaseSyntax:
  extension (value: String)
    def capitalize: String = StringCaseOps.capitalize(value)
    def to(stringCase: StringCase): String = StringCaseOps.to(value, stringCase)
    def splitByCase: Seq[String] = StringCaseOps.split(value)
  end extension
end StringCaseSyntax
object StringCaseSyntax extends StringCaseSyntax