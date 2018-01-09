/**
 * 
 */
package length;

/**
 * @author samda This object conveys length in units of inches.
 */
public class Inches extends Length {

	public static final double inchesToMeters = 0.0254;
	public static final double inchesToFeet = 0.0833333;
	public static final double inchesToYards = 0.0277778;

	public Inches(double length) {
		super(length);
	}

	public String getUnit() {
		if (this.getLength() == 1)
			return "inch";
		else
			return "inches";
	}

	public void add(Length other) {
		this.setLength(this.getLength() + other.toInches());
	}

	public double toInches() {
		return this.getLength();
	}

	public double toMeters() {
		return this.getLength() * inchesToMeters;
	}

	public double toFeet() {
		return this.getLength() * inchesToFeet;
	}

	public double toYards() {
		return this.getLength() * inchesToYards;
	}

}
