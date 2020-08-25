package com.aliceronascimento.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.aliceronascimento.dao.FileDao;
import com.aliceronascimento.exceptions.InvalidIdExpection;
import com.aliceronascimento.model.Report;
import com.aliceronascimento.service.ListTemplate;

import com.aliceronascimento.service.FileService;

@RunWith(MockitoJUnitRunner.class)
public class FileTests {
	
	@Mock
	private FileDao dao;
	
	@Mock
	private ListTemplate list;
	
	@Mock
	private Report report;
	
	@InjectMocks
	private FileService service;
	
	@Test
	public void verifyClientIdTest(){
		String[] lineClient = {"002","123456","Alice","Student"};
		service.verifyId(lineClient);
		
		Mockito.verify(list).addClients(Mockito.any());
	}
	
	@Test
	public void verifySalesmanIsTest() {
		String[] lineSalesman = {"001","123456","Alice","1000"};
		service.verifyId(lineSalesman);
		
		Mockito.verify(list).addSalesman(Mockito.any());
	}
	
	@Test
	public void verifySalesIdTest() {
		String[] lineSale = {"003","11","[1-34-10,2-33-1.50,3-40-0.10]","Pedro"};
		service.verifyId(lineSale);
		
		Mockito.verify(list).addSales(Mockito.any());
	}
	
	@Test (expected = InvalidIdExpection.class)
	public void verifyLineWithInvallidIdTest() {
		String[] invalidId = {"008","11","[1-34-10,2-33-1.50,3-40-0.10]","Pedro"};
		service.verifyId(invalidId);
	}
}
