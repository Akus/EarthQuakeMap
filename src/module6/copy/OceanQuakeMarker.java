package module6.copy;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	

	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		//IMPLEMENT: drawing centered square for Ocean earthquakes
		// DO NOT set the fill color.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered square.
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		pg.rect(x-radius, y-radius, 2*radius, 2*radius);
	}
	
/*
 * 8. (Optional) Add to the implementation of the drawEarthquake() method in the OceanQuakeMarker class so that if this marker has been clicked on, lines are drawn between this marker and all cities within its threat circle. If this marker has not been clicked, these lines should disappear.

Hint for step 8:

    You can find the x and y coordinates of a marker on a canvas by using the class ScreenPosition.
    To make lines disappear, you can re-draw them as transparent, e.g. using the noStroke() command.
 */
	

}
