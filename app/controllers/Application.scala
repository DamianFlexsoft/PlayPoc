package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.{JsError, Json}
import play.api.mvc._
import resources._



class Application extends Controller {

    def index = Action {
        val res = Json.toJson(
            Seq((
                Map("invitee" -> ("John Smith"), "email" -> ("john@smith.mx"))
                ))
        )

        Ok(res).as("application/json");
    }

    def post = Action(BodyParsers.parse.json) { req =>

        val res = req.body.validate[Invitation]

        res.fold(
            errors => BadRequest("Errors: " + JsError.toJson(errors).toString()),
            correct => Ok("Created")
        )
    }

}
