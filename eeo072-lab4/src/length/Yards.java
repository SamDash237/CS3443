/**
 * 
 */
package length;

/**
 * @author samda This object conveys length in units of yards.
 */
public class Yards extends Length {

	public static final double yardsToMeters = 0.9144;
	public static final double yardsToFeet = 3.0;
	public static final double yardsToInches = 36.0;

	public Yards(double length) {
		super(length);
	}

	public String getUnit() {
		if (this.getLength() == 1)
			return "yard";
		else
			return "yards";
	}

	public void add(Length other) {
		this.setLength(this.getLength() + other.toYards());
	}

	public double toYards() {
		return this.getLength();
	}

	public double toMeters() {
		return this.getLength() * yardsToMeters;
	}

	public double toFeet() {
		return this.getLength() * yardsToFeet;
	}

	public double toInches() {
		return this.getLength() * yardsToInches;
	}
}
