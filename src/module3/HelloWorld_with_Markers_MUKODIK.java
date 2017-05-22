package module3;

import processing.core.PApplet;
import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import module5.CityMarker;
//Microsoft import:
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.providers.Microsoft.MicrosoftProvider;
import de.fhpotsdam.unfolding.providers.Microsoft.AerialProvider;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PConstants;
import processing.core.PGraphics;
/** HelloWorld
  * An application with two maps side-by-side zoomed in on different locations.
  * Author: UC San Diego Coursera Intermediate Programming team
  * @author Akos Jozsef Bodor
  * Date: May, 20, 2016V
*/
public class HelloWorld_with_Markers_MUKODIK extends PApplet
{
	/** Your goal: add code to display second map, zoom in, and customize the background.
	 * Feel free to copy and use this code, adding to it, modifying it, etc.  
	 * Don't forget the import lines above. */

	// You can ignore this.  It's to keep eclipse from reporting a warning
	private static final long serialVersionUID = 1L;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	// IF YOU ARE WORKING OFFLINE: Change the value of this variable to true
	private static final boolean offline = false;
	
	private String cityFile = "city-data.json";

	
	/** The map we use to display our home town: La Jolla, CA */
	UnfoldingMap map1;
	
	/** The map you will use to display your home town */ 
	UnfoldingMap map2;

	
	
	private List<Marker> cityMarkers;

	//SimplePointMarker fehervarMarker;
	// a többi a draw()-ban van
	
	public void setup() {
		size(900, 600, P2D);  // Set up the Applet window to be 800x600
		                      // The OPENGL argument indicates to use the 
		                      // Processing library's 2D drawing
		                      // You'll learn more about processing in Module 3

		// This sets the background color for the Applet.  
		// Play around with these numbers and see what happens!
		this.background(255, 255, 255);
		//this.background(200, 200, 200);
		// Select a map provider
		//AbstractMapProvider provider = new Microsoft.AerialProvider();
		//AbstractMapProvider provider = new Microsoft.HybridProvider();
		AbstractMapProvider provider = new Google.GoogleTerrainProvider();
		/*The Microsoft providers (HybridProvider, AerialProvider, and RoadProvider) also are known to work.
		 * http://unfoldingmaps.org/javadoc/de/fhpotsdam/unfolding/providers/package-summary.html 
		*/
		// Set a zoom level
		int zoomLevel = 10;
		
		if (offline) {
			// If you are working offline, you need to use this provider 
			// to work with the maps that are local on your computer.  
			provider = new MBTilesMapProvider(mbTilesString);
			// 3 is the maximum zoom level for working offline
			zoomLevel = 3;
		}
		
		// Create a new UnfoldingMap to be displayed in this window.  
		// The 2nd-5th arguments give the map's x, y, width and height
		// When you create your map we want you to play around with these 
		// arguments to get your second map in the right place.
		// The 6th argument specifies the map provider.  
		// There are several providers built-in.
		// Note if you are working offline you must use the MBTilesMapProvider
		map1 = new UnfoldingMap(this, 50, 50, 350, 500, provider);
		map2 = new UnfoldingMap(this, 500, 50, 350, 500, provider);
		// The next line zooms in and centers the map at 
	    // 32.9 (latitude) and -117.2 (longitude)
	    map1.zoomAndPanTo(zoomLevel, new Location(32.9f, -117.2f));
	    map2.zoomAndPanTo(zoomLevel, new Location(47.17f, 18.40f));
	    //47°11'18.5"N 18°24'05.8"E
	    
		// This line makes the map interactive
		MapUtils.createDefaultEventDispatcher(this, map1);
		MapUtils.createDefaultEventDispatcher(this, map2);
		// TODO: Add code here that creates map2 
		// Then you'll modify draw() below

		List<Feature> cities = GeoJSONReader.loadData(this, cityFile);
		cityMarkers = new ArrayList<Marker>();
		for(Feature city : cities) {
		  cityMarkers.add(new CityMarker(city));
		}
	    map2.addMarkers(cityMarkers);
		
	    Location berlinLocation = new Location(52.5, 13.4);
	    Location dublinLocation = new Location(53.35, -6.26);
	    Location fehervarLocation = new Location(47.17f, 18.40f);
	    Location sandiegoLocation = new Location(32.9f, -117.2f);
	         
	    // Create point markers for locations
	    SimplePointMarker berlinMarker = new SimplePointMarker(berlinLocation);
	    SimplePointMarker dublinMarker = new SimplePointMarker(dublinLocation);
	    // fehervarMarker defined outside setup();
	    SimplePointMarker fehervarMarker = new SimplePointMarker(fehervarLocation);
	    SimplePointMarker sandiegoMarker = new SimplePointMarker(sandiegoLocation);
	         
	    berlinMarker.setColor(color(255, 0, 0, 100));
	    berlinMarker.setStrokeColor(color(255, 0, 0));
	    berlinMarker.setStrokeWeight(4);
	    
	    
	    fehervarMarker.setColor(color(50,255, 20, 100));
	    fehervarMarker.setStrokeColor(color(255, 0, 0));
	    fehervarMarker.setStrokeWeight(4);
	    
	    // Add markers to the map
	    // a map. -hez nem szabad hozzáadni a marker-t ha a draw-ban definiáljuk a formáját.
	    map2.addMarkers(berlinMarker, dublinMarker, fehervarMarker, sandiegoMarker);
	    map1.addMarkers(berlinMarker, dublinMarker, sandiegoMarker);
	    
	}

	
	
	
	/** Draw the Applet window.  */
	public void draw() {
		// So far we only draw map1...
		// TODO: Add code so that both maps are displayed
		
		
		map1.draw();
		map2.draw();
		
		
	}

	private void unhideMarkers() {
					
		for(Marker marker : cityMarkers) {
			marker.setHidden(false);
		}
	}
}	
	
/*

	public static int TRI_SIZE = 5;  // The size of the triangle marker
	
	public CityMarker(Location location) {
		super(location);
	}
	
	
	public CityMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
		// Cities have properties: "name" (city name), "country" (country name)
		// and "population" (population, in millions)
	}
	
	
	
	public void drawMarker(PGraphics pg, float x, float y) {
		//System.out.println("Drawing a city");
		// Save previous drawing style
		pg.pushStyle();
		
		// IMPLEMENT: drawing triangle for each city
		pg.fill(150, 30, 30);
		pg.triangle(x, y-TRI_SIZE, x-TRI_SIZE, y+TRI_SIZE, x+TRI_SIZE, y+TRI_SIZE);
		
		// Restore previous drawing style
		pg.popStyle();
	}
	
	
	public void showTitle(PGraphics pg, float x, float y)
	{
		String name = getCity() + " " + getCountry() + " ";
		String pop = "Pop: " + getPopulation() + " Million";
		
		pg.pushStyle();
		
		pg.fill(255, 255, 255);
		pg.textSize(12);
		pg.rectMode(PConstants.CORNER);
		pg.rect(x, y-TRI_SIZE-39, Math.max(pg.textWidth(name), pg.textWidth(pop)) + 6, 39);
		pg.fill(0, 0, 0);
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.text(name, x+3, y-TRI_SIZE-33);
		pg.text(pop, x+3, y - TRI_SIZE -18);
		
		pg.popStyle();
	}
	
	private String getCity()
	{
		return getStringProperty("name");
	}
	
	private String getCountry()
	{
		return getStringProperty("country");
	}
	
	private float getPopulation()
	{
		return Float.parseFloat(getStringProperty("population"));
	}
}


*/