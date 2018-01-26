public enum Direction {

  N(0),
  S(180),
  E(90),
  W(270);

  // Stores the bearing from north
  private final int bearing;

  private Direction(int bearing) {

    this.bearing = bearing;

  }

  public int getBearing() {
    return bearing;
  }

  /* Returns a new Direction enum representing the bearing */
  public static Direction fromBearing(int bearing) {

    /* Normalise the bearing, to be between 0 and 360 */
    final int MAX_DEGREE = 360;
    int modBearing = bearing % MAX_DEGREE;
    if (modBearing < 0) {
      modBearing = modBearing + MAX_DEGREE;
    }

    for (Direction direction : Direction.values()) {
      if (direction.getBearing() == modBearing) {
        return direction;
      }
    }

    throw new RuntimeException("Unknown bearing: " + bearing);

  }

}
