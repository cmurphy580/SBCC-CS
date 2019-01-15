package edu.sbcc.cs105;

import sbccutils.*;
/*
 * Gray Scale filter will take the input image and make it a gray scale image by implementing Filterable interface and using the filter method.
 * To make a gray scale pixel you have to add R channel to the G channel and to the B channel and divide by 3. The resultant number is then put back into the R, G, and B channels.
 * */
public class GrayScale implements Filterable {
	/* filter method adjusted to convert the rgb values of each pixel
	 * @param takes a PixelArray
	 * */
	public PixelArray filter(PixelArray pic) {
		int height = pic.getHeight();
		int width = pic.getWidth(); 
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// get pixel in image;
				Pixel pixel = pic.getPixel(i, j);
				// calculate the gray value
				int gray = (pixel.r + pixel.g + pixel.b) / 3; 
				// create new pixel with gray value
				pixel.r = gray;
				pixel.g = gray;
				pixel.b = gray;
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
