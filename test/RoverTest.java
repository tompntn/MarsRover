import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

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

 @Test
  public void InvalidPositionTest() {

   // Going backwards off the map
   try {
     rover.command('B');
     fail("Expected a RuntimeException to be thrown");
   } catch (RuntimeException e) {
     assertThat(e.getMessage(),
         containsString("Invalid position"));
   }

   // Going forward off the map
   try {
     for (int i = 0; i < 101; ++i) {
       rover.command('F');
     }
     fail("Expected a RuntimeException to be thrown");
   } catch (RuntimeException e) {
     assertThat(e.getMessage(),
         containsString("Invalid position"));
   }

 }

 @Test
  public void BasicTurnLeftTest() {

   // Rover starts facing N
   rover.command('L');
   assertTrue(rover.getPosition().equals(new Position(0, 0, 'W')));
   rover.command('L');
   assertTrue(rover.getPosition().equals(new Position(0, 0, 'S')));
   rover.command('L');
   assertTrue(rover.getPosition().equals(new Position(0, 0, 'S')));
   rover.command('L');
   assertTrue(rover.getPosition().equals(new Position(0, 0, 'N')));

 }

}