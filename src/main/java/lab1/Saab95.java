package lab1;
import static java.awt.Color.red;

public final class Saab95 extends Vehicle implements TurboCharged {

	private boolean turboOn;

	public Saab95() {
		turboOn = false;

		super(/* Number of doors */ 2, /* Engine power */ 125, /* Car color */ red, /* Car model */ "Saab95");
	}

	public void setTurboOn() {
		turboOn = true;
	}

	public void setTurboOff() {
		turboOn = false;
	}

	@Override
	protected double speedFactor() {
		return super.getEnginePower() * 0.01 * (turboOn ? 1.3 : 1);
	}

	@Override
	protected void incrementSpeed(double amount) {
		setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
	}

	@Override
	protected void decrementSpeed(double amount) {
		setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
	}
}
