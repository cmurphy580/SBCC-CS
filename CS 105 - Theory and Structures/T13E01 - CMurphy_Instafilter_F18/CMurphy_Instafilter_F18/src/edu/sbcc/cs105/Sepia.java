package edu.sbcc.cs105;

import sbccutils.*;
/*
 * The Sepia tone uses a special formula to adjust the rgb values of the pixel by implementing the Filterable interface and using the filter method.
 * */
public class Sepia implements Filterable {
	/* filter method adjusted to convert the rgb values of each pixel
	 * @param takes a PixelArray
	 * */
	public PixelArray filter(PixelArray pic) {
		int height = pic.getHeight();
		int width = pic.getWidth(); 
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int red, green, blue; 
				
				// get pixel in image;
				Pixel pixel = pic.getPixel(i, j);
				
				// calculate new red, blue, and green values. If greater than 255 reset to 255.
				red = (int)((pixel.r * .393) + (pixel.g * .769) + (pixel.b * .189));
				red = (red > 255) ? 255 : red; 
				
				green = (int)((pixel.r * .349) + (pixel.g * .686) + (pixel.b * .168));
				green = (green > 255) ? 255 : green; 
				
				blue = (int)((pixel.r * .272) + (pixel.g * .534) + (pixel.b * .131));
				blue = (blue > 255) ? 255 : blue;
				// set pixel's red, green, blue to new values
				pixel.r = red; 
				pixel.g = green;
				pixel.b = blue;
				
				// put that pixel in in PixelArray
				pic.setPixel(i, j, pixel);
			}
		}
		/*
		 * @return a pixel array with adjusted rgb(grey) values.
		 * */
		return pic;
	}
}
