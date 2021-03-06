package graph;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Node {
	
	private String name;
	private int x;
	private int y;
	private double weight;
	
	private ArrayList<Link> links = new ArrayList<Link>();
	
	public Node(String name, int x, int y, double weight) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public ArrayList<Link> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawString(name, x * 30, y * 30);
		g.drawOval(x * 30, y  * 30, 30, 30);
		g.setColor(Color.BLUE);
		g.fillOval(x * 30, y * 30, 30, 30);
		for(Link l : links) {
			g.setColor(Color.BLACK);
			g.drawLine((this.x * 30) + 15, (this.y * 30) + 15, (l.getTo().getX() * 30) + 15, (l.getTo().getY() * 30) + 15);
		}
	}
}
