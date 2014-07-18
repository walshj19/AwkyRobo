import processing.core.*;
import SimpleOpenNI.*;

public class ONITest extends PApplet {
	SimpleOpenNI kinect;
	int closest;
	
	public void setup(){
	size(640, 480);
		kinect = new SimpleOpenNI(this);
		kinect.enableDepth();
		//kinect.enableRGB();
	}
	
	public void draw(){
		kinect.update();
		
		int closestX = 0;
		int closestY = 0;
		closest = 8000;
		
		int[] depthValues = kinect.depthMap();
		
		for(int y = 0; y < 480 ; y++){
			for(int x = 0; x < 640; x++){
				int i = x + (y * 640);
				int currentDepth = depthValues[i];
				
				if(currentDepth > 0 && currentDepth < closest){
					// save its value
					closest = currentDepth;
					// and save its position (both X and Y coordinates)
					closestX = x;
					closestY = y;
				}
			}
		}
		
		PImage depthImage = kinect.depthImage();
		//PImage rgbImage = kinect.rgbImage();
		
		//image(depthImage, 0, 0);
		//image(rgbImage, 640, 0);
		
		fill(255,0,0);
		ellipse(closestX, closestY, 25, 25);
	}
	
	public void mousePressed(){
		int[] depthValues = kinect.depthMap();
		int clickPosition = mouseX + (mouseY * 640);
		int clickedDepth = depthValues[clickPosition];
		double inches = clickedDepth / 25.4;
		println("inches: " + inches);
	}
}
