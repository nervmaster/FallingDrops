package coursework3;

import java.util.*;
import java.awt.*;

public class Rectangle extends SimpleShape
{

	private int sizeheight;

	Rectangle(int screenheight, int screenwidth)
	{
		super(screenheight, screenwidth);
		sizeheight = size + rand.nextInt(DEFAULT_MAX_VARIANCE);
	}
	public void draw(Graphics2D g2d)
	{
		setColor(g2d);
		g2d.fillRect(xpos, ypos, size, sizeheight);
	}
}
