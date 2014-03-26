package coursework3;

import java.util.*;
import java.awt.*;

public class Oval extends SimpleShape
{
	private int sizeheight;

	Oval(int screenheight, int screenwidth)
	{
		super(screenheight, screenwidth);
		sizeheight = size + rand.nextInt(DEFAULT_MAX_VARIANCE);
	}
	public void draw(Graphics2D g2d)
	{
		setColor(g2d);
		g2d.fillOval(xpos, ypos, size, sizeheight);
	}
}