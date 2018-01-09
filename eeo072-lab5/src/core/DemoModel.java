package core;
import java.awt.*; 
import java.util.ArrayList;

/**
 * The DemoModel class holds the information that is used by the GUI.
 * Ask yourself the question, what data would be needed to recreate
 * the state of the GUI?  This data is what should be stored in the
 * model.
 * <p>
 * The instance variables are from Fig. 14.34.
 * @author Sam Dash
 */
public class DemoModel {

	/** 
	 * An ArrayList of java.awt.Point references 
	 */
	private ArrayList<Point> points;
	
	/** 
	 * An arrayList of java.awt.Color references 
	 */
	private ArrayList<Color> colors;
	
	/** 
	 * The color selected by the user 
	 */
	private Color selectedColor;
	
	public DemoModel() {
		points = new ArrayList<Point>();
		colors = new ArrayList<Color>();
		selectedColor = Color.CYAN;
	}
	
	/**
	 * Add a Point to the points array.
	 * @param point the Point to be added to points.
	 */
	public void addPoint(Point point) {
		points.add(point);
		colors.add(getSelectedColor());
	}
	
	/**
	 * Returns point at index i.
	 * Returns null if no such point exists.
	 * @param i
	 */
	public Point getPoint(int i) {
		if (i >= 0 && i < points.size()) {
			return points.get(i);
		}
		return null;
	}
	
	/** 
	 * Returns color of the point at index n.
	 * Returns null if no such points exists.
	 * @param n 
	 */
	public Color getColor(int n){
		if (n >= 0 && n < colors.size()){
			return colors.get(n);
		}
		return null;
	}
	
	/**
	 * Store the color that the user selected.
	 * @param color the color selected by the user
	 */
	public void setSelectedColor(Color color) {
		selectedColor = color;
	}
	
	/**
	 * @return the color selected by the user
	 */
	public Color getSelectedColor() {
		return selectedColor;
	}
}
