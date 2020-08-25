package com.aliceronascimento.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.aliceronascimento.exceptions.FileReadingException;
import com.aliceronascimento.exceptions.FileWritingException;
import com.aliceronascimento.model.Report;

public class FileDao {

	private static final String outFile = "/home/data/out/";
		
	public List<String> readFile(String path){
		try {
			return Files.readAllLines(Paths.get(path));
		} catch (Exception e) {
			throw new FileReadingException("Error in reading the data!");
		}
	}

	public void writeFile(Report report) {
		try (FileWriter fw = new FileWriter(outFile+report.getFileName()); PrintWriter pw = new PrintWriter(fw)){
	        pw.write(report.toString());
	        pw.close();
		} catch (IOException e) {
			throw new FileWritingException("Error in writing the data! ");
		}
	}
}
