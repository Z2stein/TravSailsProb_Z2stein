package com.z2stein.travelingsailsmanproblem.PostP;

import java.awt.Canvas;
import java.awt.Point;

/**
 * Provides all Methodes for the PostProcessing stuff
 * 
 *
 */
public class PostProcessing extends Canvas {

	private static final long serialVersionUID = -4517845051693542161L;
	private static int[] windowSize = {600,750};
	private static Point[] points;
	
	public static void main(String[] args) {
		

		double[][] data = getdata();
		
		points = ConvertToPointsWithPixelCoordinates(data,windowSize);
		
		LineMy[] lines  = getLines(points);
		
		Screen.setPoints(points);
		Screen.setLines(lines);
		
		new Screen(windowSize, "Blas");
		

    }



/**
 * COnvertes GeoCoordinates to Point Array
 * @param data the Array with the GeoCoordinates
 * @param windowSize2 the Size of the Used Window in Pixel {x,y}
 * @return the Array with a Point for every Location
 */
private static Point[] ConvertToPointsWithPixelCoordinates(double[][] data, int[] windowSize2) {
	/**
	 * Specifies a empty area at the Window Border
	 */
	int Pixelborder=50 ;
	
	Point[] resultPoint = new Point[data.length];

	double[][] dataStatistics = getMinMaxSpan(data); //{{xMin,xMax,xMax-xMin},{yMin,yMax,yMax-yMin}}
	
	
	// convert GeoCoordinates to double between 0 and 1.0
	for (int i = 0; i < data.length; i++) {
		for (int j = 0; j < data[0].length; j++) {
			data[i][j] = (data[i][j]-dataStatistics[j][0])/dataStatistics[j][2];
		}
	}
	
	// convert CoordinateDoubleFactor to Points
	int tempCoordX;
	int tempCoordY;
	
	for (int i = 0; i < data.length; i++) {
		tempCoordX = (int) (Pixelborder + data[i][0]*(windowSize2[0]-2*Pixelborder) );
		tempCoordY = (int) (Pixelborder + data[i][1]*(windowSize2[1]-2*Pixelborder) );
		resultPoint[i] = new Point(tempCoordX,tempCoordY);
	}
		return resultPoint;
	}




private static LineMy[] getLines(Point[] points) {
		int numberOfLines=10;
	
		LineMy[] lines = new LineMy[numberOfLines];
		for (int i = 0; i < lines.length; i++) {
			lines[i] = new LineMy(points[i], points[i+1]);
		}
	
		return lines;
	}


/**
 * Calculates the Minimum, the Maximum and the Span for X and Y Coordinates
 * @param data the GeoCoordinates as 2D Array
 * @return A 2D ResultArray with Min, Max, and Span for X and Y
 */
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

		double[][] resultArray = {{xMin,xMax,xMax-xMin},{yMin,yMax,yMax-yMin}};
		return resultArray;
	}




/**
 * @return the Locations of the msg-bases
 */
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
