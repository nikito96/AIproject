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
	
	private void addRoute(Node from, Node to, double length, LinkType lt, boolean isTwoWay) {
		Link link = new Link(to, length, lt, isTwoWay);
		from.getLinks().add(link);
	}
	
	public void addTwoWayRoute(Node from, Node to, double length, LinkType lt, boolean isTwoWay) {
		addRoute(from, to, length, lt, isTwoWay);
		if(isTwoWay)
			addRoute(to, from, length, lt, isTwoWay);
	}
	
	public void setDepth(Node n) {
		for(Link l : n.getLinks()) {
			if(l.getTo().depth == -1)
				l.getTo().depth = n.depth + 1;
		}
	}
	
	public void graphReset() {
		for(Node n : graph.values()) {
			n.resetNode();
		}
	}
}
