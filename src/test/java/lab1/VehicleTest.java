package lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class VehicleTest {

  @Test
  void vehicleMovesForward() {
    double startX;
    double startY;

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());

    for (Vehicle v : vehicles) {
      startX = v.getX();
      startY = v.getY();

      v.startEngine();
      v.move();

      assertTrue(
        v.getX() != startX || v.getY() != startY,
        String.format(
          "%s flyttade inte när 'move()' anropades.",
          v.getModelName()
        )
      );
    }
  }

  @Test
  void turningChangesMovementDirection() {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());

    double direction0;
    double direction1;
    boolean hasLeftTurn;
    boolean hasRightTurn;

    for (Vehicle v : vehicles) {

      direction0 = v.getDirection();
      v.turnLeft();
      direction1 = v.getDirection();
      hasLeftTurn = (direction0 != direction1);

      direction1 = v.getDirection();
      v.turnRight();
      direction1 = v.getDirection();
      hasRightTurn = (direction0 != direction1);

      assertTrue(
        hasLeftTurn || hasRightTurn,
        String.format(
          "%s ändrade inte riktning.",
          v.getModelName()
        )
      );
    }
  }

  @Test
  void brakeReducesSpeed() {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());

    for (Vehicle v : vehicles) {

      v.startEngine();
      double before = v.getCurrentSpeed();

      v.brake(0.5);

      assertTrue(
          v.getCurrentSpeed() < before,
        String.format(
          "Farten sänktes inte när %s bromsade in.",
          v.getModelName()
        )
      );
    }
  }
}
