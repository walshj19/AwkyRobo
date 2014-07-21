import processing.core.*;


public class EntityTest extends PApplet {
	Entity[] entities;
	final int NUMBER_OF_ENTITIES = 5;
	
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
		entities = new Entity[NUMBER_OF_ENTITIES];
		for(int i = 0; i < entities.length; i++){
			entities[i] = new Entity(this);
		}
	}
	
	public void draw(){
		//camera(mouseX, mouseY, (height/2) / tan(PI/6), width/2.0f, height/2.0f, 0, 0, 1, 0);
		background(0);
		for(int i = 0; i < entities.length; i++){
			entities[i].draw();
			entities[i].updatePosition();
		}
	}
}
