package coursework3;

import java.util.*;
import java.awt.*;

public class Circle extends SimpleShape
{
	Circle(int screenheight, int screenwidth)
	{
		super(screenheight, screenwidth);
	}
	public void draw(Graphics2D g2d)
	{
		setColor(g2d);
		g2d.fillOval(xpos, ypos, size, size);
	}
}
