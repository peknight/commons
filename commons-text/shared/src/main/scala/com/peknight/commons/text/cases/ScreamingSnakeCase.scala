package com.peknight.commons.text.cases

object ScreamingSnakeCase extends StringCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(_.toUpperCase).mkString("_")
end ScreamingSnakeCase
