package ui;

import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import graph.Graph;
import graph.Node;

public class Panel extends JPanel {
	
	private static Panel instance = new Panel();
	private Graph graph = new Graph();
	
	private Panel() {}
	
	public static Panel getInstance() {
		return instance;
	}
	
	void createNode(String name, int x, int y, int weight) {
		boolean exists = false;
		for(Node n : graph.getHashMap().values()) {
			if(n.getX()==x && n.getY()==y) {
				exists = true;
				JOptionPane.showMessageDialog(this, "Coordinates already exist!");
			}
		}
		
		for(String n : graph.getHashMap().keySet()) {
			if(n.equals(name)) {
				exists = true;
				JOptionPane.showMessageDialog(this, "This name already exists!");
			}
		}
		
		if(!exists) {
			graph.addNode(new Node(name, x, y, weight));
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(Node n : graph.getHashMap().values()) {
			n.paint(g);
		}
	}
}
