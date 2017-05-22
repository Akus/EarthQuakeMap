package module1;

import processing.core.*;



public class MyPApplet2 extends PApplet{
	
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
		
		int[] color = setColor(second());
		fill(color[0],color[1],color[2]);
		ellipse(width/4, height/5, width/5, height/5);

		}
		public int[] setColor(float seconds) {
			int[] rgb = new int [3];
			
			float diffFrom30 = Math.abs(30-seconds);
			System.out.print("diffFrom30 = " + diffFrom30 + ", ");
		
			float ratio = diffFrom30/30;
			System.out.print("ratio = " + ratio + ", ");
			
			rgb[0] = (int)(255*ratio);
			rgb[1] = (int)(255*ratio);
			rgb[2] = 0;
			
			System.out.println("Red: " + rgb[0] + ", Green: " + rgb[1] + ", Blue: " + rgb[2]);
			
			return rgb;
		}
		

}