package controllers

import contact.{ContactCommandHandler, ContactRepository}
import play.api._
import play.api.mvc._
import contact.ContactCommandHandler._
import formats.CRMCommandFormats._
import com.softwaremill.macwire.MacwireMacros._

object ContactResource extends Controller {

  val handler = wire[ContactCommandHandler]

  def createContact = Action(parse.json) {
    request =>
      val createContactCmd = request.body.validate[CreateContact].getOrElse(throw new Exception)
      handler.handleCommand(createContactCmd)
    Ok("Contact Created")
  }

  def changeContactOwner = Action(parse.json) {
    request =>
      val changeContactOwnerCmd = request.body.validate[ChangeContactOwner].getOrElse(throw new Exception)
      handler.handleCommand(changeContactOwnerCmd)
    Ok("COntact Owner Changed..")
  }

  def getAllContacts = Action{
    ContactRepository.getAllContacts
    Ok("Obtain all contacts")
  }

  def getContactByName(name:String) = Action {
    ContactRepository.getContactByName(name)
    Ok("Contacts obtained by contact name")
  }

  def getContactByOwner(owner:String) = Action {
    ContactRepository.getContactByOwner(owner)
    Ok("Contacts obtained by owner")
  }

}