package com.panuleppaniemi.game

import scala.scalajs.js
import js.Dynamic.{ global => g }

import com.panuleppaniemi.team._
import com.panuleppaniemi.game._

object Game {
  def main(): Unit = {
    val teams = (
        new Team("FC Luscelona", createPlayers("FCL")),
        new Team("Real Mardi", createPlayers("RLM"))
    )

    var field = new Field(teams)

    println(teams)

    val paragraph = g.document.createElement("p")
    paragraph.innerHTML = "<strong>It works!</strong>"
    g.document.getElementById("playground").appendChild(paragraph)
  }

  private def createPlayers = (name: String) => (1 to 6).map((x: Int) => new Player(name + " " + x)).toList
}
