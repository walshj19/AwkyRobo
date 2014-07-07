import processing.core.*;

public class Main extends PApplet{
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
