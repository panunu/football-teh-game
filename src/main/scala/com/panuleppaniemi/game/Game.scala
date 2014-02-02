package com.panuleppaniemi.game

import scala.scalajs.js
import js.Dynamic.{ global => g }
import org.scalajs.jquery._

import com.panuleppaniemi.team._
import com.panuleppaniemi.game._

object Game {
  def main(): Unit = {


    val field = new Field(
      new Team("FC Luscelona", createPlayers("L")),
      new Team("Real Mardi", createPlayers("R"))
    )

    jQuery("#playground").html(field.toString)


    /*val name = jQuery("#helloworld-jquery-input-name").`val`()
  val paragraph = jQuery("<p>").html("Hello " + name + "!")
  jQuery("#helloworld-jquery-input").append(paragraph)*/
  }

  private def createPlayers = (name: String) => (1 to 6).map((x: Int) => new Player(name + " " + x)).toList
}
