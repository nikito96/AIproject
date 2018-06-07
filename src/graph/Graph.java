package graph;

import java.util.HashMap;

public class Graph {
	
	private static HashMap<String, Node> graph = new HashMap<>();
	
	public HashMap<String, Node> getHashMap(){
		return graph;
	}
	
	public void addNode(Node n) {
		graph.put(n.getName(), n);
	}
	
	public void addRoute(Node from, Node to, double length, LinkType lt, boolean isTwoWay) {
		Link link = new Link(to, length, lt, isTwoWay);
		from.getLinks().add(link);
		if(isTwoWay) {
			link = new Link(from, length, lt, isTwoWay);
			to.getLinks().add(link);
			
		}
	}
}
