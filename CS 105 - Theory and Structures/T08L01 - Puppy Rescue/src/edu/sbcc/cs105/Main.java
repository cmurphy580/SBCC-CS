package edu.sbcc.cs105;

public class Main {

	public static void main(String[] args) {
		Item i1 = new Item(2.00, false, 4);
		Item i2 = new Item(5.00, true, 4);
		Item i3 = new Item(10.00, false, 2);
		Item i4 = new Item(1.00, false, 10);
		Item i5 = new Item(5.00, true, 6);
		Invoice items = new Invoice();
		items.add(i1);
		items.add(i2);
		items.add(i3);
		items.add(i4);
		items.add(i5);
		System.out.println(items.getDiscount());
	}

}
