import fs2.StreamApp
import monix.eval.Task
import monix.execution.Scheduler.Implicits.global
import org.http4s.server.blaze.BlazeBuilder
object Main extends StreamApp[Task] {

  val service = new Service()

  def server(args: List[String]): fs2.Stream[Task, StreamApp.ExitCode] = {
    BlazeBuilder[Task]
      .bindHttp(8080, "0.0.0.0")
      .mountService(service.service(), "/api")
      .serve
  }

//  def shutdown(server: Server[Task]): Task[Unit] =
//    server.shutdown

  override def stream(args: List[String], requestShutdown: Task[Unit]): fs2.Stream[Task, StreamApp.ExitCode] = {
    server(args)
  }
}
