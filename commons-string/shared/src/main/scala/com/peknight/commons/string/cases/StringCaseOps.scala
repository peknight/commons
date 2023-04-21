package com.peknight.commons.string.cases

import scala.collection.mutable.ListBuffer

object StringCaseOps:

  def capitalize(value: String): String =
    if value.isEmpty then ""
    else s"${value.head.toUpper}${value.tail.toLowerCase}"

  def to(value: String, stringCase: StringCase): String =
    if value.nonEmpty then
      val values = split(value)
      if values.isEmpty then ""
      else stringCase.join(values)
    else value

  def split(value: String): Seq[String] =
    val buf = ListBuffer.empty[String]
    val (_, lastChars) = value.foldLeft[(WordCase, ListBuffer[Char])]((WordCase.Empty, ListBuffer.empty[Char])) {
      case ((wordCase, chars), ch) =>
        val (nextWordCase, opt) = operation(wordCase, getCharType(ch))
        val nextChars = opt match
          case Operation.Ignore => chars
          case Operation.Append => chars += ch
          case Operation.FlushAndNew =>
            buf += chars.mkString
            ListBuffer(ch)
          case Operation.Flush =>
            buf += chars.mkString
            ListBuffer.empty[Char]
          case Operation.FlushInitAndNew =>
            buf += chars.init.mkString
            ListBuffer(chars.last, ch)
        (nextWordCase, nextChars)
    }
    if lastChars.nonEmpty then buf += lastChars.mkString
    buf.toList
  end split

  // 单词格式
  private[this] enum WordCase derives CanEqual:
    // 空
    case Empty
    // 大写字符（只有一个大写字母）
    case CapitalChar
    // 全大写（超过一个大写字母）
    case Upper
    // 全小写
    case Lower
    // 首字母大写（一个大写字母后有至少一个小写字母）
    case Capitalize
    // 数字
    case Digit
    // 其他文字字符
    case Letter
  end WordCase

  // 字符类型
  private[this] enum CharType derives CanEqual:
    // 大写字符
    case Upper
    // 小写字符
    case Lower
    // 数字
    case Digit
    // 除了大小写字符与数字外的文字字符
    case Letter
    // 特殊字符
    case Other
  end CharType

  private[this] def getCharType(ch: Char): CharType =
    if ch.isUpper then CharType.Upper
    else if ch.isLower then CharType.Lower
    else if ch.isDigit then CharType.Digit
    else if ch.isLetter then CharType.Letter
    else CharType.Other

  // 分词处理过程中的操作
  private[this] enum Operation derives CanEqual:
    // 忽略
    case Ignore
    // 向当前单词追加字符
    case Append
    // 存储当前单词，并创建新单词
    case FlushAndNew
    // 存储当前单词
    case Flush
    // 存在除最后一个字符外的当前单词，并以最后一个字符开头创建新单词
    case FlushInitAndNew
  end Operation

  // 遍历字符串过程中的操作
  private[this] def operation(wordCase: WordCase, charType: CharType): (WordCase, Operation) =
    (wordCase, charType) match
      case (WordCase.Empty, CharType.Upper) => (WordCase.CapitalChar, Operation.Append)
      case (WordCase.Empty, CharType.Lower) => (WordCase.Lower, Operation.Append)
      case (WordCase.Empty, CharType.Digit) => (WordCase.Digit, Operation.Append)
      case (WordCase.Empty, CharType.Letter) => (WordCase.Letter, Operation.Append)
      case (WordCase.Empty, CharType.Other) => (WordCase.Empty, Operation.Ignore)
      // 当前一个大写字符，再来一个大写字符，变成全大写单词
      case (WordCase.CapitalChar, CharType.Upper) => (WordCase.Upper, Operation.Append)
      // 当前一个大写字符，再来一个小写字符，变成首字母大写单词
      case (WordCase.CapitalChar, CharType.Lower) => (WordCase.Capitalize, Operation.Append)
      case (WordCase.Upper, CharType.Upper) => (WordCase.Upper, Operation.Append)
      // 当前一个全大写单词，再来一个小写字符，将当前单词的最后一个字符做为首字母，创建新的首字母大写单词
      case (WordCase.Upper, CharType.Lower) => (WordCase.Capitalize, Operation.FlushInitAndNew)
      case (WordCase.Lower, CharType.Lower) => (WordCase.Lower, Operation.Append)
      case (WordCase.Capitalize, CharType.Lower) => (WordCase.Capitalize, Operation.Append)
      case (WordCase.Digit, CharType.Digit) => (WordCase.Digit, Operation.Append)
      case (WordCase.Letter, CharType.Letter) => (WordCase.Letter, Operation.Append)
      case (_, CharType.Upper) => (WordCase.CapitalChar, Operation.FlushAndNew)
      case (_, CharType.Lower) => (WordCase.Lower, Operation.FlushAndNew)
      case (_, CharType.Digit) => (WordCase.Digit, Operation.FlushAndNew)
      case (_, CharType.Letter) => (WordCase.Letter, Operation.FlushAndNew)
      case (_, CharType.Other) => (WordCase.Empty, Operation.Flush)
  end operation
end StringCaseOps
