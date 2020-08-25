package com.aliceronascimento.model;

public class Report {
	
	private int numOfClients;
	private int numOfSalesman;
	private String mostExpensiveSaleId;
	private String worstSalesman;
	private String fileName;
		
	public Report(String fileName) {
		this.fileName = fileName;
	}

	public int getNumOfClients() {
		return this.numOfClients;
	}

	public int getNumOfSalesman() {
		return this.numOfSalesman;
	}

	public String getMostExpensiveSaleId() {
		return mostExpensiveSaleId;
	}

	public String getWorstSalesman() {
		return worstSalesman;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setMostExpensiveSaleId(String mostExpensiveSaleId) {
		this.mostExpensiveSaleId = mostExpensiveSaleId;
	}

	public void setWorstSalesman(String worstSalesman) {
		this.worstSalesman = worstSalesman;
	}

	public void setNumOfClients(int numOfClients) {
		this.numOfClients = numOfClients;
	}

	public void setNumOfSalesman(int numOfSalesman) {
		this.numOfSalesman = numOfSalesman;
	}

	@Override
	public String toString() {
		return "Report [Total of clients: " + numOfClients + ", Number of salesman: " + numOfSalesman
				+ ", Most expensive sale Id: " + mostExpensiveSaleId + ", Worst salesman: " + worstSalesman + "]";
	}
}
