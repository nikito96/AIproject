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
		ArrayList<String> nodesArrayList = new ArrayList<String>();
		ArrayList<String> linksArrayList = new ArrayList<String>();
		
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
				nodesArrayList.add(s);
			}else {
				linksArrayList.add(s);
			}
		}
		
		for(String node : nodesArrayList) {
			String[] nodes = node.split(",");
			
			graph.addNode(new Node(nodes[0], Integer.parseInt(nodes[1]), 
					Integer.parseInt(nodes[2]), Integer.parseInt(nodes[3].replace(";", ""))));
		}
		for(String link : linksArrayList) {
			boolean flag;
			String[] links = link.split(",");
			
			if(links[4].replace(";", "").equals("T")) {
				flag = true;
			}else {
				flag = false;
			}
			
			graph.addTwoWayRoute(graph.getHashMap().get(links[0]),
					graph.getHashMap().get(links[1]), Double.parseDouble(links[2]), lt.valueOf(links[3]), flag);
		}
	}
}
