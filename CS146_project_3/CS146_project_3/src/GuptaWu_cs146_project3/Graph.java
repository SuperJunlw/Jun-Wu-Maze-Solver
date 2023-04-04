package GuptaWu_cs146_project3;
import java.util.ArrayList;
import java.util.LinkedList;

public class Graph 
{
	private ArrayList<Vertex> graph; //a arrayList of vertices to represent a graph
	
	public Graph()
	{
		graph = new ArrayList<Vertex>();
	}
	
	public ArrayList<Vertex> getArrayList()
	{
		return graph;
	}

	//model the maze to a graph
	public ArrayList<Vertex> generateGraph(Cell[][] cell, int size)
	{
		Vertex[][] vertices = new Vertex[size][size];
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				//Initialize each vertex using x and y of each the cell, so vertex can represent the cell
				vertices[i][j] = new Vertex(cell[i][j].getX(), cell[i][j].getY()); 
				
				//Add each vertex to the graph
				graph.add(vertices[i][j]);
			}
		}
		
		LinkedList<Vertex> edges; // a linkedlist to store all the neighbor vertices if there is no wall between the current and neighbor vertices
		
		for(int k = 0; k < graph.size(); k++)
		{
			int x = graph.get(k).getX();  //get x and y of each vertex
			int y = graph.get(k).getY();
			edges = new LinkedList<Vertex>();  //reset the linkedlist for each for iteration
			
			
			//if the current cell don't have wall at North and it is not pass the end of the maze
			//then add the vertex at North of the current vertex to the edges list
			if(cell[x][y].isNorth() == false && x-1 >= 0)
			{
				edges.add(vertices[x-1][y]);
			}
			
			//if the current cell don't have wall at South and it is not pass the end of the maze
			//then add the vertex at South of the current vertex to the edges list
			if(cell[x][y].isSouth() == false && x+1 <= size-1)
			{
				edges.add(vertices[x+1][y]);
			}
			
			//if the current cell don't have wall at west and it is not pass the end of the maze
			//then add the vertex at west of the current vertex to the edges list
			if(cell[x][y].isWest() == false && y-1 >=0 )
			{
				edges.add(vertices[x][y-1]);
			}
			
			//if the current cell don't have wall at east and it is not pass the end of the maze
			//then add the vertex at east of the current vertex to the edges list
			if(cell[x][y].isEast() == false && y+1 <= size-1)
			{
				edges.add(vertices[x][y+1]);
			}
			
			vertices[x][y].setEdges(edges); //set edges of current vertex
		}
		return graph;
	}


	
}
