package module1;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.providers.*;
import de.fhpotsdam.unfolding.providers.Google.*;

import java.util.List;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;

import java.util.HashMap;


import de.fhpotsdam.unfolding.marker.Marker;

public class LifeExpectancy extends PApplet{

	UnfoldingMap map;
	HashMap<String, Float> lifeExpMap;	
	List<Feature> countries;
	List<Marker> countryMarkers;
	
	
	public void setup (){
		size(800,600,P2D);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		// Load lifeExpectancy data
		lifeExpMap = loadLifeExpectancyFromCSV("LifeExpectancyWorldBankModule3.csv");
		println("Loaded " + lifeExpMap.size() + " data entries");
		
		// Load country polygons and adds them as markers
		countries = GeoJSONReader.loadData(this, "data/countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers);
		
		// Country markers are shaded according to life expectancy (only once)
		shadeCountries();
	}
	
	
		
		private void shadeCountries() {
			for (Marker marker : countryMarkers) {
				String countryId = marker.getId();
				
				if (lifeExpMap.containsKey(countryId)) {
					float lifeExp = lifeExpMap.get(countryId);
					int colorLevel = (int) map(lifeExp, 40, 90, 10, 255);
					marker.setColor(color(255-colorLevel, 100, colorLevel));
				}
				else {
					marker.setColor(color(150,150,150));
					
				}
			}
		}
		
		lifeExpByCountry = loadLifeExpectancyFromCSV("data/LifeExpectancyWorldBank.csv");
	}
	private Map<String, Float>;
	loadLifeExpectancyFromCSV(String filename) {
		
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		
		String[] rows = loadStrings(filename);
		
		for (String row : row) {
			String[] columns = row.split(",");
			if () {
				float value = Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4], value);
			}
		}
		
		return lifeExpMap;
	}
	
	public void draw () {
		map.draw();
	}
	
}
