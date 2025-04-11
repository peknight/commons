package com.peknight.commons.text.cases

object CamelCase extends StringCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else s"${values.head.toLowerCase}${values.tail.map(StringCaseOps.capitalize).mkString}"
end CamelCase
