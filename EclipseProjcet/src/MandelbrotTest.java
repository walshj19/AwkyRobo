import processing.core.*;

public class MandelbrotTest extends PApplet{
	final int MAX_ITER = 50;
	private float ZOOM = 500;
	private double zx, zy, cX, cY, tmp;
	
	public void setup(){
		size(500, 500);
		frameRate(15);
	}
	
	public void draw(){
		background(255);
		float zoom = map(mouseX, 0, width, 0, ZOOM);
		//println(zoom);
		
		for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                zx = zy = 0;
                cX = (x - 300) / (zoom);
                cY = (y - 200) / (zoom);
                int iter = MAX_ITER;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }
                //println(iter);
                stroke(iter | (iter << 8));
                point(x, y);
            }
        }
	}
}
