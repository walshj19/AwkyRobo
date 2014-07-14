import processing.core.*;


public class EntityTest extends PApplet {
	
	public void setup(){
		size(200, 200);
	}
	
	public void draw(){
		background(255);
		new Entity(this).draw();
	}
}
