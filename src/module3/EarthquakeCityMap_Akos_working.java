package module3;

//Java utilities libraries
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

//Processing library
import processing.core.PApplet;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Parsing library
import parsing.ParseFeed;

/** EarthquakeCityMap
 * An application with an interactive map displaying earthquake data.
 * Author: UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 * Date: July 17, 2015
 * */
public class EarthquakeCityMap_Akos_working extends PApplet {

	// You can ignore this.  It's to keep eclipse from generating a warning.
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFLINE, change the value of this variable to true
	private static final boolean offline = false;
	
	// Less than this threshold is a light earthquake
	public static final float THRESHOLD_MODERATE = 5;
	// Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	// The map
	private UnfoldingMap map;
	
	//feed with magnitude 2.5+ Earthquakes
	private String earthquakesURL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";
	
	// Markers for each earthquake
		private List<Marker> quakeMarkers;
	
	public void setup() {
		size(950, 600, P2D);

		if (offline) {
		    map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
		    earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
		}
		else {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			//earthquakesURL = "2.5_week.atom";
		}
		
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);	
			
	    // The List you will populate with new SimplePointMarkers
	    List<Marker> markers = new ArrayList<Marker>();

	    Location berlinLocation = new Location(52.5, 13.4);
	    Location dublinLocation = new Location(53.35, -6.26);
	    
	         
	    // Create point markers for locations
	    SimplePointMarker berlinMarker = new SimplePointMarker(berlinLocation);
	    SimplePointMarker dublinMarker = new SimplePointMarker(dublinLocation);
	         
	    // Add markers to the map
	    map.addMarkers(berlinMarker, dublinMarker);
	    
	    //Use provided parser to collect properties for each earthquake
	    //PointFeatures have a getLocation method
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
	    
	    quakeMarkers = new ArrayList<Marker>();
	    /*
	    for(PointFeature earthquake : earthquakes) {
	    	quakeMarkers.add(new quakeMarker(earthquake));
	    }
	    */
	    map.addMarkers(quakeMarkers);
	    
	    // These print statements show you (1) all of the relevant properties 
	    // in the features, and (2) how to get one property and use it
	    if (earthquakes.size() > 0) {
	    	PointFeature f = earthquakes.get(0);
	    	System.out.println(f.getProperties());
	    	Object magObj = f.getProperty("magnitude");
	    	float mag = Float.parseFloat(magObj.toString());
	    	// PointFeatures also have a getLocation method
	    }
	    
	    for (int i=0;i<earthquakes.size();i++)
//vagy: for (PointFeature feature : earthquakes) {
	    {

	    PointFeature feature = earthquakes.get(i);

	    System.out.println(feature.getProperties());

	    Object magObj = feature.getProperty("magnitude");

	    float mag = Float.parseFloat(magObj.toString());

	    //createMarker(feature);

	    SimplePointMarker spm=new SimplePointMarker(feature.getLocation() );

	    if( mag>5.0)

	    {

	    int red=color(255,0,0);

	    spm.setColor(red);

	    spm.setRadius(14);

	    map.addMarker(spm);

	    }

	    else if (mag>4.0)

	    {

	    int yellow= color(255,255,0);

	    spm.setColor(yellow);

	    spm.setRadius(10);

	    map.addMarker(spm);

	    }

	    else

	    {

	    int blue=color(0,0,255);

	    spm.setColor(blue);

	    spm.setRadius(7);

	    map.addMarker(spm);

	    }

	    }
	    
	    // Here is an example of how to use Processing's color method to generate 
	    // an int that represents the color yellow.  
	    int yellow = color(255, 255, 0);
	    int red = color(255, 0, 0);
	    int blue = color(0, 0, 255);
	    //TODO: Add code here as appropriate
	    
	    
	}
		
	// A suggested helper method that takes in an earthquake feature and 
	// returns a SimplePointMarker for that earthquake
	// TODO: Implement this method and call it from setUp, if it helps
	private SimplePointMarker createMarker(PointFeature feature)
	{
		
		// finish implementing and use this method, if it helps.
		return new SimplePointMarker(feature.getLocation());
	}
	
	public void draw() {
	    background(10);
	    map.draw();
	    addKey();
	}

	// loop over and unhide all markers
		private void unhideMarkers() {
			for(Marker marker : quakeMarkers) {
				marker.setHidden(false);
			}
							
		}
	// helper method to draw key in GUI
	// TODO: Implement this method to draw the key
	private void addKey() 
	{	
		// Remember you can use Processing's graphics methods here
		
		/*
		int legendX = 150;
		int legendY = 250;
		int topMargin = 50;
		int leftMargin = 25;
		
		fill(255,255,255);
		rect(leftMargin, topMargin, legendX, legendY, 7);
		
		fill(0,0,0);
		text("Earthquake Key", legendX/5+leftMargin, (legendY/5*1+topMargin));
		
		fill(255,0,0);
		ellipse(legendX/6+leftMargin, (legendY/5*2+topMargin), 12, 12);
		fill(0,0,0);
		text("5.0+ Magnitude", legendX/4+leftMargin, (legendY/5*2+topMargin));
		
		fill(255,255,0);
		ellipse(legendX/6+leftMargin, (legendY/5*3+topMargin), 8, 8);
		fill(0,0,0);
		text("4.0+ Magnitude", legendX/4+leftMargin, (legendY/5*3+topMargin));
		
		fill(0,0,255);
		ellipse(legendX/6+leftMargin, (legendY/5*4+topMargin), 4, 4);
		fill(0,0,0);
		text("Below 4.0", legendX/4+leftMargin, (legendY/5*4+topMargin));
		
		*/
		
		fill(255,255,255);
		rect(25, 50, 150, 250, 7);
		
		fill(0,0,0);
		text("Earthquake Key", 25+20, 50+50);
		
		fill(255,0,0);
		ellipse(25+20, 50+50+50, 12, 12);
		fill(0,0,0);
		text("5.0+ Magnitude", 25+20+20, 50+50+50+3);
		
		fill(255,255,0);
		ellipse(25+20, 50+50+50+50,  8, 8);
		fill(0,0,0);
		text("4.0+ Magnitude", 25+20+20, 50+50+50+50+3);
		
		fill(0,0,255);
		ellipse(25+20, 50+50+50+50+50,  4, 4);
		fill(0,0,0);
		text("Below 4.0", 25+20+20, 50+50+50+50+50+3);
		
	}
}
