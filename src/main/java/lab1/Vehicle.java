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

  public double getDirection() { return direction; }

	public int getNrDoors() { return nrDoors; }

	public double getEnginePower() { return enginePower; }

  /**
   * currentSpeed ligger alltid mellan [0, enginePower]
   */
	public double getCurrentSpeed() {
    currentSpeed = (currentSpeed < 0) ? 0 : currentSpeed;
    currentSpeed = (currentSpeed > enginePower) ? enginePower : currentSpeed;

    return currentSpeed;
  }

	public Color getColor() { return color; }

  public String getModelName() { return modelName; }

  protected void setColor(Color c) { color = c; }

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



  /**
   * Parametervärden håller sig inom intervallet [0, 1]
   * Farten kan inte sänkas
   */
	public void gas(double amount) {
    // intervall [0, 1]
    if (amount < 0 ^ amount > 1) {
      throw new IllegalArgumentException(
        "Parameter 'amount' är utanför intervallet [0 ... 1]: "
      );
    }

    double speedBefore = currentSpeed;
    incrementSpeed(amount);
    double speedAfter = currentSpeed;

    if (speedAfter <= speedBefore) {
      throw new IllegalStateException(
        "'incrementSpeed' ökade inte farten."
      );
    }
	}

  /**
   * Parametervärden håller sig inom intervallet [0, 1]
   * Farten kan inte sänkas.
   */
	public void brake(double amount) {
    // intervall [0, 1]
    if (amount < 0 || amount > 1) {
      throw new IllegalArgumentException(
        "Parameter 'amount' är utanför intervallet [0 ... 1]: "
      );
    }

    double speedBefore = currentSpeed;
    decrementSpeed(amount);
    double speedAfter = currentSpeed;

    if (speedAfter >= speedBefore) {
      throw new IllegalStateException(
        "'decrementSpeed' sänkte inte farten."
      );
    }
	}
}
