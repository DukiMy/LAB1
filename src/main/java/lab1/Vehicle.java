/**
 *  Utfärdat av Durim Miziraj
 *  Kontakt: gusmizdu@student.gu.se
 */

package lab1;
import java.awt.Color;
import static java.lang.Math.sin;
import static java.lang.Math.cos;

/**
 * Definierar bilar i högsta abstraktionnivå.
 * Enkapsulerar samtliga variabler.
 * Åtkomstmetoder som exponeras globalt påkallas inte av den interna klasshierarkin.
 * Variabler som behövs inom klasshierarkin sätts med åtkomstmodifieraren protected.
 */
abstract class Vehicle implements Movable {

	private int nrDoors;
	private double enginePower;
	private double currentSpeed;
	private Color color;
	private String modelName;
  private double xPos;
  private double yPos;
  private double direction;

	protected Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
		this.nrDoors = nrDoors;
		this.enginePower = enginePower;
		this.color = color;
		this.modelName = modelName;
    this.xPos = this.yPos = 0.0;
    this.direction = 0.0;
	  stopEngine();
  }

	public int getNrDoors() {
		return nrDoors;
	}

	public double getEnginePower() {
		return enginePower;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}

	public Color getColor() {
		return color;
	}

  public String getModelName() {
    return modelName;
  }

  public double getXPos() {
    return xPos;
  }

  public double getYPos() {
    return yPos;
  }

	public void setColor(Color color) {
		this.color = color;
	}

  protected void setCurrentSpeed(double currentSpeed) {
    this.currentSpeed = currentSpeed;
  }

  public void setXPos(double xPos) {
    this.xPos = xPos;
  }

  public void setYPos(double yPos) {
    this.yPos = yPos;
  }

	public void startEngine() {
    final double creepSpeed = 0.1;
    setCurrentSpeed(creepSpeed);
	}

  public void move() {
    xPos += cos(direction) * currentSpeed;
    yPos += sin(direction) * currentSpeed;
  }

  public void turnLeft() {
    direction += 0.2;
  }

  public void turnRight() {
    direction -= 0.2;
  }

	public void stopEngine() {
    final double noSpeed = 0.0;
    setCurrentSpeed(noSpeed);
	}

	protected abstract double speedFactor();

	protected abstract void incrementSpeed(double amount);

	protected abstract void decrementSpeed(double amount);

	// TODO fix this method according to lab pm
	public void gas(double amount) {
		incrementSpeed(amount);
	}

	// TODO fix this method according to lab pm
	public void brake(double amount) {
		decrementSpeed(amount);
	}
}
