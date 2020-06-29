package com.z2stein.travelingsailsmanproblem.PostP;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.sql.DataSource;
import javax.swing.JFrame;

public class PostProcessing extends Canvas {
	static int[] windowSize = {600,750};
	static int[][] pixelData;
	
	public static void main(String[] args) {
		
	//erhalte Daten
		double[][] data = getdata();
		pixelData = ConvertToPixelCoordinates(data,windowSize);
		Screen.setPixelData(pixelData);
		
		new Screen(windowSize, "Blas");
		
		

//        JFrame frame = new JFrame("My Drawing");
//        Canvas canvas = new PostProcessing();
//        canvas.setSize(windowSize[0], windowSize[1]);
//        frame.add(canvas);
//        frame.pack();
//        frame.setVisible(true);
    }

//    public void paint(Graphics g) {
//    	int x,y;
//    	int size = 20;
//    	
//    	for (int i = 0; i < pixelData.length; i++) {
//			x = pixelData[i][0];
//			y = pixelData[i][1];
//			        g.fillOval(x, y, size, size);
//		}
//
//    }



	private static int[][] ConvertToPixelCoordinates(double[][] data, int[] windowSize2) {
		
		int Pixelborder=70 ;

		double[][] tempFloat = new double[data.length][data[0].length];
		int[][] res = new int[data.length][data[0].length];

		
		double[][] dataStatistics = getMinMaxSpan(data); //{{xMin,xMax,xMax-xMin},{yMin,yMax,yMax-yMin}}
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				tempFloat[i][j] = (data[i][j]-dataStatistics[j][0])/dataStatistics[j][2];
			}
		}
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				res[i][j] = (int) (Pixelborder + tempFloat[i][j]*(windowSize2[j]-2*Pixelborder) );
				System.out.println(j+"  "+res[i][j]);
			}
			
		}
		
		return res;
	}





	private static double[][] getMinMaxSpan(double[][] data) {
	
		double xMax=0,yMax=0;
		double xMin=100,yMin=100;
		
		for (int i = 0; i < data.length; i++) {
						
			if (data[i][0]>xMax) {
				xMax = data[i][0];
			}
			if (data[i][1]>yMax) {
				yMax = data[i][1];
			}
			
			if (data[i][0]<xMin) {
				xMin = data[i][0];
			}
			if (data[i][1]<yMin) {
				yMin = data[i][1];
			}
		}

		double[][] res = {{xMin,xMax,xMax-xMin},{yMin,yMax,yMax-yMin}};
		return res;
	}





	private static double[][] getdata() {
		
		double[][] data =  	{{48.229035, 11.686153},
				{52.580911,13.293884},
				{52.278748,10.524797},
				{49.032767,8.698372},
				{50.829383,12.914737},
				{51.274774,6.794912},
				{51.450577,7.008871},
				{50.136479,8.570963},
				{51.145511,14.970028},
				{53.557577,9.986065},
				{52.337987,9.769706},
				{48.784417,11.399106},
				{50.886726,6.913119},
				{52.519154,7.322185},
				{51.969304,7.61428},
				{49.429596,11.017404},
				{48.571989,13.453256},
				{53.537779,7.936809},
				{48.126258,8.325873},
				{48.694648,9.161239},
				{49.295011,8.649036}};
		return data;
	}

}
