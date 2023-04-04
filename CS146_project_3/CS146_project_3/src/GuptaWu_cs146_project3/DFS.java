package GuptaWu_cs146_project3;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DFS 
{
	private ArrayList<Vertex> path; //solution path of vertices
	private ArrayList<Vertex> visitedVertices; //order in which vertices were visited
	private int pathLength; 	//length of solution path
	private int numVisitedCell; //number of visited cells
	
	/**
	 * constructor for DFS
	 */
	public DFS()
	{
		path = new ArrayList<>();
		visitedVertices = new ArrayList<>();
		pathLength = 0;
		numVisitedCell = 0;
	}
	
	//getters and setters
	public ArrayList<Vertex> getPath() {
		return path;
	}
	public void setPath(ArrayList<Vertex> path) {
		this.path = path;
	}
	public int getPathLength() {
		return pathLength;
	}
	public void setPathLength(int pathLength) {
		this.pathLength = pathLength;
	}
	public int getNumVisitedCell() {
		return numVisitedCell;
	}
	public void setNumVisitedCell(int visitedCell) {
		this.numVisitedCell = visitedCell;
	}
	
	 //print the coordinates of the vertices in the path 
    public String printPath()
    {
    	String s = "";
    	System.out.print("Path: \n");
    	for(int i = 0; i < path.size(); i++)
    	{
    		System.out.print("(" + path.get(i).getX() + "," + path.get(i).getY() + ") ");
    		s= s + "(" + path.get(i).getX() + "," + path.get(i).getY() + ") ";
    	}
    	return s;
    }

	/**
	 * method to help solve maze with the DFS
	 * @param graph
	 * @param size
	 */
	public void solveWithDFS(ArrayList<Vertex> graph, int size)
	{
		for(int i = 0; i < size*size; i++) //go through and make all vertices
		{                                  //initialized to setVisited false, all parent as null and initialize visit order to -1
			graph.get(i).setVisited(false);
			graph.get(i).setParent(null);
			graph.get(i).setVisitedOrder(-1);
		}
		Vertex startVertex = graph.get(0);        //entry vertex
		Vertex endingVertex = graph.get((size*size)-1);   //exit vertex
		
		Stack<Vertex> stack = new Stack<>();   //empty stack
		
		int visitOrder = 0;    //integer to represent order of current vertex visited in
	
		stack.push(startVertex);  //push first vertex onto stack
		
		while(stack.isEmpty()==false)
		{
			Vertex current = stack.pop();
			
			if(!current.isVisited()) //if cell has not been visited yet
			{
				current.setVisited(true);  //cell has now been visited
				current.setVisitedOrder(visitOrder); //sets set visited order of current vertex
				visitedVertices.add(current); //add the visited vertices to the visitedVertices array list
				visitOrder++; //add to visited order for next number
				if(visitOrder >= 10)	//if visit order reaches 10, restart from 0
				{
					visitOrder = 0;
				}
			}
			
			if(current.equals(endingVertex)) //if it reaches exit, stop.
			{
				break;
			}
			
			for(int i = 0; i < current.getEdges().size(); i++) //traverse through neighbors list of current vertex 
			{
				if(!current.getEdges().get(i).isVisited())  //if the neighbor vertex has been visited yet
				{
					stack.push(current.getEdges().get(i)); //push this neighbor vertex to stack
					current.getEdges().get(i).setParent(current); //set current vertex as parent of the neighbor(the vertex before the next)
				}
			}
		}
		
		numVisitedCell = visitedVertices.size();
		
		Vertex temp = endingVertex; //start from the exit vertex
		while(temp != null) //add vertices to path array list using the get parent (it adds into list backwards) until we get to the start
		{
			path.add(temp);
			temp = temp.getParent();
		}
		Collections.reverse(path); //reverse list so order it is from entry to exit
		this.pathLength = path.size();
	}
	
	/**
	 * print solution path
	 * @param cells
	 * @param size
	 */
	public void printHashDFS(Cell[][] cells, int size)
    {
        cells[0][0].setNorth(false);   //we know entrance is always left,topmost cell.
        cells[size-1][size-1].setSouth(false); //we know exit is always right, bottom most cell
        String maze="";

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {	//for the - of north and south walls

                if (cells[i][j].isNorth() == true) { 		//if north wall exists
                    if (j == cells[0].length - 1){			//if end of the row
                        System.out.println("+-+");  	
                        maze = maze + "+-+\n";
                    }else{								//if not the end of row
                        System.out.print("+-"); 	
                        maze = maze + "+-";
                    }
                } 
                else{								//if north wall doesn't exist, print without dash
                    if (j == cells[0].length - 1){ 								
                        System.out.println("+ +");
                        maze = maze + "+ +\n";
                    }else{									
                        System.out.print("+ ");
                        maze = maze + "+ ";
                    }
                }
            }

            for (int j = 0; j < size; j++) {			//for the | in the grid for east and west walls
                if (cells[i][j].isWest() == true){		//if west wall exists
                	if(!isInPath(i, j)){				//if there no vertex in the path for current i and j, then just print grid
                		if (j == cells[0].length - 1){ 		 //if end of the row			
                			System.out.println("| |");
                			maze = maze + "| |\n";
                		} else{									
                			System.out.print("| ");
                			maze = maze + "| ";
                		}
                	}
                	else{								//if in path, then add hashtag
                		if (j == cells[0].length - 1){ 										
                			System.out.println("|#|");
                			maze = maze + "|#|\n";
                		} else{										
                			System.out.print("|#");
                			maze = maze + "|#";
                		}
                	}
                } 
                else 								//if west wall doesn't exist
                {	
                	if(!isInPath(i, j)){										
                		if (j == cells[0].length - 1){ 											
                			System.out.println("  |");
                			maze = maze + "  |\n";
                		} else {										
                			System.out.print("  ");
                			maze = maze + "  ";
                		}
                	}
                	else
                	{
                		if (j == cells[0].length - 1) { 											
                			System.out.println(" #|");
                			maze = maze + " #|\n";
                		} else{										
                			System.out.print(" #");
                			maze = maze + " #";
                		}
                	}
                }
            }
        }
        //print out bottom of maze
        for (int i = 0; i < size; i++) {
            if (cells[i][size-1].isSouth() == true) {
                if (i == cells[0].length - 1) {
                    System.out.println("+-+");
                    maze = maze + "+-+\n";
                } else {
                    System.out.print("+-");
                    maze = maze + "+-";
                }
            } else if (i == cells[0].length - 1) {
                System.out.println("+ +");
                maze = maze + "+ +\n";
            } else {
                System.out.print("+-");
                maze = maze + "+-";
            }
        }
        try {
			FileWriter fileWriter = new FileWriter("Output.txt", true);
			BufferedWriter buff = new BufferedWriter(fileWriter);
			buff.write("DFS: Solution" + "\n");
			buff.write(maze);
			buff.write("Path: ");
			String s = printPath();
			buff.write(s);
			buff.write("\nLength of path: " + getPathLength());
			buff.write("\nVisited Cell: " + getNumVisitedCell() + "\n");
			buff.newLine();
			buff.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
    }

	/**
	 * checks whether a vertex is in the path
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isInPath(int x, int y) 
	{
		for(int i = 0; i < path.size(); i++)
		{
			if(path.get(i).getX() == x && path.get(i).getY() == y)
			{
				return true;
			}
		}
		return false;
	}
	
	
	public void printCellWithVisitedOrder(Cell[][] cells, int size)
    {
        cells[0][0].setNorth(false);   //we know entrance is always left,topmost cell.
        cells[size-1][size-1].setSouth(false); //we know exit is always right, bottom most cell
        String maze="";

        for (int i = 0; i < size; i++) {		
            for (int j = 0; j < size; j++) {				//for the - of north and south walls
                if (cells[i][j].isNorth() == true) { 		//if north wall exists
                    if (j == cells[0].length - 1){			//if end of the row
                        System.out.println("+-+");  	
                        maze = maze + "+-+\n";
                    }else{								//if not the end of row
                        System.out.print("+-"); 	
                        maze = maze + "+-";
                    }
                } 
                else{								//if north wall doesn't exist, print without dash
                    if (j == cells[0].length - 1){ 								
                        System.out.println("+ +");
                        maze = maze + "+ +\n";
                    }else{									
                        System.out.print("+ ");
                        maze = maze + "+ ";
                    }
                }
            }

            for (int j = 0; j < size; j++) {			//for the | in the grid for east and west walls
            	
            	int order = getOrder(i, j);
                if (cells[i][j].isWest() == true){
                	if(order == -1){					//if vertex is not visited then just print the grid
                		if (j == cells[0].length - 1){ 					
                			System.out.println("| |");
                			maze = maze + "| |\n";
                		} else{									
                			System.out.print("| ");
                			maze = maze + "| ";
                		}
                	}
                	else{								//if  vertex is visited, print its visited order with the grid
                		if (j == cells[0].length - 1){ 										
                			System.out.println("|"+order+"|");
                			maze = maze + "|"+order+"|\n";
                		} else{										
                			System.out.print("|"+order);
                			maze = maze + "|"+order;
                		}
                	}
                } 
                else 								 //if west wall doesn't exist'
                {	
                	if(order == -1){										
                		if (j == cells[0].length - 1){ 											
                			System.out.println("  |");
                			maze = maze + "  |\n";
                		} else {										
                			System.out.print("  ");
                			maze = maze + "  ";
                		}
                	}
                	else
                	{
                		if (j == cells[0].length - 1) { 											
                			System.out.println(" "+order+"|");
                			maze = maze + " "+order+"|\n";
                		} else{										
                			System.out.print(" "+order);
                			maze = maze + " "+order;
                		}
                	}
                }
            }
        }
        //print out bottom of maze
        for (int i = 0; i < size; i++) {
            if (cells[i][size-1].isSouth() == true) {
                if (i == cells[0].length - 1) {
                    System.out.println("+-+");
                    maze = maze + "+-+\n";
                } else {
                    System.out.print("+-");
                    maze = maze + "+-";
                }
            } else if (i == cells[0].length - 1) {
                System.out.println("+ +");
                maze = maze + "+ +\n";
            } else {
                System.out.print("+-");
                maze = maze + "+-";
            }
        }
        try {
			FileWriter fileWriter = new FileWriter("Output.txt", true);
			BufferedWriter buff = new BufferedWriter(fileWriter);
			buff.write("DFS: Visited order " + "\n");
			buff.write(maze);
			buff.newLine();
			buff.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
    }
	
	/**
	 * get visited order of a visited vertices
	 * @param x
	 * @param y
	 * @return an integer to present the visited order of a visited vertex 
	 * 			return -1 if the vertex never visited
	 */
	private int getOrder(int x, int y)
	{
		for(int i = 0; i < visitedVertices.size(); i++)
		{
			if(visitedVertices.get(i).getX() == x && visitedVertices.get(i).getY() == y)
			{
				return visitedVertices.get(i).getVisitedOrder();
			}
		}
		return -1;
	}
}
