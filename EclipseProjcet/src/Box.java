
public class Box {
	float x;
	float y;
	float size;		//length of one side
	
	float claculateArea(){
		return size*size;
	}
	
	void move(float newX, float newY){
		x = newX;
		y = newY;
	}
}
