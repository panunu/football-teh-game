package com.panuleppaniemi.team

class Player(val id: Int, val name: String) {
  var team: Team = null

  def assignTo = (team: Team) => this.team = team

  /**
   * Could have following attributes/skills:
   *
   * - shooting
   * - passing
   * - dribbling
   * - tackling
   * - speed?
   */

}
