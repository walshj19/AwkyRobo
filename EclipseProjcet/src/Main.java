import processing.core.*;

public class Main extends PApplet{
	  int locationX = 100;
	  int locationY = 100;
	  int size = 50;
	  int speed = 0;
	  
	public void setup() {
		size(800,800, P3D);
		background(0);
		
		//right
		//pushMatrix();
		//rect(0, 0, 200, 200);
		//popMatrix();
	}
	
	public void draw() {
		lights();
		background(0);
		camera(mouseX, mouseY, (height/2) / tan(PI/6), mouseX, mouseY, 0, 0, 1, 0);
		translate(width/2, height/2, -100);
		stroke(255);
		sphereDetail(15);
		//noFill();
		//box(200);
		
		//setup the sides of a box as squares
		fill(51);
		stroke(255);
		//back
		pushMatrix();

		translate(200, 200, 0);
		stroke(random(255), random(255), random(255));

	    float x1 = random(size);
	    float y1 = random(size);

	    //l1 -> l2 is horizontal
	    float x2 = x1;
	    float y2 = random(size);

	    float x3 = random(size);
	    float y3 = y2;

	    float x4 = x3;
	    float y4 = random(size);

	    float x5 = random(size);
	    float y5 = y4;

	    line(locationX+x1, locationY+y1, locationX+x2, locationY+y2);
	    line(locationX+x2, locationY+y2, locationX+x3, locationY+y3);
	    line(locationX+x3, locationY+y3, locationX+x4, locationY+y4);
	    line(locationX+x4, locationY+y4, locationX+x5, locationY+y5);
	    
		//rect(0, 0, 200, 200);
		/*for(int i = 0; i < 10; i++){
			pushMatrix();
			translate(0, i*20, 0);
			for(int j = 0; j < 10; j++){
				pushMatrix();
				translate(j*20, 0, 0);
				sphere(3);
				popMatrix();
			}
			popMatrix();
		}*/
		popMatrix();
		//left
		pushMatrix();
		translate(200, 200, 0);
		rotateY(radians(270));
		//rect(0, 0, 200, 200);
		for(int i = 0; i < 10; i++){
			pushMatrix();
			translate(0, i*20, 0);
			for(int j = 0; j < 10; j++){
				pushMatrix();
				translate(j*20, 0, 0);
				sphere(3);
				popMatrix();
			}
			popMatrix();
		}
		popMatrix();
		//bottom
		pushMatrix();
		translate(200, 400, 0);
		rotateX(radians(90));
		//rect(0, 0, 200, 200);
		for(int i = 0; i < 10; i++){
			pushMatrix();
			translate(0, i*20, 0);
			for(int j = 0; j < 10; j++){
				pushMatrix();
				translate(j*20, 0, 0);
				sphere(3);
				popMatrix();
			}
			popMatrix();
		}
		popMatrix();
	}
	
	/*public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "Main" });
	}*/
}
/*
class Entity {

	  void drawEntity() {
	    
	  }

	  void changeLocation(int x, int y) {
	    locationX += x;
	    locationY += y;
	  }

	  void moveRandom() {
	    int tx = locationX + (int)random(-speed, speed);
	    if (tx >= 0 && tx <= 800) {
	      locationX = tx;
	    }
	    int ty = locationY + (int)random(-speed, speed);
	    if (ty >= 0 && ty <= 800) {
	      locationY = ty;
	    }
	  }

	  void changeSpeed(int d) {
	    speed += d;
	  }
	}*/
