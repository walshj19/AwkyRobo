import processing.core.*;

public class EntityTest extends PApplet {
	final int NUMBER_OF_ENTITIES = 500;
	final int WIDTH = displayWidth;
	final int HEIGHT = displayHeight;
	
	Entity[] entities;
	CrowdDetector detector;

	public int sketchWidth() {
		return WIDTH;
	}
	
	public int sketchHeight() {
		return HEIGHT;
	}
	
	public String sketchRenderer() {
		return P3D;
	}
	
	public void setup(){
		frameRate(30);
		detector = new CrowdDetector(this);
		entities = new Entity[NUMBER_OF_ENTITIES];
		for(int i = 0; i < entities.length; i++){
			entities[i] = new Entity(this);
		}
	}
	
	public void draw(){
		background(0);
		//camera(mouseX, mouseY, (height/2) / tan(PI/6), width/2.0f, height/2.0f, 0, 0, 1, 0);
		text("frame rate = "+frameRate, 20, 20);
		float crowdSize = map(detector.getCrowdSize(), 0, 50000, width, 0);
		PVector vect = detector.getAverage();
		//PVector vect = new PVector(mouseX, mouseY);
		vect = new PVector(map(vect.x,0,640,0,width), map(vect.y,0,480,0,height));
		//vect = new PVector(mouseX, mouseY);
		for(int i = 0; i < entities.length; i++){
			entities[i].draw();
			if(random(0,2) < 1 && i%2 == 0){
				continue;
			}
			entities[i].crowdSize = crowdSize;
			entities[i].updatePosition(vect);
		}
		ellipse(vect.x, vect.y, 30, 30);
	}
	
	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "EntityTest" });
	}
}
