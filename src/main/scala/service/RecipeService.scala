package service

import contract.Lunch
import monix.eval.Task
import monix.execution.Scheduler
import org.http4s.HttpService
import org.http4s.dsl.Http4sDsl
import contract.Recipe._
import io.circe.syntax._
import org.http4s.circe._

// Note, we are chosing to put the scheduler on the class instead of the routes so that we can specify execution contexts
// for the routes vs for the other work in the app
class RecipeService()(implicit scheduler: Scheduler) extends Http4sDsl[Task]{
  def service() =  HttpService[Task] {
    case GET -> Root / "recipe"  => Ok(
      Lunch("BLT", List("Bacon", "Lettuce", "Tomato"), "Make a sandwich").asJson)
    case _ => ???
  }
}
