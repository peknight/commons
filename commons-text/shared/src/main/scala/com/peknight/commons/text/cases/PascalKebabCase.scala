package com.peknight.commons.text.cases

object PascalKebabCase extends StringCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(StringCaseOps.capitalize).mkString("-")
end PascalKebabCase
