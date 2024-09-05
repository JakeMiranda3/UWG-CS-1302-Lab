package edu.westga.cs1302.lab1.test.bill_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab1.model.BillItem;

class TestConstructor {

	@Test
	public void testWhenNameIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem(null, 3);
		});

	}

	@Test
	public void testWhenAmountIsLessThanZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("Orange", -1);
		});

	}

	@Test
	public void testWhenAmountIsZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			new BillItem("Orange", 0);
		});

	}

	@Test
	public void testWhenAmountIsOneCentAboveZero() {
		BillItem orange = new BillItem("Orange", 0.01);
		double price = orange.getAmount();
		assertEquals(0.01, price, "Checks the price of the orange, which should be 0.01");
	}

	@Test
	public void testWhenAmountIsADollarAboveZero() {
		BillItem orange = new BillItem("Orange", 1.00);
		double price = orange.getAmount();
		assertEquals(1.00, price, "Checks the price of the orange, which should be 1.00");
	}

	@Test
	public void testBillItemCreation() {
		BillItem orange = new BillItem("Orange", 5);
		String name = orange.getName();
		double price = orange.getAmount();
		assertEquals("Orange", name, "Checks the name of the item");
		assertEquals(5, price, "Checks the price of the item");
	}

}
