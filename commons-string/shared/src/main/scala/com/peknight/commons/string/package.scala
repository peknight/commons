package com.peknight.commons

package object string:
  def escape(input: String, escapeCharacter: Char, escapeCharacters: Set[Char]): String =
    input.flatMap(ch => if escapeCharacters.contains(ch) then s"$escapeCharacter$ch" else s"$ch")
end string
