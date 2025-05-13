package com.peknight.commons.text.cases

object SnakeCase extends TextCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(_.toLowerCase).mkString("_")
end SnakeCase
