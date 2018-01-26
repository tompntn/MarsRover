import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class RoverTest {

 // Create a new mars rover instance to test
 private MarsRover rover = new MarsRover(new Position(0, 0, Direction.N));

 @Test
 public void BasicMoveForwardTest() {

   rover.command('F');
   assertTrue(rover.getPosition().equals(new Position(0, 1, Direction.N)));

 }

 @Test
  public void BasicMoveBackwardTest() {

   rover.command('F');
   rover.command('B');
   assertTrue(rover.getPosition().equals(new Position(0, 0, Direction.N)));

 }

 /* This test is no longer needed, as wrapping is implemented. */
// @Test
//  public void InvalidPositionTest() {
//
//   // Going backwards off the map
//   try {
//     rover.command('B');
//     fail("Expected a RuntimeException to be thrown");
//   } catch (RuntimeException e) {
//     assertThat(e.getMessage(),
//         containsString("Invalid position"));
//   }
//
//   // Going forward off the map
//   try {
//     for (int i = 0; i < 101; ++i) {
//       rover.command('F');
//     }
//     fail("Expected a RuntimeException to be thrown");
//   } catch (RuntimeException e) {
//     assertThat(e.getMessage(),
//         containsString("Invalid position"));
//   }
//
// }

 @Test
  public void BasicTurnLeftTest() {

   // Rover starts facing N
   rover.command('L');
   assertTrue(rover.getPosition().equals(new Position(0, 0, Direction.W)));
   rover.command('L');
   assertTrue(rover.getPosition().equals(new Position(0, 0, Direction.S)));
   rover.command('L');
   assertTrue(rover.getPosition().equals(new Position(0, 0, Direction.E)));
   rover.command('L');
   assertTrue(rover.getPosition().equals(new Position(0, 0, Direction.N)));

 }

 @Test
  public void BasicTurnRightTest() {

   // Rover starts facing N
   rover.command('R');
   assertTrue(rover.getPosition().equals(new Position(0, 0, Direction.E)));
   rover.command('R');
   assertTrue(rover.getPosition().equals(new Position(0, 0, Direction.S)));
   rover.command('R');
   assertTrue(rover.getPosition().equals(new Position(0, 0, Direction.W)));
   rover.command('R');
   assertTrue(rover.getPosition().equals(new Position(0, 0, Direction.N)));


 }

 @Test
  public void CommandSequenceTest() {

   // Make the rover accept a string of commands, not just one
   rover.commandString("FFFRFF");
   assertTrue(rover.getPosition().equals(new Position(2, 3, Direction.E)));

 }

 @Test
  public void WrappingWorldTest() {

   for (int i = 0; i < 120; ++i) {

     rover.command('F');

   }
   assertTrue(rover.getPosition().equals(new Position(0, 20, Direction.N)));

   rover.command('R');
   for (int i = 0; i < 120; ++i) {

     rover.command('F');

   }
   assertTrue(rover.getPosition().equals(new Position(20, 20, Direction.E)));

 }

}