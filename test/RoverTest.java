import org.junit.Test;

public class RoverTest {

 // Create a new mars rover instance to test
 private MarsRover rover = new MarsRover();

 @Test
 public void BasicMoveForwardTest() {

   rover.command('F');
   assertThat(rover.getPosition(), is(new Position(0, 1 'N')));

 }

}