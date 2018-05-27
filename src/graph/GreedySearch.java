package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class GreedySearch implements ISearch {
	
	Graph graph = new Graph();
	HashMap<String, Node> map = new HashMap<String, Node>();
	
	public GreedySearch(Graph g) {
		this.graph = g;
		map = graph.getHashMap();
	}

	@Override
	public boolean search(String from, String to) {
		graph.graphReset();
		
		if(!map.containsKey(from) || !map.containsKey(to)) {
			return false;
		}
		
		Node fromNode = map.get(from);
		fromNode.depth = 0;
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(fromNode);
		
		while(!queue.isEmpty()) {
			Node temp = queue.get(0);
			queue.remove(0);
			graph.setDepth(temp);
			
			if(temp.getName().equals(to)) {
				return true;
			}
			
			temp.setTested(true);
			
			for(Link l : temp.getLinks()) {
				if(!l.getTo().isTested() && !queue.contains(l.getTo())) {
					queue.add(l.getTo());
				}
			}
			
			
			
			temp.setExpanded(true);
		}
		return false;
	}
}
