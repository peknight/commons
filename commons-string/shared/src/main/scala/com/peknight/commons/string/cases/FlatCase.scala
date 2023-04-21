package com.peknight.commons.string.cases

object FlatCase extends StringCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(_.toLowerCase).mkString
end FlatCase


