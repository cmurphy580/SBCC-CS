package edu.sbcc.cs105;
import java.util.ArrayList;
public class Invoice {
	ArrayList<Item> items = new ArrayList<Item>();
	boolean isDiscount=false;
	public void add(Item anItem) {
		items.add(anItem);
	}
	public double getDiscount() {
		double discount = 0.0;
		int i = 0;
		int q = 0;
		
		while( i < items.size()) {
			q++;
			if (items.get(i).getIsPet()==false) {
				discount += items.get(i).getPrice() * items.get(i).getQuantity();
			}
			else {
				isDiscount = true;
			}
			i++;
		}
		
		if(q >= 3 && isDiscount) {
			discount = discount*.2;
			return discount;
		}
		return 0.0;
	}

}
