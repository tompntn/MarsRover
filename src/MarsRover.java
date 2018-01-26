import javafx.geometry.Pos;
import org.omg.PortableServer.POA;

public class MarsRover {

  // Bounds on the mars rover's position
  private final int MAX_X = 100;
  private final int MIN_X = 0;
  private final int MAX_Y = 100;
  private final int MIN_Y = 0;

  private Position position;

  public MarsRover(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public void command(char cmd) {

    // Initial default values for the new position
    int newX = position.getX();
    int newY = position.getY();
    char newDirection = position.getDirection();

    // Calculate the new position based on the command
    switch (cmd) {

      case 'F':
        newY = newY + 1;
        break;

      case 'B':
        newY = newY - 1;
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

  // Determines if a position is a valid position in the rover's world
  private boolean validRoverPosition(Position position) {

    return position.getX() <= MAX_X &&
        position.getX() >= MIN_X &&
        position.getY() <= MAX_Y &&
        position.getY() >= MIN_Y;

  }
}
