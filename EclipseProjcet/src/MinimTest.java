import processing.core.*;
import ddf.minim.*;
import ddf.minim.analysis.*;


public class MinimTest extends PApplet {
	Minim minim;
	AudioPlayer player;
	AudioInput input;
	FFT fft;
	
	public void setup() {
		size(400,400);
		minim = new Minim(this);
		player = minim.loadFile("test.mp3");
		input = minim.getLineIn();
		player.play();

		fft = new FFT(player.bufferSize(), player.sampleRate());
	}
	
	public void draw() {
		background(0);

		fft.forward(player.mix);
		
		stroke(255, 0, 0, 128);
		  // draw the spectrum as a series of vertical lines
		  // I multiple the value of getBand by 4 
		  // so that we can see the lines better
		  for(int i = 0; i < fft.specSize(); i++)
		  {
		    line(i, height, i, height - fft.getBand(i)*4);
		  }
		
		  stroke(255);
		  // we draw the waveform by connecting neighbor values with a line
		  // we multiply each of the values by 50 
		  // because the values in the buffers are normalized
		  // this means that they have values between -1 and 1. 
		  // If we don't scale them up our waveform 
		  // will look more or less like a straight line.
		  for(int i = 0; i < player.bufferSize() - 1; i++)
		  {
		    line(i, 50 + player.left.get(i)*50, i+1, 50 + player.left.get(i+1)*50);
		    line(i, 150 + player.right.get(i)*50, i+1, 150 + player.right.get(i+1)*50);
		  }
	}
	
	public void keyPressed(){
		if(keyCode == UP){
			//player.shiftVolume(arg0, arg1, arg2);;
		}
	}
}
