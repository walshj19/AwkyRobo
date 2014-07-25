import processing.core.*;

public class EntityTest extends PApplet {
	final int NUMBER_OF_ENTITIES = 1000;
	final int MAX_CROWD = 100000;
	final int WIDTH = 1920;
	final int HEIGHT = 1080;
	
	Entity[] entities;
	CrowdDetector detector;

	/*public int sketchWidth() {
		return WIDTH;
	}
	
	public int sketchHeight() {
		return HEIGHT;
	}
	
	public String sketchRenderer() {
		return P3D;
	}*/
	
	public void setup(){
		size(WIDTH, HEIGHT, P3D);
		frameRate(30);
		detector = new CrowdDetector(this);
		entities = new Entity[NUMBER_OF_ENTITIES];
		for(int i = 0; i < entities.length; i++){
			entities[i] = new Entity(this);
		}
	}
	
	public void draw(){
		background(0);
		//text("frame rate = "+frameRate, 20, 20);
		float crowdSize = map(detector.getCrowdSize(), 0, MAX_CROWD, width, 0);
		//PVector vect = detector.getAverage();
		//vect = new PVector(map(vect.x,0,640,0,width), map(vect.y,0,480,0,height));
		//vect = new PVector(mouseX, mouseY);
		
		for(int i = 0; i < entities.length; i++){
			entities[i].draw();
			if(random(0,2) < 1 && i%2 == 0){
				continue;
			}
			entities[i].crowdSize = crowdSize;
			entities[i].updatePosition();
		}
		//ellipse(vect.x, vect.y, 30, 30);
	}
	
	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "EntityTest" });
	}
}
