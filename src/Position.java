public class Position {

  private final int x;
  private final int y;
  private final char direction;

  public Position(int x, int y, char direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public char getDirection() {
    return direction;
  }

  @Override
  public int hashCode() {
    return this.getX() * this.getY() * this.getDirection();
  }

  @Override
  public boolean equals(Object obj) {

    if (!(obj instanceof Position)) {
      return false;
    }

    Position posObj = (Position) obj;
    return this.getX() == posObj.getX() &&
        this.getY() == posObj.getY() &&
        this.getDirection() == posObj.getDirection();

  }

  @Override
  public String toString() {
    return "Position{" +
        "x=" + x +
        ", y=" + y +
        ", direction=" + direction +
        '}';
  }
}
