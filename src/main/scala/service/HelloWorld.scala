package service

import monix.eval.Task
import monix.execution.Scheduler
import org.http4s.HttpService
import org.http4s.dsl.Http4sDsl

class HelloWorld()(implicit scheduler: Scheduler) extends Http4sDsl[Task] {
  def service() = HttpService[Task] {
    case GET -> Root / "hello" / name => Ok(s"Hello $name" )
    case request @ PUT -> Root / "put" => Ok(s"received request from ${request.from}, headers ${request.headers} body ${request.body}")
    case DELETE -> Root / "delete" => Ok(s"delete")
  }
}
