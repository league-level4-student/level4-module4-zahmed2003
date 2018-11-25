package _03_polymorphs;

import java.awt.Color;
import java.awt.Graphics;

public class MovingMorph extends Polymorph{

	MovingMorph(int x, int y) {
		super(x, y);
		width = 50;
		height = 50;
	}

	public void update()
	{
		x++;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
	
}
