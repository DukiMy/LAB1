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
      v.gas(0.3);
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
  void turningChangesDirection() {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());

    double dirBeforeTurn;
    double dirAfterTurn;
    boolean hasLeftTurn;
    boolean hasRightTurn;

    for (Vehicle v : vehicles) {

      dirBeforeTurn = v.getDirection();
      v.turnLeft();
      dirAfterTurn = v.getDirection();
      hasLeftTurn = (dirBeforeTurn != dirAfterTurn);

      dirBeforeTurn = v.getDirection();
      v.turnRight();
      dirAfterTurn = v.getDirection();
      hasRightTurn = (dirBeforeTurn != dirAfterTurn);

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
    double speedBeforeBraking;
    double speedAfterBreaking;

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());

    for (Vehicle v : vehicles) {
      v.startEngine();
      v.gas(0.5);
      speedBeforeBraking = v.getCurrentSpeed();

      v.brake(0.5);
      speedAfterBreaking = v.getCurrentSpeed();

      assertTrue(
        speedAfterBreaking < speedBeforeBraking,
        String.format(
          "Farten sänktes inte när %s bromsade in.",
          v.getModelName()
        )
      );
    }
  }

  @Test
  void gasRejectsOutOfRange() {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());

    for (Vehicle v : vehicles) {
      assertThrows(IllegalArgumentException.class, () -> v.gas(-0.0001));
      assertThrows(IllegalArgumentException.class, () -> v.gas( 1.0001));
    }
  }

  @Test
  void brakeRejectsOutOfRange() {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());

    for (Vehicle v : vehicles) {
      assertThrows(IllegalArgumentException.class, () -> v.brake(-0.0001));
      assertThrows(IllegalArgumentException.class, () -> v.brake( 1.0001));
    }
  }
}
