package contract

import io.circe.generic.semiauto._
import io.circe.{Decoder, Encoder}

// for practice with Circe
sealed trait Recipe extends Product with Serializable {
  val name: String
  val ingredients: List[String]
  val instructions: String
}

case class Feast(name: String, ingredients: List[String], instructions: String, winePairing: List[Wine], servings: Int) extends Recipe
case class Dinner(name: String, ingredients: List[String], instructions: String, winePairing: List[Wine]) extends Recipe
case class Lunch(name: String, ingredients: List[String], instructions: String) extends Recipe
case class Breakfast(name: String, ingredients: List[String], instructions: String) extends Recipe

object Recipe {
  implicit val feastEncoder: Encoder[Feast] = deriveEncoder[Feast]
  implicit val dinnerEncoder: Encoder[Dinner] = deriveEncoder[Dinner]
  implicit val lunchEncoder: Encoder[Lunch] = deriveEncoder[Lunch]
  implicit val breakfastEncoder: Encoder[Breakfast] = deriveEncoder[Breakfast]

  implicit val feastDecoder: Decoder[Feast] = deriveDecoder[Feast]
  implicit val dinnerDecoder: Decoder[Dinner] = deriveDecoder[Dinner]
  implicit val lunchDecoder: Decoder[Lunch] = deriveDecoder[Lunch]
  implicit val breakfastDecoder: Decoder[Breakfast] = deriveDecoder[Breakfast]

  implicit val recipeEncoder: Encoder[Recipe] = Encoder.instance{
    case f : Feast => feastEncoder.apply(f)
    case d : Dinner => dinnerEncoder.apply(d)
    case l : Lunch => lunchEncoder.apply(l)
    case b : Breakfast => breakfastEncoder.apply(b)
    case _ => ???
  }
  implicit val recipeDecoder: Decoder[Recipe] = ???
}
