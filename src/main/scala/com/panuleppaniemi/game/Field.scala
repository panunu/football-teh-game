package com.panuleppaniemi.game

import com.panuleppaniemi.team._

class Field(val teams: (Team, Team)) {
  val bounds = (9, 12)
  var players =
    plotPlayers(teams._1.players.take(3), 3, 3) :::
    plotPlayers(teams._1.players.drop(3), 3, 5) :::
    plotPlayers(teams._2.players.take(3), 3, 10) :::
    plotPlayers(teams._2.players.drop(3), 3, 8)

  def plotPlayers = (players: List[Player], x: Int, y: Int) => {
    players.zipWithIndex.map {
      case (p: Player, index: Int) => new Plottable(p, new Coordinates(x + (index * 2), y))
    }
  }

  override def toString = {
    var html: String = "<table>"

    for (y <- 1 to bounds._2) {
      html += "<tr>"

      for (x <- 1 to bounds._1) {
        html += "<td>"

        val inThisPosition = players.filter((p: Plottable) => p.coordinates.y == y && p.coordinates.x == x)
        if (inThisPosition.size == 1) {
          val player = inThisPosition.head.player
          html += ("<div class=\"player\" data-team=\"%s\">%s</div>").format(player.team.name, player.name)
        }

        html += "</td>"
      }

      html += "</tr>"
    }

    html += "</table>"
    html
  }
}
