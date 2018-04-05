package contract

import io.circe.{Decoder, Encoder}

sealed trait Wine extends Product with Serializable
sealed trait RedWine extends Wine
sealed trait WhiteWine extends Wine

case object Merlot extends RedWine
case object PinotNoir extends RedWine

case object Riesling extends WhiteWine
case object PinotGris extends WhiteWine

case object Port extends Wine
case object Champagne extends Wine

object Wine {
  implicit val wineEncoder: Encoder[Wine] = ???
  implicit val wineDecoder: Decoder[Wine] = ???
}
