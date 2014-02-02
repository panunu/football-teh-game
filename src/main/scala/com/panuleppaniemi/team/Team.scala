package com.panuleppaniemi.team

class Team(val name: String, val players: List[Player]) {

  /**
   * Any other attributes?
   */

  players.foreach {
    _.assignTo(this)
  }

}
