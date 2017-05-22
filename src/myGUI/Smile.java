package myGUI;

import processing.core.*;

public class Smile extends PApplet{
	private PImage myimg;
	public void setup() {
		
		size(600,600);
		background(255);
		stroke(0);
		//img = loadImage("/home/bubus/Coursera/UCSDUnfoldingMaps/data/palmTrees.jpg", "jpg");
		myimg = loadImage("palmTrees.jpg", "jpg");
		//SZÁMÍT A SORREND A RESIZE-NÁL!!!
		myimg.resize(0,height);
		image(myimg, 0,0);
	}
	
	public void draw() {
		//head
		fill(200,200,100);
		ellipse(width/2,height/2,200,200);
		//A FILL mindig az objektum előtt kell legyen!
		//left eye
		fill(0,0,0);
		ellipse(width/2-50,height/2-50,20,20);
		//right eye
		fill(0,0,0);
		ellipse(width/2+50,height/2-50,20,20);
		//mouth
		//arc(width/2, height/2+50, 80, 80, 0, PI+QUARTER_PI, CHORD);
		arc(width/2, height/2+30, 80, 80, 0, PI-QUARTER_PI, CHORD);

		fill(0,0,0);
	}
}
