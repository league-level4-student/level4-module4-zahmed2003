package _03_polymorphs;

import java.awt.Color;
import java.awt.Graphics;

public class RedPolymorph extends Polymorph{

	RedPolymorph(int x, int y) {
		super(x, y);
		width = 50;
		height = 50;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
	
}
