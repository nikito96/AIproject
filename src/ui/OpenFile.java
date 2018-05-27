package ui;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import graph.Graph;

public class OpenFile {
	
	private Graph graph = new Graph();
	
	private static List<String> readFileInList(String fileName){
		List<String> lines = Collections.emptyList();
		
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}
	
	public void openFile(String fileName) {
		List list = readFileInList(fileName);
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			
		}
	}
}
