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

  public double getX()            { return pos.getX(); }

  public double getY()            { return pos.getY(); }

  public double getDirection()    { return direction; }

	public int    getNrDoors()      { return nrDoors; }

	public double getEnginePower()  { return enginePower; }

	public double getCurrentSpeed() { return currentSpeed; }

	public Color  getColor()        { return color; }

  public String getModelName()    { return modelName; }

  protected void setColor(Color c) { color = c; }

  protected void setCurrentSpeed(double s) {
    if (s == currentSpeed && s != 0.0) {
      throw new IllegalStateException(
        "'setCurrentSpeed' ändrade inte farten."
      );
    }

    currentSpeed = s;
  }

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

	protected void incrementSpeed(double amount) {
    double speedBefore = getCurrentSpeed();
    double speedAfter = getCurrentSpeed() + speedFactor() * amount;

    if (speedAfter < speedBefore) {
      throw new IllegalStateException(
        "speedAfter: " + speedAfter + "speedBefore: " + speedBefore
      );
    }

		setCurrentSpeed(speedAfter);
	}

	protected void decrementSpeed(double amount) {
    double speedBefore = getCurrentSpeed();
    double speedAfter = getCurrentSpeed() - speedFactor() * amount;

    if (speedAfter > speedBefore) {
      throw new IllegalStateException(
        "speedAfter: " + speedAfter + "speedBefore: " + speedBefore
      );
    }

    setCurrentSpeed(speedAfter);
	}
  /**
   * Parametervärden håller sig inom intervallet [0, 1]
   * Farten kan inte sänkas.
   * Anropande metoder bör fånga upp 'IllegalStateException'
   */
	public void gas(double amount) {
    // intervall [0, 1]
    if (amount < 0 || amount > 1) {
      throw new IllegalArgumentException(
        "Parameter 'amount' är utanför intervallet [0 ... 1]: "
      );
    }

    incrementSpeed(amount);
	}

  /**
   * Parametervärden håller sig inom intervallet [0, 1]
   * Farten kan inte sänkas.
   * Anropande metoder bör fånga upp 'IllegalArgumentExceptions'
   */
	public void brake(double amount) {
    // intervall [0, 1]
    if (amount < 0 || amount > 1) {
      throw new IllegalArgumentException(
        "Parameter 'amount' är utanför intervallet [0 ... 1]: "
      );
    }

    decrementSpeed(amount);
	}
}
