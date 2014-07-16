import processing.core.*;
import processing.event.*;

public class Main extends PApplet{
	final int WIDTH = 800;
	final int HEIGHT = 800;
	
	float cameraX = width/2;
	float cameraY = height/2;
	int mouseDraggedX = 0;
	int mouseDraggedY = 0;
	float zoom = 1;
	
	int locationX = 100;
	int locationY = 100;
	int size = 50;
	int speed = 0;
	
	Entity first = new Entity(this, 100, 200);

	public void setup() {
		size(WIDTH, HEIGHT, P3D);
		background(0);
		smooth(8);
		textSize(10);
	}
	
	public void draw() {
		//lights, camera
		lights();
		ambientLight(255, 255, 255);
		background(0);
		camera(cameraX, cameraY, (height/2) / tan(PI/6) * zoom, (width/2.0f)+200, (height/2.0f)+200, 0, 0, 1, 0);
		//text("camera x = "+cameraX, mouseX, mouseY);
		//text("camera y = "+cameraY, 2, 22);
		stroke(255);
		fill(51);
		sphereDetail(15);
		//stroke(random(255), random(255), random(255));

		pushMatrix();
		translate(width/2, height/2, 0);
		
		//action
		//left
		pushMatrix();
		first.draw();
		rect(0, 0, 200, 200);
		line(0,200,0, -200,200,0);
		popMatrix();
		
		//right
		pushMatrix();
		translate(200, 0, 0);
		rotateY(radians(270));
		//drawSphereGrid(10, 10);
		rect(0, 0, 200, 200);
		line(0,0,0, 0,-200,0);
		popMatrix();
		
		//bottom
		pushMatrix();
		translate(0, 200, 0);
		rotateX(radians(90));
		//drawSphereGrid(10, 10);
		rect(0, 0, 200, 200);
		line(200,0,0, 200,400,0);
		popMatrix();
		
		popMatrix();
	}
	
	/**
	 * Draws a grid of small spheres starting at the origin
	 * and increasing positively.
	 * @param x			the width of the grid
	 * @param y			the height of the grid
	 */
	public void drawSphereGrid(int x, int y){
		assert x > 0 && y > 0;
		for(int i = 0; i < y; i++){
			pushMatrix();
			translate(0, i*20, 0);
			for(int j = 0; j < x; j++){
				pushMatrix();
				translate(j*20, 0, 0);
				sphere(3);
				popMatrix();
			}
			popMatrix();
		}
	}
	
	/**
	 * Detects mouse scroll events to zoom the camera
	 */
	public void mouseWheel(MouseEvent event) {
		float temp = zoom + event.getCount() * 0.1f;
		if (temp > 0) {
			zoom = temp;
		}
	}
	
	public void mouseDragged(MouseEvent event){
		println("mouse dragged x = "+event.getX());
		println("mouse dragged y = "+event.getY());
		if (mouseDraggedX != 0 && mouseDraggedY != 0) {
			cameraX += event.getX() - mouseDraggedX;
			cameraY += event.getY() - mouseDraggedY;
		}
		mouseDraggedX = event.getX();
		mouseDraggedY = event.getY();
	}
	
	/**
	 * If this method is uncommented the project can be run as
	 * as a program instead of an applet
	 */
	
	//public static void main(String args[]) {
		//PApplet.main(new String[] { "--present", "Main" });
	//}
}