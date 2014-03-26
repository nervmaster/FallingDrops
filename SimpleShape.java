package coursework3;

import java.util.*;
import java.awt.*;


public abstract class SimpleShape implements TwoDimensionalShapes
{
	protected final int DEFAULT_MAX_SIZE_VARIANCE = 20; //max size
	protected final int DEFAULT_MAX_FALLING_RATE = 15; //the more higher drops more slowly
	protected final int DEFAULT_MAX_VARIANCE = 15; // difference between x axis and y axis shape size
	protected final int DEFAULT_MIN_SIZE = 15; // minimum size

	protected int internalclock; //count number of updates

	protected int screenheight; 
	protected int screenwidth;

	protected int fallingrate; //falling speed. Higher falls slower
	protected int size;
	protected int colorid; //assign a color

	//position to draw
	protected int xpos; 
	protected int ypos;

	protected Random rand;

	

	SimpleShape(int screenheight, int screenwidth)
	{
		this.screenheight = screenheight;
		this.screenwidth = screenwidth;
		this.rand = new Random();


		this.fallingrate = rand.nextInt(DEFAULT_MAX_FALLING_RATE) + 1;
		this.size = rand.nextInt(DEFAULT_MAX_SIZE_VARIANCE) + DEFAULT_MIN_SIZE;
		this.colorid = 0;

		this.internalclock = 0;

		this.xpos = rand.nextInt(screenwidth); //draws randomly on screen
		this.ypos = rand.nextInt(screenheight);

	}

	protected void setColor(Graphics2D g2d) 
	{
		switch(colorid) //changes color of g2d
		{
			case 0:
				g2d.setColor(Color.BLACK);
				break;
			case 1:
				g2d.setColor(Color.DARK_GRAY);
				break;
			case 2:
				g2d.setColor(Color.LIGHT_GRAY);
				break;
			case 3:
				g2d.setColor(Color.WHITE);
				break;
			case 4:
				g2d.setColor(Color.LIGHT_GRAY);
				break;
			default:
				g2d.setColor(Color.DARK_GRAY);
				break;
		}
	}

	//Classes of interface
	abstract public void draw(Graphics2D g2d);
	public  void update()
	{
		internalclock++;
		if((internalclock % fallingrate) == 0)
		{
			colorid++; //it only changes color when changes positions
			ypos++;
		}
		if((ypos - size/2) > screenheight) //print at top of window again
		{
			internalclock = 0;
			ypos = -size/2;
		}
		if(colorid == 6)
		{
			colorid = 0;
		}
	}

}