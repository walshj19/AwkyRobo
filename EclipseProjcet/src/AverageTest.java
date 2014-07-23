import processing.core.*;

public class AverageTest extends PApplet {
	PVector vect;
	
	public void setup(){
		size(640, 480);
		vect = new PVector(0,0);
	}
	
	public void draw(){
		background(0);
		
		vect = new PVector((vect.x+mouseX)/2, (vect.y+mouseY)/2);
		
		stroke(0);
		fill(255);
		ellipse(vect.x, vect.y, 50, 50);
		text(frameRate, 10, 20);
		text(vect.x+" : "+vect.y, 10, 40);
	}
}