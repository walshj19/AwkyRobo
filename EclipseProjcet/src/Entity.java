import processing.core.PApplet;
import SimpleOpenNI.*;

public class Entity {
	PApplet parent;
	SimpleOpenNI openNI;
	
	public Entity(PApplet applet){
		this.parent = applet;
		openNI = new SimpleOpenNI(parent);
	}
	
	public void draw(){
		
	}
}
