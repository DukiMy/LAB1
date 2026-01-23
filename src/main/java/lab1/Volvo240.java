package lab1;
import java.awt.Color;

public final class Volvo240 extends Vehicle {

	private static final double TRIM_FACTOR = 1.25;

	public Volvo240() {
		super(
      /* Number of doors */ 4,
      /* Engine power    */ 100,
      /* Vehicle color   */ Color.black,
      /* vehicle model   */ "Volvo240"
    );
	}

	@Override
	protected double speedFactor() {
		return super.getEnginePower() * 0.01 * TRIM_FACTOR;
	}

  @Override
	protected void incrementSpeed(double amount) {
    double speedBefore = getCurrentSpeed();
    double speedAfter = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());

    if (speedAfter < speedBefore) {
      throw new IllegalStateException(
        "speedAfter: " + speedAfter + "speedBefore: " + speedBefore
      );
    }

    setCurrentSpeed(speedAfter);
	}

	@Override
	protected void decrementSpeed(double amount) {
    double speedBefore = getCurrentSpeed();
    double speedAfter = Math.max( getCurrentSpeed() - speedFactor() * amount, 0);

    if (speedAfter > speedBefore) {
      throw new IllegalStateException(
        "speedAfter: " + speedAfter + "speedBefore: " + speedBefore
      );
    }

    setCurrentSpeed(speedAfter);
	}
}
