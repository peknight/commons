package com.peknight.commons.text.cases

object ScreamingKebabCase extends StringCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(_.toUpperCase).mkString("-")
end ScreamingKebabCase
