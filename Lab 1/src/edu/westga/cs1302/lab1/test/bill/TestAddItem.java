package edu.westga.cs1302.lab1.test.bill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;

class TestAddItem {

	@Test
	public void testWhenAddItemIsNull() {
		Bill bill = new Bill();
		assertThrows(IllegalArgumentException.class, () -> {
			bill.addItem(null);
		});
	}

	@Test
	public void testWhenNoItemsAreAdded() {
		Bill bill = new Bill();
		int billSize = bill.getBillList().size();
		assertEquals(0, billSize, "Checks the list size, which should be zero as no items are added yet");

	}

	@Test
	public void testWhenOneItemIsAdded() {
		Bill bill = new Bill();
		BillItem orange = new BillItem("Orange", 5);
		bill.addItem(orange);
		int billSize = bill.getBillList().size();
		assertEquals(1, billSize, "Checks the list size, which should be one as one item was added");
	}

	@Test
	public void testWhenTwoItemsAreAdded() {
		Bill bill = new Bill();
		BillItem orange = new BillItem("Orange", 5);
		bill.addItem(orange);
		BillItem melon = new BillItem("Melon", 5);
		bill.addItem(melon);
		int billSize = bill.getBillList().size();
		assertEquals(2, billSize, "Checks the list size, which should be two as two items were added");
	}

}
