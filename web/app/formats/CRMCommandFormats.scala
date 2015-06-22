package formats

import contact.Contact
import contact.ContactCommandHandler.{ChangeContactOwner, CreateContact}
import play.api.libs.json.Json
/**
 * Created by sagar on 6/22/15.
 */
object CRMCommandFormats {

  implicit val changeOwnerFormat = Json.format[ChangeContactOwner]
  implicit val createContactFormat = Json.format[CreateContact]
  implicit val format = Json.format[Contact]

}
