import java.util.ArrayList;
import processing.core.*;
import SimpleOpenNI.*;

public class ONITest extends PApplet {
	SimpleOpenNI kinect;
	float centerX=0,centerY=0;
	float maxX=0, maxY=0;
	float minX=640, minY=480;
	
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
		
		for(int y = 0; y < 480 ; y++){
			for(int x = 0; x < 640; x++){
				int i = x + (y * 640);
				int currentDepth = depthValues[i];
				if(currentDepth < 2000 && currentDepth != 0){
					float color = map(currentDepth, 0, 2000, 255, 0);
					stroke(color);
					//point(x, y);
					centerX = (centerX+x)/2;
					centerY = (centerY+y)/2;
					if(x < minX){minX = x;}
					if(x > maxX){maxX = x;}
					if(y < minY){minY = y;}
					if(y > maxY){maxY = y;}
					goodPoints.add(new PVector(x,y));
					//System.out.println(x+" : "+y);
				}
			}
		}
		double x=0, y=0;
		for(PVector vect : goodPoints){
			x += vect.x;
			y += vect.y;
		}
		x /= goodPoints.size();
		y /= goodPoints.size();
		stroke(0);
		fill(255);
		ellipse((float)x, (float)y, 50, 50);
		text(frameRate, 10, 20);
		text(centerX+" : "+centerY, 10, 40);
		text(goodPoints.size(), 10, 60);
	}
}