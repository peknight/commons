package com.peknight.commons.string.cases

object PascalSnakeCase extends StringCase:
  def join(values: Seq[String]): String =
    if values.isEmpty then ""
    else values.map(StringCaseOps.capitalize).mkString("_")
end PascalSnakeCase
