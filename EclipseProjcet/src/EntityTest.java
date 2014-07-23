import processing.core.*;


public class EntityTest extends PApplet {
	Entity[] entities;
	final int NUMBER_OF_ENTITIES = 5000;
	CrowdDetector detector;
	
	public void setup(){
		size(1920, 1080, P2D);
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
		float crowdSize = map(detector.getCrowdSize(), 0, 50000, 1920, 0);
		PVector vect = detector.getAverage();
		vect = new PVector(map(vect.x,0,640,0,1920), map(vect.y,0,480,0,1080));
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
