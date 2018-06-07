package graph;

import java.util.ArrayList;

import ui.SearchFrame;

public class SearchByLength implements ISearch {

	private Graph graph = new Graph();
	private String from;
	private String to;
	private String shortestPath;
	private double shortestLength = -1;
	
	public SearchByLength(String from, String to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public boolean search(String from, String to) {
		for(Link l : getNodeFromGraph(from).getLinks()) {
			SearchFrame.resultTextArea.append("Checking: " + from + "->" + l.getTo().getName() + "->length: " + l.getLength() + "\n");
			if(l.getTo().getName().equals(to)) {
				SearchFrame.resultTextArea.append("Path found!\n");
				if(l.getLength() < shortestLength || shortestLength == -1) {
					shortestLength = l.getLength();
					shortestPath = from+"->"+to+"->";
				} 
			}else {
				ArrayList<String> passedThrough = new ArrayList<>();
				passedThrough.add(from);
				passedThrough.add(l.getTo().getName());
				double length = l.getLength();
				searchLink(passedThrough, length, l);
			}
		}
		
		if(shortestLength > 0) {
			SearchFrame.resultTextArea.append("Shortest path: " + shortestPath + "length: " + shortestLength + "\n");
			return true;
		}
		
		SearchFrame.resultTextArea.append("Path not found\n");
		return false;
	}
	
	private void searchLink(ArrayList<String> passedThrough, double length, Link link) {
		for(Link l : link.getTo().getLinks()) {
			if(!passedThrough.contains(l.getTo().getName())) {
				double newLength = length + l.getLength();
				
				ArrayList<String> newPassedThrough = passedThrough;
				
				newPassedThrough.add(l.getTo().getName());
				SearchFrame.resultTextArea.append("Checking: ");
				for(String s : passedThrough) {
					SearchFrame.resultTextArea.append(s+"->");
				}
				SearchFrame.resultTextArea.append("length: " + newLength + "\n");
				
				if(l.getTo().getName().equals(to)) {
					SearchFrame.resultTextArea.append("Path found!\n");
					if(newLength < shortestLength || shortestLength == -1) {
						shortestLength = newLength;
						shortestPath = "";
						for(String s : newPassedThrough) {
							shortestPath+=s+"->";
						}
					} 
				}else{
					searchLink(newPassedThrough, newLength, l);
				}
			}
		}
	}
	
	private Node getNodeFromGraph(String node) {
		return graph.getHashMap().get(node);
	}
}
