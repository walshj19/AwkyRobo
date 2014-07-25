import processing.core.*;

public class Entity {
	PApplet parent;
	
	//basic properties
	float x, y;
	float size = 70;
	
	public float crowdSize = 0;
	
	//movement vector
	float dx, dy;
	
	//for spheres
	float theta = 0;
	float posX = 0;
	float posY = 0;
	
	float xAxisOffset;
	float yAxisOffset;
	float zAxisOffset;
	
	public Entity(PApplet applet){
		this.parent = applet;
		
		this.x = parent.random(0, parent.width-size);
		this.y = parent.random(0, parent.height-size);
		
		this.dx = parent.random(-10, 10);
		this.dy = parent.random(-10, 10);
		
		//xAxisOffset = parent.random(0, 2*parent.PI);
	}
	
	public void squiggles(){
		parent.stroke(parent.random(20,60), parent.random(20,200), 120);
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
	
	public void square(){
		parent.rect(x, y, size, size);
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
	
	void move(float mx, float my){
		this.x += mx;
		this.y += my;
	}
	
	void setMovVec(float dx, float dy){
		this.dx = dx;
		this.dy = dy;
	}
	
	public void updatePosition(){
		PVector vect = new PVector(0,y);
		float xTemp = x + dx;
		float yTemp = y + dy;
		
		//calculate the distance from this entity to every other
		/*double[] distances = new double[entities.length];
		for(int i = 0; i < entities.length; i++){
			Entity current = entities[i];
			if(current.x == x && current.y == y){continue;}
			distances[i] = Math.sqrt(Math.pow(x-current.x, 2)+Math.pow(y-current.y, 2));
			if(distances[i] < 100){
				size = 20;
			}else{
				size = 70;
			}
		}*/
		PVector tempVect = new PVector(xTemp, yTemp);
		if(PVector.dist(tempVect, vect) > PVector.dist(new PVector(x,y), vect) && PVector.dist(tempVect, vect) > crowdSize && ((int)parent.random(3))%2 == 1){
			dx = -dx;
			dy = -dy;
			return;
		}
		//check if new values are out of bounds
		if(xTemp < 0 || xTemp > parent.width-size){
			dx = -dx;
		}else{
			x = xTemp;
		}
		if(yTemp < 0 || yTemp > parent.height-size){
			dy = -dy;
		}else{
			y = yTemp;
		}
		
	}
	
	public void draw(){
		//square();
		squiggles();
		//spheres();
		//pipes();
	}
}
