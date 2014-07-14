import processing.core.*;


public class EntityTest extends PApplet {
	Entity first;
	
	public void setup(){
		size(400, 400, P3D);
		first = new Entity(this);
	}
	
	public void draw(){
		background(0);
		first.draw();
	}
}
