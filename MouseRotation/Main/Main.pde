void setup()
{
  size(200, 200);
}

void draw()
{
  float angle = atan2(mouseY - 100, mouseX - 100);
  
  background(255);
  pushMatrix();
  translate(100, 100);
  rotate(angle);
  rect(0, 0, 50, 10);
  popMatrix();
}
