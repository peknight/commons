package com.peknight.commons.text.cases

object CamelKebabCase extends TextCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else s"${values.head.toLowerCase}${values.tail.map(value => s"-${capitalize(value)}").mkString}"
end CamelKebabCase
