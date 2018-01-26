import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class RoverTest {

 // Create a new mars rover instance to test
 private MarsRover rover = new MarsRover(new Position(0, 0, 'N'));

 @Test
 public void BasicMoveForwardTest() {

   rover.command('F');
   assertTrue(rover.getPosition().equals(new Position(0, 1, 'N')));

 }

 @Test
  public void BasicMoveBackwardTest() {

   rover.command('F');
   rover.command('B');
   assertTrue(rover.getPosition().equals(new Position(0, 0, 'N')));

 }

}