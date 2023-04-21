package com.peknight.commons.string.cases

object CamelKebabCase extends StringCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else s"${values.head.toLowerCase}${values.tail.map(value => s"-${StringCaseOps.capitalize(value)}").mkString}"
end CamelKebabCase
