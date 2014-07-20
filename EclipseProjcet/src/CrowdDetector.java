import SimpleOpenNI.*;
import processing.core.*;

public class CrowdDetector {
	SimpleOpenNI kinect;
	
	public CrowdDetector(PApplet context){
		kinect = new SimpleOpenNI(context);
		kinect.enableDepth();
	}
	
	public float getCrowdSize(){
		kinect.update();
		
		int crowdSize = 0;
		int[] depthPoints = kinect.depthMap();
		
		for(int i = 0; i < depthPoints.length; i++){
			int current = depthPoints[i];
			if(current < 2000 && current != 0){
				crowdSize++;
			}
		}
		return crowdSize;
	}
}