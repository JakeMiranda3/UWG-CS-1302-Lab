package edu.westga.cs1302.lab1.view;

import java.util.ArrayList;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;

/**
 * Gets the Bills text into a string and returns it
 * 
 * @author Jake Miranda
 * @version Fall 2024
 */
public class ViewBill {
	private ArrayList<BillItem> items;

	/**
	 * creates a new empty list
	 *
	 * @param bill the bill list
	 */
	public ViewBill(Bill bill) {
		this.items = bill.getBillList();

	}

	/**
	 * Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public String getText() {

		String text = "ITEMS" + System.lineSeparator();
		double subTotal = 0.0;
		for (BillItem item : this.items) {
			text += item.getName() + " - " + Math.round(item.getAmount() * 100.00) / 100.00 + System.lineSeparator();
			subTotal += item.getAmount();
		}

		text += System.lineSeparator();
		text += "SUBTOTAL - $" + Math.round(subTotal * 100.00) / 100.00 + System.lineSeparator();
		double tax = subTotal * Bill.TAX_PERCENTAGE;
		double tip = subTotal * Bill.TIP_PERCENTAGE;
		text += "TAX - $" + Math.round(tax * 100.00) / 100.00 + System.lineSeparator();
		text += "TIP - $" + Math.round(tip * 100.00) / 100.00 + System.lineSeparator();
		subTotal += tip + tax;
		text += "TOTAL - $" + Math.round(subTotal * 100.00) / 100.00;

		return text;
	}

}
