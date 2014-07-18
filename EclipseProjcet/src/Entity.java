import processing.core.PApplet;

public class Entity {
	PApplet parent;
	
	float x = 100;
	float y = 300;
	float size = 70;
	
	//for spheres
	float theta = 0;
	float posX = 0;
	float posY = 0;
	
	float xAxisOffset;
	float yAxisOffset;
	float zAxisOffset;
	
	public Entity(PApplet applet, float x, float y){
		this.parent = applet;
		
		this.x = x;
		this.y = y;
		
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
	
	private void pipes(){
		float width = 10;
		float size = 150;
		
		float s1Length = parent.random(size/2, size);
		float s2Length = parent.random(size/2, size);
		float s3Length = parent.random(size/2, size);
		float s4Length = parent.random(size/2, size);
		float s5Length = parent.random(size/2, size);
		
		//s1Length = s2Length = s3Length = s4Length = s5Length = 70;
		
		float x1 = parent.width/2;
		float y1 = parent.height/2;
		float z1 = 0;
		
		float angle = parent.random(2*parent.PI);
		
		parent.pushMatrix();
		
		//translate to the middle of the first segment
		parent.translate(x1, y1, z1);
		parent.rotateZ(angle);
		parent.rotateY(angle);
		parent.box(width, width, s1Length);
		parent.pushMatrix();
		
		//draw one end
		parent.translate(0, -((s2Length/2)-(width/2)), (s1Length/2)+(width/2));
		parent.rotateX(parent.radians(90));
		parent.box(width, width, s2Length);
		
		parent.translate(0, ((s3Length/2)-(width/2)), (s2Length/2)+(width/2));
		parent.rotateX(parent.radians(90));
		parent.box(width, width, s3Length);
		
		//go back to the middle
		parent.popMatrix();
		
		//draw the other end
		parent.translate(0, ((s4Length/2)-(width/2)), -(s1Length/2)+(width/2));
		parent.rotateX(parent.radians(90));
		parent.box(width, width, s4Length);
		
		parent.translate(0, -((s5Length/2)-(width/2)), -(s4Length/2)+(width/2));
		parent.rotateX(parent.radians(90));
		parent.box(width, width, s5Length);
		
		parent.popMatrix();
		//parent.popMatrix();
	}
	
	private void fractal2d(){
		
	}
	
	/**
	 * A collection of spheres orbiting each other.
	 */
	void spheres(){
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
		parent.fill(0);
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
		//spheres();
		pipes();
	}
}
