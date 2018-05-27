package ui;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import graph.Graph;
import graph.Link;
import graph.Node;

public class FileSave {
	
	private Graph graph = new Graph();
	private String extension = ".gpd";
	private Path file;
	private ArrayList<String> graphSave = new ArrayList<String>();
	private String flag;
	
	private ArrayList<String> fillFile() {
		
		for(Node n : graph.getHashMap().values()) {
				graphSave.add(n.getName() + "," + n.getX() + "," + n.getY() + "," + n.getWeight() + ";");
		}
		
		for(Node n : graph.getHashMap().values()) {
			for(Link l : n.getLinks()) {
				if(l.isTwoWay()) {
					flag = "T";
				}else {
					flag = "F";
				}
				graphSave.add(n.getName() + "," + l.getTo().getName() + 
						"," + l.getLength() + "," + l.getType() + "," + flag + ";");
			}
		}
		return graphSave;
	}
	
	public void createFile(String file) {
		this.file = Paths.get(file + extension);
		try {
			Files.write(this.file, fillFile(), Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
