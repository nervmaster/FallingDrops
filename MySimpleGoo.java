package coursework3;

import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

public class MySimpleGoo extends Goo 
{

	double x, y, r;
	final int DEFAULT_RADIUS = 10;
	final int DEFAULT_MAX_SHAPES = 200;
	final int DEFAULT_MIN_SHAPES = 110;

	private ArrayList<SimpleShape> shapelist;
	private int shapeno; //actual shape number
	private Random rand;


	public MySimpleGoo(int w, int h) 
	{
		super(w, h);
		setup();
	}

	public MySimpleGoo() 
	{
		setup();
	}

	public void setup() 
	{
		r = DEFAULT_RADIUS;
		x = getWidth() / 2;
		y = r;

		rand = new Random();

		shapeno = DEFAULT_MIN_SHAPES + rand.nextInt(DEFAULT_MAX_SHAPES - DEFAULT_MIN_SHAPES);

		shapelist = new ArrayList<SimpleShape>();


		for(int i = 0; i < shapeno; i++) // populates shape list with the shapes
		{
			//3 different shapes in total
			switch(rand.nextInt(3)) 
			{
				case 0:
					shapelist.add(new Rectangle(getHeight(), getWidth() ));
					break;
				case 1:
					shapelist.add(new Circle(getHeight(), getWidth() ));
					break;
				default:
					shapelist.add(new Oval(getHeight(), getWidth() ));
					break;
			}
		}


	}

	public void draw(Graphics2D g) 
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
	
		for(SimpleShape shape : shapelist)
		{
			shape.draw(g);
		}
	}

	public void update() 
	{
		for(SimpleShape shape : shapelist)
		{
			shape.update();
		}

	}

	public static void main(String[] args) 
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();


		Goo goo = new MySimpleGoo((int) dim.width, (int) dim.height);
		//Goo goo = new MySimpleGoo(640, 480);
		goo.go();
	}
}
