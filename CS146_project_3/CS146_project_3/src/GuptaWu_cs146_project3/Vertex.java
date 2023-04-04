package GuptaWu_cs146_project3;
import java.util.LinkedList;

public class Vertex 
{
	private int x;
	private int y;
	private LinkedList<Vertex> edges;   //linkedlist to holds all the vertices that has edge with this vertex
	private boolean isVisited;
	private Vertex parent;          //Previous vertex of this vertex in the maze
	private int visitedOrder;		//the order of each vertex is visited 
	
	public Vertex(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	//getters and setters
	
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
	public LinkedList<Vertex> getEdges() {
		return edges;
	}
	public void setEdges(LinkedList<Vertex> edges) {
		this.edges = edges;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public Vertex getParent() {
		return parent;
	}
	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	public int getVisitedOrder() {
		return visitedOrder;
	}
	public void setVisitedOrder(int visitedOrder) {
		this.visitedOrder = visitedOrder;
	}
}
