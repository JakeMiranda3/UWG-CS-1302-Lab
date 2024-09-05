package edu.westga.cs1302.lab1.test.view_bill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;
import edu.westga.cs1302.lab1.view.ViewBill;

class TestGetText {

	@Test
	public void testGetTextWithNoItems() {
		Bill bill = new Bill();
		ViewBill view = new ViewBill(bill);
		String actual = "ITEMS\r\n" + "\r\n" + "SUBTOTAL - $0.0\r\n" + "TAX - $0.0\r\n" + "TIP - $0.0\r\n"
				+ "TOTAL - $0.0";
		String result = view.getText();
		assertEquals(0, bill.getBillList().size(), "Checking the size of the list with zero items added");
		assertEquals(actual, result, "Checking getText with zero items added");

	}

	@Test
	public void testGetTextWithOneItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("orange", 5.0);
		ViewBill view = new ViewBill(bill);
		bill.addItem(item1);
		String actual = "ITEMS\r\n" + "orange - 5.0\r\n" + "\r\n" + "SUBTOTAL - $5.0\r\n" + "TAX - $0.5\r\n"
				+ "TIP - $1.0\r\n" + "TOTAL - $6.5";
		String result = view.getText();
		assertEquals(1, bill.getBillList().size(), "Checking the size of the list with one item added");
		assertEquals(actual, result, "Checking getText with one item added");

	}

	@Test
	public void testGetTextWithItemHavingMoreThanTwoDecimals() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("orange", 5.333);
		// The price point of this also checks the Math.round method.
		ViewBill view = new ViewBill(bill);
		bill.addItem(item1);
		String actual = "ITEMS\r\n" + "orange - 5.33\r\n" + "\r\n" + "SUBTOTAL - $5.33\r\n" + "TAX - $0.53\r\n"
				+ "TIP - $1.07\r\n" + "TOTAL - $6.93";
		String result = view.getText();
		assertEquals(1, bill.getBillList().size(), "Checking size of the list with one item added");
		assertEquals(actual, result,
				"Checking getText with one item added, and having more than two decimal values round");

	}

}
