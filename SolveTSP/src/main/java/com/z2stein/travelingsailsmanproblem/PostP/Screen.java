package com.z2stein.travelingsailsmanproblem.PostP;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Screen extends JFrame {
	
	static int[][] pixelData;
	
	public static void setPixelData(int[][] pixelData) {
		Screen.pixelData = pixelData;
	}
	
	public Screen(int[] windowSize, String title) {

		setSize(windowSize[0], windowSize[1]);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.pack();
		
		setContentPane(new DrawArea());
		setVisible(true);
		
		
	}
	
  public void paint(Graphics g) {
	int x,y;
	int size = 20;
	
	for (int i = 0; i < pixelData.length; i++) {
		x = pixelData[i][0];
		y = pixelData[i][1];
		        g.fillOval(x, y, size, size);
	}

  }

}
