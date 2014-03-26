package coursework3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Goo {

    private JPanel gooPanel;

    private boolean loop = true;
    
    private int width, height;

    private int frameTimeInMillis = 50;

    private RenderingHints renderingHints = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    @SuppressWarnings("serial")
    class GooPanel extends JPanel 
    {
        public void paintComponent(Graphics g) 
        {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHints(renderingHints);
            draw(g2d);
        }
    }
    
    public Goo() 
    {
        this(800, 500);
    }

    public Goo(int w, int h) 
    {
        width = w;
        height = h;

        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gooPanel = new GooPanel();
        gooPanel.setPreferredSize(new Dimension(w, h));
        frame.getContentPane().add(gooPanel);
        frame.pack();
        
        frame.setVisible(true);
    }

    public void go() 
    {
        while (loop) 
        {
            gooPanel.repaint(); 
            update();
			
            try 
            {
                Thread.sleep(frameTimeInMillis);
            } 
            catch (InterruptedException e) 
            {
            }
        }
    }

    public void draw(Graphics2D g) 
    {
    }
    
    public void update()
    {
    }
    
    public void setFrameTime(int millis)
    {
        frameTimeInMillis = millis;
    }
    
    public int getFrameTime()
    {
        return frameTimeInMillis;
    }
    
    public void noLoop()
    {
       loop = false;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
}
