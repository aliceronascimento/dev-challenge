package com.aliceronascimento.service;

import java.util.ArrayList;
import java.util.List;

import com.aliceronascimento.model.Client;
import com.aliceronascimento.model.Sale;
import com.aliceronascimento.model.Salesman;

public class ListTemplate {
	private List<Client> listClients;
	private List<Salesman> listSalesman;
	private List<Sale> listSales;
	
	public ListTemplate() {
		this.listClients = new ArrayList<>();
		this.listSalesman = new ArrayList<>();
		this.listSales = new ArrayList<>();
	}
	
	public void addClients(Client client) {
		listClients.add(client);
		
	}
	
	public void addSalesman(Salesman salesman) {
		listSalesman.add(salesman);		
	}
	
	public void addSales(Sale sale) {
		listSales.add(sale);		
	}
	
	public List<Client> getClients(){
		return listClients;
	}
	
	public List<Salesman> getSalesman(){
		return listSalesman;
	}
	
	public List<Sale> getSales(){
		return listSales;
	}
}
