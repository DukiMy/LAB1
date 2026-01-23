package lab1;
import static java.awt.Color.red;

public final class Saab95 extends Vehicle implements TurboCharged {

	private boolean turboOn;

	public Saab95() {
		super(
      /* Number of doors */ 2,
      /* Engine power    */ 125,
      /* Vehicle Color   */ red,
      /* Vehicle model   */ "Saab95"
    );

    turboOn = false;
	}

	public void setTurboOn() { turboOn = true; }

	public void setTurboOff() { turboOn = false; }

	@Override
	protected double speedFactor() {
		return super.getEnginePower() * 0.01 * (turboOn ? 1.3 : 1);
	}
}
