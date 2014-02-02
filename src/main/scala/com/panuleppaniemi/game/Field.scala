package com.panuleppaniemi.game

import com.panuleppaniemi.team._

class Field(val teams: (Team, Team)) {
  val bounds = (15, 24) // Width, length

  var players =
    plotPlayers(teams._1.players.take(3), 5, 6) :::
    plotPlayers(teams._1.players.drop(3), 5, 10) :::
    plotPlayers(teams._2.players.take(3), 5, 24 - 9) :::
    plotPlayers(teams._2.players.drop(3), 5, 24 - 5)

  def plotPlayers = (players: List[Player], x: Int, y: Int) => {
    players.zipWithIndex.map {
      case (p: Player, index: Int) => new Plottable(p, new Coordinates(x + (index * 3), y))
    }
  }

  override def toString = {
    var html = ""

    for (x <- 1 to bounds._1) {
      html += "<tr>"

      for (y <- 1 to bounds._2) {
        html += "<td>%s</td>".format(getPlayer(x, y).getOrElse(""))
      }

      html += "</tr>"
    }

    html = "<table>%s</table>".format(html)
    html
  }

  private def getPlayer(x: Int, y: Int): Option[String] = {
    val inThisPosition = players.filter((p: Plottable) => p.coordinates.y == y && p.coordinates.x == x)

    if (inThisPosition.size == 0) {
      return None
    }

    val player = inThisPosition.head.player
    Some("<div class=\"player\" data-team=\"%s\" data-player=\"%s\">%s</div>".format(player.team.id, player.id, player.name))
  }
}
