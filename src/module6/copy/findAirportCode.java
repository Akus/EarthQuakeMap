package module6.copy;

import demos.Airport;

public class findAirportCode {

	public static String findAirportCode (String toFind, Airport[] airports) {
		int index = 0;
		while (index<airports.length) {
			Airport curr = airports[index];
			if (toFind.equals(curr.getCity())) {
				return curr.getCode();
			}
			index++;
		}
		return null;
	}
}
