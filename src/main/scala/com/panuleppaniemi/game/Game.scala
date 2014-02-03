package com.panuleppaniemi.game

import scala.scalajs.js
import js.Dynamic.{ global => g }
import org.scalajs.jquery._

import com.panuleppaniemi.team._
import com.panuleppaniemi.game._

object Game {
  def main(): Unit = {
    val field = new Field(
      new Team(1, "FC Luscelona", createPlayers("L")),
      new Team(2, "Real Mardi", createPlayers("R"))
    )

    jQuery("#playground").html(field.toString)

    jQuery(".player").click { (e: JQueryEventObject) =>
      jQuery(e.target).addClass("active")
    }

    jQuery("td").mouseup { (e: JQueryEventObject) =>
      jQuery(".player.active").appendTo(e.target).removeClass("active") //.removeClass("active")
    }
  }

  private def createPlayers = (name: String) => (1 to 6).map((x: Int) => new Player(x, name + " " + x)).toList
}
