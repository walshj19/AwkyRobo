import processing.core.*;


public class EntityTest extends PApplet {
	Entity first;
	
	int x = 7;
	long a;
	
	float b = 7.5f;
	double c;
	
	char d = '7';
	boolean e = true;
	byte f;
	
	public void setup(){
		size(800, 800, P3D);
		frameRate(30);
		first = new Entity(this, 200, 200);
	}
	
	public void draw(){
		camera(mouseX, mouseY, (height/2) / tan(PI/6), width/2.0f, height/2.0f, 0, 0, 1, 0);
		background(255);
		first.draw();
	}
}
