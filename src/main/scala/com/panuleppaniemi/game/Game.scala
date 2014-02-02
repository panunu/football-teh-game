package com.panuleppaniemi.game

import scala.scalajs.js
import js.Dynamic.{ global => g }

import com.panuleppaniemi.team._
import com.panuleppaniemi.game._

object Game {
  def main(): Unit = {
    val field = new Field(
      new Team("FC Luscelona", createPlayers("FCL")),
      new Team("Real Mardi", createPlayers("RLM"))
    )

    println(field)

    val content = g.document.createElement("p")
    content.innerHTML = println(field)
    g.document.getElementById("playground").appendChild(content)
  }

  private def createPlayers = (name: String) => (1 to 6).map((x: Int) => new Player(name + " " + x)).toList
}
