package com.z2stein.travelingsailsmanproblem.PostP;

import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * Is an Object which make a Graphical Window possible
 * @author Chris
 * 
 */
public class Screen extends JFrame {
	
	private static final long serialVersionUID = 2950298496204562715L;

	static int[][] pointPixelData;
	
	public static void setPixelData(int[][] pixelData) {
		Screen.pointPixelData = pixelData;
	}
	
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

/**
 * paint the Points and Lines
 */
  public void paint(Graphics g) {
	int x,y;
	int size = 20;
	
	for (int i = 0; i < pointPixelData.length; i++) {
		x = pointPixelData[i][0];
		y = pointPixelData[i][1];
		        g.fillOval(x, y, size, size);
	}

  }

}
