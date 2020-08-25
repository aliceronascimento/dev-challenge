package com.aliceronascimento.main;

import java.io.IOException;

import com.aliceronascimento.service.FileService;
import com.aliceronascimento.watcher.WatcherService;

public class Application {
	
	public static void main(String[] args) throws IOException {
		FileService service = new FileService();
		WatcherService watcherService = new WatcherService(service);
		
		service.executeReport();
		watcherService.watch();
	}
}
