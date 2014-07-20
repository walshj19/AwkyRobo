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
		
		int[] depthValues = kinect.depthMap();
		
		for(int y = 0; y < 480 ; y++){
			for(int x = 0; x < 640; x++){
				int i = x + (y * 640);
				int currentDepth = depthValues[i];
				if(currentDepth < 2000 && currentDepth != 0){
					float color = map(currentDepth, 0, 2000, 255, 0);
					stroke(color);
					point(x, y);
				}
			}
		}
		text(frameRate, 10, 20);
	}
}