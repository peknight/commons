package com.peknight.commons.string.cases

object ScreamingSnakeCase extends StringCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(_.toUpperCase).mkString("_")
end ScreamingSnakeCase
