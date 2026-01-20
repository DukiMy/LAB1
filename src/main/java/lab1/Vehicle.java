/**
 *  Utfärdat av Durim Miziraj
 *  Kontakt: gusmizdu@student.gu.se
 */

package lab1;
import java.awt.Color;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import java.awt.geom.Point2D;

abstract class Vehicle implements Movable {

  private final Point2D pos = new Point2D.Double(0.0, 0.0);
  private double direction;
	private int nrDoors;
	private double enginePower;
	private double currentSpeed;
	private Color color;
	private String modelName;

	protected Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
    this.direction = 0.0;
		this.nrDoors = nrDoors;
		this.enginePower = enginePower;
		this.color = color;
		this.modelName = modelName;
	  stopEngine();
  }

  public double getX() { return pos.getX(); }

  public double getY() { return pos.getY(); }

	public int getNrDoors() { return nrDoors; }

	public double getEnginePower() { return enginePower; }

	public double getCurrentSpeed() { return currentSpeed;}

	public Color getColor() { return color; }

  public String getModelName() { return modelName; }

	public void setColor(Color c) { color = c; }

  protected void setCurrentSpeed(double s) { currentSpeed = s; }

	public void startEngine() { setCurrentSpeed(0.1); }

  public void move() {
    pos.setLocation(
      pos.getX() + cos(direction) * getCurrentSpeed(),
      pos.getY() + sin(direction) * getCurrentSpeed()
    );
  }

  public void turnLeft() { direction += 0.1; }

  public void turnRight() { direction -= 0.1; }

	public void stopEngine() { setCurrentSpeed(0.0); }

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
