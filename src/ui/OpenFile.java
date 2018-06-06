package ui;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import graph.Graph;
import graph.LinkType;
import graph.Node;

public class OpenFile {
	
	private Graph graph = new Graph();
	private LinkType lt;
	
	private static List<String> readFileInList(String fileName){
		
		List<String> lines = Collections.emptyList();
		
		try {
			lines = Files.readAllLines(Paths.get(fileName + ".gpd"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}
	
	public void openFile(String fileName) {
		
		graph.getHashMap().clear();
		
		ArrayList<String> linesArrayList = new ArrayList<String>();
		
		List<String> list = readFileInList(fileName);
		for(int i = 0; i < list.size(); i++) {
			linesArrayList.add(list.get(i));
		}
		
		for(String s : linesArrayList) {
			int count = 0;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == ',') {
					count++;
				}
			}
			if(count == 3) {
				String[] node = s.split(",");
				
				graph.addNode(new Node(node[0], Integer.parseInt(node[1]), 
						Integer.parseInt(node[2]), Integer.parseInt(node[3].replace(";", ""))));
			}else {
				boolean flag;
				String[] link = s.split(",");
				
				if(link[4].replace(";", "").equals("T")) {
					flag = true;
				}else {
					flag = false;
				}
				
				graph.addTwoWayRoute(graph.getHashMap().get(link[0]),
						graph.getHashMap().get(link[1]), Double.parseDouble(link[2]), lt.valueOf(link[3]), flag);
			}
		}
	}
}
