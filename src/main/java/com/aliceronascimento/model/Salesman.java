package com.aliceronascimento.model;

public class Salesman {
	
	private String cpf;
	private String name;
	private String salary;
	
	public Salesman(String cpf, String name, String salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public String getSalary() {
		return salary;
	}
}
