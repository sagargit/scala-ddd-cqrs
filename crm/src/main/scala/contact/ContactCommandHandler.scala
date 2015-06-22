package contact

import command.{CommandHandler, Command}
import contact.ContactCommandHandler._
import event.DomainEvent

/**
 * Created by roshansharma on 6/19/15.
 */
class ContactCommandHandler extends CommandHandler[ContactCommand]{

  def handleCommand(command: ContactCommand): Unit = command match {
    case e: ChangeContactOwner => {
      val contact = ContactRepository.byId(e.id)
      contact.changeOwner(e.owner)
      ContactRepository.save(contact)

      //Other modules might be listening to this change
      eventPublisher.publish(ContactOwnerChanged(e.id, e.owner))
    }

    case e: CreateContact =>
      val contact = Contact("",e.name,e.owner)
      ContactRepository.save(contact)
      eventPublisher.publish(ContactCreated(e.name, e.owner))
  }
}


object ContactCommandHandler {
  //Commands
  sealed trait ContactCommand extends Command
  case class CreateContact(name: String, owner: String) extends ContactCommand
  case class ChangeContactOwner(id: String, owner: String) extends ContactCommand

  //Events
  case class ContactOwnerChanged(id: String, owner: String) extends DomainEvent
  case class ContactCreated(name: String, owner: String) extends DomainEvent
}