package edu.sbcc.cs105;

import sbccutils.*;
/*
 * The blur filter takes the nearest neighbor pixels (the ones surrounding a given pixel) and averages them. 
 * This takes the place of the center pixel.
 * This is done by implementing Filterable interface and using the filter method.
 * */
public class Blur implements Filterable {
	/* filter method adjusted to blur the rgb values of each pixel
	 * @param takes a PixelArray
	 * */
	public PixelArray filter(PixelArray pic) {
		int height = pic.getHeight();
		int width = pic.getWidth();
		
		//Iterate through all the pixels
		for (int i = 1; i < height - 1; i++) {
			for (int j = 1; j < width - 1; j++) {
				// Get the surrounding pixels
				Pixel one = pic.getPixel(i-1, j-1);
				Pixel two = pic.getPixel(i, j-1);
				Pixel three = pic.getPixel(i-1, j);
				Pixel four = pic.getPixel(i+1, j+1);
				Pixel five = pic.getPixel(i, j+1);
				Pixel six = pic.getPixel(i+1, j);
				Pixel seven = pic.getPixel(i-1, j+1);
				Pixel eight = pic.getPixel(i+1, j-1);
				
				// get averages for red, blue, green pixel
				int red = (one.r + two.r + three.r + four.r + five.r + six.r + seven.r + eight.r) / 8;
				int blue = (one.b + two.b + three.b + four.b + five.b + six.b + seven.b + eight.b) / 8; 
				int green = (one.g + two.g + three.g + four.g + five.g + six.g + seven.g + eight.g) / 8;
				
				// create new pixel with new rgb value
				Pixel blur_pixel = new Pixel(red, green, blue);
				
				// set the pixel at position i, j to the new pixel
				pic.setPixel(i, j, blur_pixel);
			}
		}
		/*
		 * @return a pixel array with adjusted rgb(blur) values.
		 * */
		return pic;
	}
}
