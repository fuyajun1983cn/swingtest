package me.ifjy.swingtest;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

public class FontTest
{
    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable() {
                public void run()
                {
                    FontFrame frame = new FontFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
            });
    }
}

class FontFrame extends JFrame
{
    public FontFrame()
    {
        setTitle("font test");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        FontComponent component = new FontComponent();
        add(component);
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}

class FontComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        String message = "Hello, world1, gf";

        Font f = new Font("Serif", Font.BOLD, 36);
        g2.setFont(f);

        //measure the size of the message
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);

        // set (x, y)  = top-left corner of text

        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;

        //add ascent to y to reach the baseline
        double ascent = -bounds.getY();
        double baseY = y + ascent;

        //draw the message
        g2.drawString(message, (int)x, (int)baseY);

        g2.setPaint(Color.LIGHT_GRAY);

        //draw the base line
        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

        //draw the enclosing rectangle
        Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);
    }
}

