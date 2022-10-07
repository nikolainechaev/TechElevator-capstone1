package com.techelevator;

import java.util.Map;

public class VendingMachineCLI {


	public VendingMachineCLI() {
	}

	public void run() {

		ItemStock i = new ItemStock();
		Map<Sellable,Integer> items;

		items = i.getItems();

		MainMenu m = new MainMenu(items);
		m.displayMainMenu();

	}

	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}
}
