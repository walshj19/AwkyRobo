import processing.core.*;
import processing.opengl.*;
import SimpleOpenNI.*;

public class PointCloudTest extends PApplet {
	SimpleOpenNI kinect;
	float rotation = 0;
	int boxSize = 150;
	PVector boxCenter = new PVector(0, 0, 600);
	int crowd = 0;
	
	public void setup() {
		size(1024, 768, OPENGL);
		kinect = new SimpleOpenNI(this);
		kinect.enableDepth();
		kinect.enableRGB();
		//frameRate(15);
		kinect.alternativeViewPointDepthToImage();
	}
	
	public void draw() {
		background(0);
		text("frame rate "+frameRate, 50, 50);
		text("crowd "+crowd, 50, 30);
		float val = map(crowd, 0, 150000, 0, width);
		rect(50, 60, val, 10);
		kinect.update();
		PImage rgbImage = kinect.rgbImage();
		
		// prepare to draw centered in x-y
		// pull it 1000 pixels closer on z
		translate(width/2, height/2, -1000);
		rotateX(radians(180)); // flip y-axis from "realWorld"
		
		translate(0, 0, -250);
		
		//rotateY(radians(rotation));
		//rotation++;
		
		float mouseRotation = map(mouseX, 0, width, -180, 180);
		rotateY(radians(mouseRotation));
		
		stroke(255);
		// get the depth data as 3D points
		PVector[] depthPoints = kinect.depthMapRealWorld();
		
		crowd = 0;
		for(int i = 0; i < depthPoints.length; i+=2){
			// get the current point from the point array
			PVector currentPoint = depthPoints[i];
			stroke(rgbImage.pixels[i]);
			// draw the current point
			if(currentPoint.z == 0 || currentPoint.z < 2000){
				crowd++;
				point(currentPoint.x, currentPoint.y, currentPoint.z);
			}
		}
		
		// We're ready to draw the cube 4
		// move to the box center
		translate(boxCenter.x, boxCenter.y, boxCenter.z);
		// set line color to red
		stroke(255, 0, 0);
		// leave the box unfilled so we can see through it
		noFill();
		// draw the box
		//box(boxSize);
	}
}
