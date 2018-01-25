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

   // Moved forward by 1, now if we move backwards we should be back at the origin
   rover.command('B');
   assertTrue(rover.getPosition().equals(new Position(0, 0, 'N')));

 }

}