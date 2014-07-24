import java.util.ArrayList;
import processing.core.*;
import SimpleOpenNI.*;

public class ONITest extends PApplet {
	SimpleOpenNI kinect;
	
	public void setup(){
		size(640, 480);
		kinect = new SimpleOpenNI(this);
		kinect.enableDepth();
	}
	
	public void draw(){
		kinect.update();
		background(0);
		
		ArrayList<PVector> goodPoints = new ArrayList<PVector>(1);
		int[] depthValues = kinect.depthMap();
		//for calculating the average
		double avgX=0, avgY=0;
		int hits = 0;
		//for calculating the closest
		int closest = 2000;
		PVector closestPoint = new PVector();
		
		for(int y = 0; y < 480 ; y++){
			for(int x = 0; x < 640; x++){
				int i = x + (y * 640);
				int currentDepth = depthValues[i];
				if(currentDepth < 2000 && currentDepth != 0){
					//don't draw all the points
					if(i%4 == 0){
						float color = map(currentDepth, 0, 2000, 255, 0);
						stroke(color);
						point(x, y);
					}
					
					//add the current positions to the total
					avgX += x;
					avgY += y;
					hits++;
					
					//check for new closest
					if(currentDepth < closest){
						closest = currentDepth;
						closestPoint = new PVector(x,y);
					}
				}
			}
		}
		fill(255);
		ellipse((float)avgX/hits, (float)avgY/hits, 50, 50);
		fill(200);
		ellipse(closestPoint.x, closestPoint.y, 50, 50);
		text(frameRate, 10, 20);
		text(goodPoints.size(), 10, 60);
	}
}