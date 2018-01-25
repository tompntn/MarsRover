import com.sun.javaws.exceptions.InvalidArgumentException;

public class MarsRover {

  private Position position;

  public MarsRover(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public void command(char cmd) {

    // Perform an action based on the given command
    switch (cmd) {

      case 'F':
        position = new Position(position.getX(),
            position.getY() + 1, position.getDirection());
        break;

      default:
        throw new IllegalArgumentException("Unknown command " + cmd);
    }

  }
}
