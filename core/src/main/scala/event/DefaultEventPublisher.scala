package event

/**
 * Created by roshansharma on 6/18/15.
 *
 * The default publisher lookup handler and call its handle method. In better Publisher will publish into bus.
 * example using Akka: system.eventStream.publish(event)
 */
object DefaultEventPublisher extends EventPublisher {

  val eventHandlers: Seq[EventHandler] = Seq()

  override def publish(event: DomainEvent): Unit = {
    eventHandlers.foreach(handler =>
      if(handler.canHandle(event))
        handler.handle(event)
    )
  }
}
