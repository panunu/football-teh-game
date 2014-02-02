package com.panuleppaniemi.team

class Player(val name: String) {
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
