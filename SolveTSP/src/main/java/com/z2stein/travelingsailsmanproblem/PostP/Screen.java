package com.z2stein.travelingsailsmanproblem.PostP;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

/**
 * Is an Object which make a Graphical Window possible
 * @author Z2stein
 * 
 */
public class Screen extends JFrame {
	
	private static final long serialVersionUID = 2950298496204562715L;

	private static Point[] points;
	private static LineMy[] lines;
	

	
	/**
	 * Creates a Window
	 * @param windowSize the Size of the Used Window in Pixel {x,y}
	 * @param title of the Windows
	 */
	protected Screen(int[] windowSize, String title) {

		setSize(windowSize[0], windowSize[1]);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
		
		setVisible(true);
		
		
	}

	public static void setLines(LineMy[] lines) {
		Screen.lines = lines;
	}
/**
 * paint the Points and Lines
 */
  public void paint(Graphics g) {
	int x,y;
	int size = 10;
	
	for (int i = 0; i < points.length; i++) {
		x = points[i].x;
		y = points[i].y;
		        g.fillOval(x, y, size, size);
	}
	
	for (int i = 0; i < lines.length; i++) {
		g.drawLine(lines[i].getpA().x, lines[i].getpA().y, lines[i].getpB().x, lines[i].getpB().y);
	}
	

  }

public static void setPoints(Point[] points) {
	Screen.points = points;
}


}
