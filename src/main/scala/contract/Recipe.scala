package contract

import io.circe.{Decoder, Encoder}

// for practice with Circe
sealed trait Recipe extends Product with Serializable {
  val name: String
  val ingredients: List[String]
  val instructions: String
}

case class Feast(name: String, ingredients: List[String], instructions: String, winePairing: List[Wine], servings: Int, ) extends Recipe
case class Dinner(name: String, ingredients: List[String], instructions: String, winePairing: List[Wine]) extends Recipe
case class Lunch(name: String, ingredients: List[String], instructions: String) extends Recipe
case class Breakfast(name: String, ingredients: List[String], instructions: String) extends Recipe

object Recipe {
  implicit val recipeEncoder: Encoder[Recipe] = ???
  implicit val recipeDecoder: Decoder[Recipe] = ???
}
