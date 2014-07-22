import processing.core.*;


public class EntityTest extends PApplet {
	Entity[] entities;
	final int NUMBER_OF_ENTITIES = 5;
	
	public void setup(){
		size(800, 800, P3D);
		frameRate(30);
		entities = new Entity[NUMBER_OF_ENTITIES];
		for(int i = 0; i < entities.length; i++){
			entities[i] = new Entity(this);
		}
	}
	
	public void draw(){
		background(0);
		//camera(mouseX, mouseY, (height/2) / tan(PI/6), width/2.0f, height/2.0f, 0, 0, 1, 0);
		text("frame rate = "+frameRate, 20, 20);
		for(int i = 0; i < entities.length; i++){
			entities[i].draw();
			entities[i].updatePosition(entities);
		}
	}
}
