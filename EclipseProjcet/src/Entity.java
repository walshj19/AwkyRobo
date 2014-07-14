import processing.core.PApplet;

public class Entity {
	PApplet parent;
	
	float x = 50;
	float y = 50;
	float size = 20;
	
	public Entity(PApplet applet){
		this.parent = applet;
	}
	
	private void squiggles(){
		float x1 = parent.random(size);
		float y1 = parent.random(size);
		
		//l1 -> l2 is horizontal
		float x2 = x1;
		float y2 = parent.random(size);
		
		float x3 = parent.random(size);
		float y3 = y2;
		
		float x4 = x3;
		float y4 = parent.random(size);
		
		float x5 = parent.random(size);
		float y5 = y4;
		
		parent.line(x+x1, y+y1, x+x2, y+y2);
		parent.line(x+x2, y+y2, x+x3, y+y3);
		parent.line(x+x3, y+y3, x+x4, y+y4);
		parent.line(x+x4, y+y4, x+x5, y+y5);
	}
	
	/**
	 * A collection of spheres orbiting each other.
	 */
	private void spheres(){
		parent.ellipse(x, y, size, size);
	}
	
	public void draw(){
		//squiggles();
		spheres();
	}
}
