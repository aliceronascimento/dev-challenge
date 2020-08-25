package com.aliceronascimento.model;

import java.util.LinkedList;
import java.util.List;

public class Sale {
	
	private String salesId;
	private Salesman salesmanName;
	private List<Item> saleItems;
	
	public Sale(String salesId, Salesman salesmanName) {
		this.salesId = salesId;
		this.salesmanName = salesmanName;
		this.saleItems = new LinkedList<Item>();
	}
	
	public Sale(String salesId, Salesman salesmanName, List<Item> saleItems) {
		this.salesId = salesId;
		this.salesmanName = salesmanName;
		this.saleItems = saleItems;
	}

	public String getSalesId() {
		return salesId;
	}

	public String getSalesmanName() {
		return salesmanName.getName();
	}

	public List<Item> getSaleItems() {
		return saleItems;
	}
	
	public double getTotalSales() {
		double totalSales = 0;
		
		for(Item item : saleItems) {
			totalSales += item.getQuantity()*item.getPrice();
		}
		
		return totalSales;
	}
	
	public void addItem(Item item) {
		this.saleItems.add(item);
	}		
}
