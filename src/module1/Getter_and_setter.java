package module1;
// publikus = mindenki hozzáfér
public class Getter_and_setter 
{
	//privátok, csak ebből a class-ból elérhetők:
	private double latitude;
	private double longitude;
	
// ez egy publikus getter method, ami elérhetővé teszi a privát értékeket:
	public double getLatitude()
	{
		return this.latitude;
	}
		// latitude - szélesség
		// longitude - hosszúság
	
	/* setter method: hogy a user csak bizonyos értékekre állíthassa be
	* legal value-kra if-fel:
	*/
	
	public void setLatitude(double lat) 
	{
		this.latitude = lat;
	}
		
		
		
}

/* Why do we need private and public access modifiers?
 * 
 * private: nem elérhetők egymás számára
 * public: vulnerable és useless lehet a kód.
 */
