package com.peknight.commons.text.cases

object PascalCase extends TextCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(capitalize).mkString
end PascalCase
