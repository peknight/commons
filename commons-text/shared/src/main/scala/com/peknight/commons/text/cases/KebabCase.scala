package com.peknight.commons.text.cases

object KebabCase extends StringCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(_.toLowerCase).mkString("-")
end KebabCase
