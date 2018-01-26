public class MarsRover {

  // Bounds on the mars rover's position
  private final int MAX_X = 100;
  private final int MIN_X = 0;
  private final int MAX_Y = 100;
  private final int MIN_Y = 0;

  private Position position;

  public MarsRover(final Position position) {
    this.position = position;
  }

  Position getPosition() {
    return position;
  }

  void commandString(String commands) {

    // Pass each character to the command handler
    commands.chars().forEach(
        c -> command((char) c)
    );

  }

  void command(final char cmd) {

    // Initial default values for the new position
    int newX = position.getX();
    int newY = position.getY();
    Direction newDirection = position.getDirection();

    // Determine the effect in each direction
    int upMovement = (newDirection == Direction.N) ? 1 : 0;
    int downMovement = (newDirection == Direction.S)? 1 : 0;
    int leftMovement = (newDirection == Direction.W)? 1 : 0;
    int rightMovement = (newDirection == Direction.E)? 1 : 0;

    // Calculate the new position based on the command
    switch (cmd) {

      case 'F':

        newY = wrapValue(newY + upMovement - downMovement, MAX_Y, MIN_Y);
        newX = wrapValue(newX + rightMovement - leftMovement, MAX_X, MIN_X);
        break;

      case 'B':
        newY = wrapValue(newY - upMovement + downMovement, MAX_Y, MIN_Y);
        newX = wrapValue(newX - rightMovement + leftMovement, MAX_X, MIN_X);
        break;

      case 'R':
        newDirection = Direction.fromBearing(newDirection.getBearing() + 90);
        break;

      case 'L':
        newDirection = Direction.fromBearing(newDirection.getBearing() - 90);
        break;

      default:
        throw new IllegalArgumentException("Unknown command " + cmd);
    }

    // Check that the new position is not out of bounds
    Position newPosition = new Position(newX, newY, newDirection);
    if (!validRoverPosition(newPosition)) {
      throw new RuntimeException("Invalid position: " + newPosition);
    }

    // Set the rover's new position
    this.position = newPosition;

  }

  private static int wrapValue(final int n, final int max, final int min) {

    int wrappedValue = n % max;
    if (wrappedValue < min) {
      wrappedValue = wrappedValue + max;
    }

    return wrappedValue;

  }

  // Determines if a position is a valid position in the rover's world
  private boolean validRoverPosition(final Position position) {

    return position.getX() <= MAX_X &&
        position.getX() >= MIN_X &&
        position.getY() <= MAX_Y &&
        position.getY() >= MIN_Y;

  }
}
