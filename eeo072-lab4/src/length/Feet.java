/**
 * 
 */
package length;

/**
 * @author samda This object conveys length in units of feet.
 */
public class Feet extends Length {

	public static final double feetToMeters = 0.3048;
	public static final double feetToYards = 0.333333;
	public static final double feetToInches = 12.0;

	public Feet(double length) {
		super(length);
	}

	public String getUnit() {
		if (this.getLength() == 1)
			return "foot";
		else
			return "feet";
	}

	public void add(Length other) {
		this.setLength(this.getLength() + other.toFeet());
	}

	public double toFeet() {
		return this.getLength();
	}

	public double toMeters() {
		return this.getLength() * feetToMeters;
	}

	public double toYards() {
		return this.getLength() * feetToYards;
	}

	public double toInches() {
		return this.getLength() * feetToInches;
	}

}
