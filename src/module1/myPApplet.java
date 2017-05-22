package module1;

import processing.core.*;



public class myPApplet extends PApplet{
	
	//private String URL = "/home/bubus/Coursera/images/";
	private PImage img;
	
	public void setup() {
		//Add setup code for MyPApplet
		size(400,400);				//set canvas size
		background(255);			//set canvas color
		stroke(0);				//set pen color
		img = loadImage("palmTrees.jpg", "jpg");
		img.resize(0, height);			//resize loaded image to full height of canvas
		image(img, 0, 0);			//display image 
	}
	
	public void draw() {
		//img.resize(0, height);
		//image(img, 0, 0);
		//fill(255,209,0);
		ellipse(width/4, height/5, width/5, height/5);
		int s = second();  // Values from 0 - 59
		  int m = minute();  // Values from 0 - 59
		  int h = hour();    // Values from 0 - 23
		  // h for testin:
		//int h = 16;
		
		  //line(s, 0, s, 33);
		  //line(m, 33, m, 66);
		 // line(h, 66, h, 100);
		 // System.out.println("it's " + h + " hour.");
		  /*switch (h) {
		  case 1: fill(255,255,255);
		  break;
		  case 2: fill(255,255,255);
		  break;
		  case 3: fill(255,255,255);
		  break;
		  }
			*/
		  
		  if (h < 6 || h > 19) {
			  fill(0,0,0);
		  }
		  else if (h >= 6 && h < 12) {
			  fill(255, 204, 153);
		  }
		  else if (h >= 12 && h <= 15) {
			  fill(255,255,102);
		  }
		  else {
			  fill(255, 153, 51);
		  }
		  
	}

}
