package com.peknight.commons.text.cases

object FlatCase extends TextCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(_.toLowerCase).mkString
end FlatCase


