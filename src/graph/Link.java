package graph;

public class Link {
	
	private double length;
	private Node to;
	private LinkType type;
	private boolean isTwoWay;
	
	public Link(Node to, double length, LinkType lt, boolean isTwoWay) {
		this.to = to;
		this.length = length;
		this.type = lt;
		this.isTwoWay = isTwoWay;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double lenght) {
		this.length = lenght;
	}

	public Node getTo() {
		return to;
	}

	public void setTo(Node to) {
		this.to = to;
	}

	public LinkType getType() {
		return type;
	}

	public void setType(LinkType type) {
		this.type = type;
	}

	public boolean isTwoWay() {
		return isTwoWay;
	}
}
