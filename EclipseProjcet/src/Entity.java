import processing.core.PApplet;

public class Entity {
	PApplet parent;
	
	float x = 100;
	float y = 100;
	float size = 50;
	
	//for spheres
	float theta = 0;
	float posX = 0;
	float posY = 0;
	
	float xAxisOffset;
	float yAxisOffset;
	float zAxisOffset;
	
	public Entity(PApplet applet){
		this.parent = applet;
		
		x = parent.width/2;
		y = parent.height/2;
		
		xAxisOffset = parent.random(0, 2*parent.PI);
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
		//parent.ellipse(x, y, size, size);
		theta += 0.02;
		theta %= 2*parent.PI;
		
		posX = size * parent.cos(theta);
		posY = size * parent.sin(theta);
		
		//move the origin to where the center of the circle will be
		parent.pushMatrix();
		parent.translate(x, y);
		//parent.rotateX(xAxisOffset+theta);			//for rotating axes
		parent.rotateX(xAxisOffset);					//for static axes
		
		//draw the sphere
		parent.pushMatrix();
		parent.translate(posX, posY);
		parent.fill(255);
		parent.sphere(5);
		parent.popMatrix();
		
		//draw the circle
		parent.noFill();
		parent.stroke(255);
		parent.ellipse(0, 0, size*2, size*2);
		
		parent.popMatrix();
	}
	
	public void draw(){
		//squiggles();
		spheres();
	}
}
