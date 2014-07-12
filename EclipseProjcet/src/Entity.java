import processing.core.PApplet;

public class Entity {
	PApplet parent;
	
	int x = 50;
	int y = 50;
	int size = 20;
	
	public Entity(PApplet applet){
		this.parent = applet;
	}
	
	public void draw(){
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
}
