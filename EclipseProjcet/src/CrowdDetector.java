import java.util.ArrayList;

import SimpleOpenNI.*;
import processing.core.*;

public class CrowdDetector {
	PApplet parent;
	SimpleOpenNI kinect;
	PVector centre = new PVector(0, 0);
	
	public CrowdDetector(PApplet context){
		parent = context;
		kinect = new SimpleOpenNI(parent);
		kinect.enableDepth();
	}
	
	public float getCrowdSize(){
		kinect.update();
		
		int crowdSize = 0;
		int[] depthPoints = kinect.depthMap();
		
		for(int y = 0; y < 480 ; y++){
			for(int x = 0; x < 640; x++){
				int i = x + y*640;
				int current = depthPoints[i];
				if(current < 2000 && current != 0){
					crowdSize++;
					
					int alpha = 100;
					//if near an edge
					if(x < alpha){alpha = x;}
					if(x > (640-alpha)){alpha = 640-x;}
					if(y < alpha){alpha = y;}
					if(y > (480-alpha)){alpha = 480-y;}
					parent.stroke(255, alpha);
					if(x%2 == 0){
						parent.point(PApplet.map(x, 0, 640, 0, parent.width),PApplet.map(y, 0, 480, 0, parent.height));
					}
				}
				
			}
		}
		return crowdSize;
	}
	
	public PVector getAverage(){
		kinect.update();

		double xTot=0, yTot=0;
		long amount = 0;
		int[] depthValues = kinect.depthMap();
		
		for(int y = 0; y < 480 ; y++){
			for(int x = 0; x < 640; x++){
				int i = x + (y * 640);
				int currentDepth = depthValues[i];
				if(currentDepth < 2000 && currentDepth != 0){
					xTot += x;
					yTot += y;
					amount++;
					
					int alpha = 100;
					//if near an edge
					if(x < alpha){alpha = x;}
					if(x > (640-alpha)){alpha = 640-x;}
					if(y < alpha){alpha = y;}
					if(y > (480-alpha)){alpha = 480-y;}
					parent.stroke(255, alpha);
					if(x%2 == 0){
						parent.point(parent.map(x, 0, 640, 0, parent.width),parent.map(y, 0, 480, 0, parent.height));
					}
				}
			}
		}
		return new PVector((float)xTot/amount, (float)yTot/amount);
	}
}