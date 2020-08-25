package com.aliceronascimento.watcher;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import com.aliceronascimento.exceptions.WatcherServiceException;
import com.aliceronascimento.service.FileService;

public class WatcherService {

	private String pathDataIn = "/home/data/in/";
	private FileService service;
	private WatchService watcherService;
	
	public WatcherService(FileService service) throws IOException {
		this.service = service;
		this.watcherService = FileSystems.getDefault().newWatchService();
	}
	
	public Path watch() throws IOException {
		Path path = Paths.get(pathDataIn);

		while(true) {
			
			WatchKey key = null;
			try {
				key = path.register(watcherService, StandardWatchEventKinds.ENTRY_CREATE);
				key = watcherService.take();
				
				for (WatchEvent<?> event : key.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					
					if(kind == StandardWatchEventKinds.OVERFLOW) {
						continue;
					}
					service.executeReport();
				}
			} catch (InterruptedException e) {
				throw new WatcherServiceException("Error monitoring folder!");
			}
			key.reset();
		}
	}
}
