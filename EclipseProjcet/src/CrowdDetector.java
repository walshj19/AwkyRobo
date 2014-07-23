import java.util.ArrayList;

import SimpleOpenNI.*;
import processing.core.*;

public class CrowdDetector {
	SimpleOpenNI kinect;
	PVector centre = new PVector(0, 0);
	
	public CrowdDetector(PApplet context){
		kinect = new SimpleOpenNI(context);
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
				}
			}
		}
		return new PVector((float)xTot/amount, (float)yTot/amount);
	}
}