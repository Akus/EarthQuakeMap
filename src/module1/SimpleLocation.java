package module1;
// publikus = mindenki hozzáfér
public class SimpleLocation 
{
	//member variables: data the objects need to store, a method-ok előtt.
	public double latitude;
	public double longitude;
// ez egy constructor method, mert nincs típusa	
	public SimpleLocation(double lat, double lon)
	{
		// latitude - szélesség
		// longitude - hosszúság
		this.latitude = lat;
		this.longitude = lon;
	}
	
	// az other-t paraméterként kapja a ucsd.distance(lima) futásakor.
	// lima a paraméter.
	public double distance(SimpleLocation other) 
	{
		return getDist(this.latitude, this.longitude,
						other.latitude, other.longitude);
		
	}

	private double getDist(double lat1, double lon1, double lat2, double lon2)
    {
    	int R = 6373; // radius of the earth in kilometres
    	double lat1rad = Math.toRadians(lat1);
    	double lat2rad = Math.toRadians(lat2);
    	double deltaLat = Math.toRadians(lat2-lat1);
    	double deltaLon = Math.toRadians(lon2-lon1);

    	double a = Math.sin(deltaLat/2) * Math.sin(deltaLat/2) +
    	        Math.cos(lat1rad) * Math.cos(lat2rad) *
    	        Math.sin(deltaLon/2) * Math.sin(deltaLon/2);
    	double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

    	double d = R * c;
    	return d;
    }

}
