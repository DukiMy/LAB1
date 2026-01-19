package lab1;
import java.awt.Color;

public final class Volvo240 extends Vehicle {

	private static final double TRIM_FACTOR = 1.25;

	public Volvo240() {

		super(/* Number of doors */ 4, /* Engine power */ 100, /* Car color */ Color.black, /* Car model */ "Volvo240");
	}

	@Override
	protected double speedFactor() {
		return super.getEnginePower() * 0.01 * TRIM_FACTOR;
	}

	@Override
	protected void incrementSpeed(double amount) {
    setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, super.getEnginePower()));
	}

	@Override
	protected void decrementSpeed(double amount) {
    setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
	}
}
