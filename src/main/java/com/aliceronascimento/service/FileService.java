package com.aliceronascimento.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.aliceronascimento.dao.FileDao;
import com.aliceronascimento.exceptions.FolderNotFound;
import com.aliceronascimento.exceptions.InvalidIdExpection;
import com.aliceronascimento.model.Client;
import com.aliceronascimento.model.Item;
import com.aliceronascimento.model.Report;
import com.aliceronascimento.model.Sale;
import com.aliceronascimento.model.Salesman;

public class FileService {
	
	private FileDao dao;
	private Report report;
	private ListTemplate list;
	private static final String filePath = "/home/data/in/";

	public FileService() {
		this.dao =  new FileDao();
	}
	
	public List<String> getFilesFromFolder() {
		try {
			Stream<Path> walkFiles = Files.walk(Paths.get(filePath));
			return walkFiles.filter(Files::isRegularFile).map(m -> m.toString()).collect(Collectors.toList());
		} catch (Exception e) {
			throw new FolderNotFound("Error when trying to find files!");
		}		
	}
	
	public void executeReport() {
		
		for(String files : getFilesFromFolder()) {
			String[] pathDatain = files.split("/");
			String[] file = pathDatain[pathDatain.length-1].split("//.");
			
			List<String> lines = dao.readFile(files);
			report = new Report(file[0]);
			list = new ListTemplate();
			
			for(String line : lines) {
				String[] split = line.split("ç");
				if(split.length == 4) {
					verifyId(split);				
				}
			}
	
			report.setMostExpensiveSaleId(getMostExpensiveSale());	
			report.setWorstSalesman(getWorsSalesman());
			dao.writeFile(report);
		}
	}
		
	public void verifyId(String[] line) {
		switch(line[0]) {
		case "001":
			list.addSalesman(new Salesman(line[1], line[2], line[3]));
			report.setNumOfSalesman(list.getSalesman().size());
			break;
		
		case "002":
			list.addClients(new Client(line[1], line[2], line[3]));
			report.setNumOfClients(list.getClients().size());
			break;
		
		case "003":
			Salesman salesman = list.getSalesman().stream().filter(s -> s.getName().equals(line[3])).findFirst().orElse(null);
			
			Sale saleInfo = new Sale(line[1], salesman);
			String[] items = line[2].replaceAll("\\[|\\]", "").split(",");

			for(int i = 0; i < items.length ; i++) {
				String[] item = items[i].split("-");

				saleInfo.addItem(new Item(item[0], item[1], item[2]));
			}
			list.addSales(saleInfo);
			break;
						
		default:
			throw new InvalidIdExpection("Id invalid!");
		}	
	}
	
	public String getMostExpensiveSale() {
		return list.getSales().stream().reduce((actual, next) -> actual.getTotalSales() > next.getTotalSales() ? actual : next).get().getSalesId();
	}
	
	public String getWorsSalesman() {
		return list.getSalesman().stream().reduce((actual, next) -> sumSalesBySalesman(actual.getName()) < sumSalesBySalesman(next.getName()) ? actual: next).get().getName(); 
	}
	
	public double sumSalesBySalesman(String salesman){
		double sum = 0;

		for(Sale sale : list.getSales()){
			if(sale.getSalesmanName().equals(salesman)){
				sum += sale.getTotalSales();
			}
		}
		return sum;
	}
}
