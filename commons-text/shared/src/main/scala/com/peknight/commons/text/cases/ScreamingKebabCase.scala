package com.peknight.commons.text.cases

object ScreamingKebabCase extends TextCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(_.toUpperCase).mkString("-")
end ScreamingKebabCase
