import monix.eval.Task
import monix.execution.Scheduler
import org.http4s.HttpService
import org.http4s.dsl.Http4sDsl

class Service()(implicit scheduler: Scheduler) extends Http4sDsl[Task] {
  def service() = HttpService[Task] {
    case _ => Ok("Hello")
  }
}
