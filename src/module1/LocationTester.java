package module1;

//import demos.SimpleLocation;
import module1.SimpleLocation;

public class LocationTester 
{

	public static void main (String [] args) 
	{
		// ezeknek a konstruktor függvénye a SimpleLocation osztályban van:
		//új objektumokat csinál a main method:
		SimpleLocation ucsd = 
				// ezek lesznek a this.-ben:
				new SimpleLocation(32.9, -117.2);
		SimpleLocation lima =
				new SimpleLocation(-12.0, -77.0);
		SimpleLocation fehervar =
				new SimpleLocation(47.17, 18.40);
		SimpleLocation ostoros =
				new SimpleLocation(47.52, 19.20);
		
		
		// itt használjuk a fenti objektumokat a distance method-dal:
		// a ucsd lesz a this-ben, a lima pedig az other paraméterben:
		System.out.println(ucsd.distance(lima) + " km");
		//és fordítva:
		System.out.println(lima.distance(ucsd) + " km");
		//és Fehérvárral:
		System.out.println(fehervar.distance(ucsd) + " km");
		System.out.println(fehervar.distance(ostoros) + " km");
		System.out.println(ostoros.distance(lima) + " km");
		
	}
}
