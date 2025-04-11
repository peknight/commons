package com.peknight.commons.text.cases

object CamelSnakeCase extends StringCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else s"${values.head.toLowerCase}${values.tail.map(value => s"_${StringCaseOps.capitalize(value)}").mkString}"
end CamelSnakeCase
