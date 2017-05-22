package module1;

public class Scope_LocationTester 
{

	public static void main (String [] args) 
	{
		// ezeknek a konstruktor függvénye a SimpleLocation osztályban van:
		//új objektumokat csinál a main method:
		double latitude = -15.5;
		
		SimpleLocation lima =
				new SimpleLocation(latitude, -77.0);
		
		latitude = -12.0;
		// itt használjuk a fenti objektumokat a distance method-dal:
		// a ucsd lesz a this-ben, a lima pedig az other paraméterben:
		System.out.println(lima.latitude);
	}
}