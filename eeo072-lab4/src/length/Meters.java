/**
 * 
 */
package length;

/**
 * @author samda This object conveys length in units of meters.
 */
public class Meters extends Length {

	public static final double metersToFeet = 3.28084;
	public static final double metersToYards = 1.09361;
	public static final double metersToInches = 39.3701;

	public Meters(double length) {
		super(length);
	}

	public String getUnit() {
		if (this.getLength() == 1)
			return "meter";
		else
			return "meters";
	}

	public void add(Length other) {
		this.setLength(this.getLength() + other.toMeters());
	}

	public double toMeters() {
		return this.getLength();
	}

	public double toYards() {
		return this.getLength() * metersToYards;
	}

	public double toFeet() {
		return this.getLength() * metersToFeet;
	}

	public double toInches() {
		return this.getLength() * metersToInches;
	}
}
