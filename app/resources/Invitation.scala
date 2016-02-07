package resources

/**
  * Created by Damian on 07/02/2016.
  */

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Invitation(invitee: String, email: String);

object Invitation{
    implicit val locationReads: Reads[Invitation] = (
        (JsPath \ "invitee").read[String] and
            (JsPath \ "email").read[String]
        )(Invitation.apply _)
}