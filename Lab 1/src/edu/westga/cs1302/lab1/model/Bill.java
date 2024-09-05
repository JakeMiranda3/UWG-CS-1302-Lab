package edu.westga.cs1302.lab1.model;

import java.util.ArrayList;

/**
 * Stores information for a bill.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class Bill {
	public static final double TAX_PERCENTAGE = 0.1;
	public static final double TIP_PERCENTAGE = 0.2;
	private ArrayList<BillItem> items;

	/**
	 * Create a new empty Bill
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public Bill() {
		this.items = new ArrayList<BillItem>();
	}

	/**
	 * Adds the item to the bill
	 * 
	 * @precondition item != null
	 * @postcondition item is added to the list of items in the bill
	 * 
	 * @param item the item to be added to the bill
	 */
	public void addItem(BillItem item) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null.");
		}
		this.items.add(item);
	}

	/**
	 * Gets the list of items on the Bill
	 * 
	 * @return the list of items on the Bill
	 */
	public ArrayList<BillItem> getBillList() {
		return this.items;
	}

}
