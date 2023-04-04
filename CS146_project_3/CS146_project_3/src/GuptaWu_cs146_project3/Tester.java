package GuptaWu_cs146_project3;
import java.util.ArrayList;

public class Tester {

	//main method to test one input size for maze
	public static void main (String [] args)
    {
        GenerateRandomMaze x=new GenerateRandomMaze(10);
        x.generateMaze();
        Cell[][] y=x.getCells();
        x.printMaze();

        Graph maze=new Graph();
        maze.generateGraph(y,10);
        ArrayList<Vertex> list=maze.getArrayList();

        System.out.println("");
        DFS dfs=new DFS();
       
        dfs.solveWithDFS(list, 10);
        System.out.println("\nDFS");
        dfs.printCellWithVisitedOrder(y, 10);
        System.out.println("");
        dfs.printHashDFS(y,10);
        System.out.println("\nLength of path: " + dfs.getPathLength());
        System.out.println("Visited cell: " + dfs.getNumVisitedCell() + "\n\n");
        
        System.out.println("");
        BFS bfs=new BFS();
        bfs.solveWithBFS(list, 10);
        System.out.println("\nBFS");
        bfs.printCellWithVisitedOrder(y, 10);
        System.out.println("");
       
        bfs.printHashBFS(y,10);
        System.out.println("");
        System.out.println("\nLength of path: " + bfs.getPathLength());
        System.out.println("Visited cell: " + bfs.getNumVisitedCell() + "\n\n");   
    }

}
