package module3;

import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoDataReader;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import parsing.ParseFeed;
import processing.core.PApplet;

public class Akos_Features_and_Markers extends PApplet {
	
	private static final long serialVersionUID = 1L;

	UnfoldingMap map1;
	private String earthquakesURL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

	public void setup() {
		
		size(900, 600, P2D);
		this.background(255, 255, 255);
		AbstractMapProvider provider = new Google.GoogleTerrainProvider();
		int zoomLevel = 10;
		map1 = new UnfoldingMap(this, 50, 50, 350, 500, provider);
		MapUtils.createDefaultEventDispatcher(this, map1);

	//dataFile = "data/dataFile.txt";
		//  List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
		 

	List<Feature> earthquakes = GeoDataReader.loadData(this, "data/dataFile.json");
	List<Marker> markers = MapUtils.createSimpleMarkers(earthquakes);
	map1.addMarkers(markers);

	}
	
	public void draw() {
		map1.draw();
	}
	
}
