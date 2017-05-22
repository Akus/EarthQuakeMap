package module1;
// publikus = mindenki hozzáfér
public class Scope_SimpleLocation 
{
	//member variables: data the objects need to store, a method-ok előtt.
	public double latitude;
	public double longitude;
// ez egy constructor method, mert nincs típusa	
	public SimpleLocation(double latIn, double lonIn)
	{
		// latitude - szélesség
		// longitude - hosszúság
		this.latitude = latIn;
		this.longitude = lonIn;
	}
}