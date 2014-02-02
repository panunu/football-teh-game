package com.panuleppaniemi.game

import com.panuleppaniemi.team._

class Field(val teams: (Team, Team)) {
  val bounds = (9, 12)

  println(
    teams._1.players.take(3).zipWithIndex.map {
      case (p: Player, index: Int) => new Plottable(p, new Coordinates(3 + (index * 2), 3))
    }
  )

  var objects = List()
}
