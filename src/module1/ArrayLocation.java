package module1;

/*
 * when we have objects, and basically object types which include arrays,
 *  something that's not primitive, 
 *  then we really have to worry about 
 *  what is allowed to refer to that object. 
 *  And how can its values change, in perhaps unintended ways.
 */

public class ArrayLocation {
	private double coords[];
	
	public ArrayLocation(double[] coords) {
		this.coords = coords;
	}

	public static void main (String[] args) {
		double[] coords = {5.0, 0.0};
		ArrayLocation accra = new ArrayLocation(coords);
		coords[0] = 32.9;
		coords[1] = -117.2;
		System.out.println(accra.coords[0]);
	}
	
}
