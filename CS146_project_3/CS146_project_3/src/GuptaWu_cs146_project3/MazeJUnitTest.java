package GuptaWu_cs146_project3;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

//junit test to test different input size
public class MazeJUnitTest 
{
	@Test
	public void TestSize4()
	{
		System.out.print("Maze of size 4X4 \n"); 
		 GenerateRandomMaze x=new GenerateRandomMaze(4);
	     x.generateMaze();
	     Cell[][] y=x.getCells();
	     x.printMaze();

	     Graph maze=new Graph();
	     maze.generateGraph(y,4);
	     ArrayList<Vertex> list=maze.getArrayList();

	     //check dfs
	     System.out.println("\nDFS"); 
	     DFS dfs=new DFS();
	     dfs.solveWithDFS(list, 4);
		 dfs.printCellWithVisitedOrder(y, 4);
		 System.out.println("");
        dfs.printHashDFS(y,4);
        System.out.println("");
       //dfs.printPath();
        
        assertEquals(7, dfs.getPathLength());  //check path length
        assertEquals(7, dfs.getNumVisitedCell());  //check number of visited cells
        
        System.out.println("Length of path: " + dfs.getPathLength());
        System.out.println("Visited cell: " + dfs.getNumVisitedCell());
       
        //check bfs
        System.out.println("\n\nBFS");
        BFS bfs=new BFS();
        bfs.solveWithBFS(list, 4);
        bfs.printCellWithVisitedOrder(y, 4);
        System.out.println("");
        bfs.printHashBFS(y,4);
        System.out.println("");
        //bfs.printPath();
        
        assertEquals(7, bfs.getPathLength());	//check path length
        assertEquals(8, bfs.getNumVisitedCell());//check number of visited cells
        
        System.out.println("Length of path: " + bfs.getPathLength());
        System.out.println("Visited cell: " + bfs.getNumVisitedCell() + "\n\n");
	}
	
	@Test
	public void TestSize6()
	{
		 System.out.print("Maze of size 6X6 \n"); 
		 GenerateRandomMaze x=new GenerateRandomMaze(6);
	     x.generateMaze();
	     Cell[][] y=x.getCells();
	     x.printMaze();

	     Graph maze=new Graph();
	     maze.generateGraph(y,6);
	     ArrayList<Vertex> list=maze.getArrayList();

	     //check dfs
	     System.out.println("\nDFS"); 
	     DFS dfs=new DFS();
	     dfs.solveWithDFS(list, 6);
		 dfs.printCellWithVisitedOrder(y, 6);
		 System.out.println("");
         dfs.printHashDFS(y,6);
         System.out.println("");
        //dfs.printPath();
         
         assertEquals(29, dfs.getPathLength());     //check path length
         assertEquals(32, dfs.getNumVisitedCell());//check number of visited cells
         
         System.out.println("Length of path: " + dfs.getPathLength());
         System.out.println("Visited cell: " + dfs.getNumVisitedCell());
        
         //check bfs
         System.out.println("\n\nBFS");
         BFS bfs=new BFS();
         bfs.solveWithBFS(list, 6);
         bfs.printCellWithVisitedOrder(y, 6);
         System.out.println("");
         bfs.printHashBFS(y,6);
         System.out.println("");
         //bfs.printPath();
         
         assertEquals(29, bfs.getPathLength()); //check path length
         assertEquals(36, bfs.getNumVisitedCell());//check number of visited cells
         
         System.out.println("Length of path: " + bfs.getPathLength());
         System.out.println("Visited cell: " + bfs.getNumVisitedCell()+"\n\n");
	}
	
	@Test
	public void TestSize8()
	{
		System.out.print("Maze of size 8X8 \n"); 
		 GenerateRandomMaze x=new GenerateRandomMaze(8);
	     x.generateMaze();
	     Cell[][] y=x.getCells();
	     x.printMaze();

	     Graph maze=new Graph();
	     maze.generateGraph(y,8);
	     ArrayList<Vertex> list=maze.getArrayList();

	     //check dfs
	     System.out.println("\nDFS"); 
	     DFS dfs=new DFS();
	     dfs.solveWithDFS(list, 8);
		 dfs.printCellWithVisitedOrder(y, 8);
		 System.out.println("");
        dfs.printHashDFS(y,8);
        System.out.println("");
       //dfs.printPath();
        
        assertEquals(33, dfs.getPathLength());  //check path length
        assertEquals(36, dfs.getNumVisitedCell());  //check number of visited cells
        
        System.out.println("Length of path: " + dfs.getPathLength());
        System.out.println("Visited cell: " + dfs.getNumVisitedCell());
       
        //check bfs
        System.out.println("\n\nBFS");
        BFS bfs=new BFS();
        bfs.solveWithBFS(list, 8);
        bfs.printCellWithVisitedOrder(y, 8);
        System.out.println("");
        bfs.printHashBFS(y,8);
        System.out.println("");
        //bfs.printPath();
        
        assertEquals(33, bfs.getPathLength());	//check path length
        assertEquals(48, bfs.getNumVisitedCell());//check number of visited cells
        
        System.out.println("Length of path: " + bfs.getPathLength());
        System.out.println("Visited cell: " + bfs.getNumVisitedCell() + "\n\n");
	}
	
	@Test
	public void TestSize10()
	{
		System.out.print("Maze of size 10X10 \n"); 
		 GenerateRandomMaze x=new GenerateRandomMaze(10);
	     x.generateMaze();
	     Cell[][] y=x.getCells();
	     x.printMaze();

	     Graph maze=new Graph();
	     maze.generateGraph(y,10);
	     ArrayList<Vertex> list=maze.getArrayList();

	     //check dfs
	     System.out.println("\nDFS"); 
	     DFS dfs=new DFS();
	     dfs.solveWithDFS(list, 10);
		 dfs.printCellWithVisitedOrder(y, 10);
		 System.out.println("");
        dfs.printHashDFS(y,10);
        System.out.println("");
       //dfs.printPath();
        
        assertEquals(57, dfs.getPathLength());  //check path length
        assertEquals(60, dfs.getNumVisitedCell());  //check number of visited cells
        
        System.out.println("Length of path: " + dfs.getPathLength());
        System.out.println("Visited cell: " + dfs.getNumVisitedCell());
       
        //check bfs
        System.out.println("\n\nBFS");
        BFS bfs=new BFS();
        bfs.solveWithBFS(list, 10);
        bfs.printCellWithVisitedOrder(y, 10);
        System.out.println("");
        bfs.printHashBFS(y,10);
        System.out.println("");
        //bfs.printPath();
        
        assertEquals(57, bfs.getPathLength());	//check path length
        assertEquals(73, bfs.getNumVisitedCell());//check number of visited cells
        
        System.out.println("Length of path: " + bfs.getPathLength());
        System.out.println("Visited cell: " + bfs.getNumVisitedCell() + "\n\n");
	}
	
	@Test
	public void TestSize20()
	{
		System.out.print("Maze of size 20X20 \n"); 
		 GenerateRandomMaze x=new GenerateRandomMaze(20);
	     x.generateMaze();
	     Cell[][] y=x.getCells();
	     x.printMaze();

	     Graph maze=new Graph();
	     maze.generateGraph(y,20);
	     ArrayList<Vertex> list=maze.getArrayList();

	     //check dfs
	     System.out.println("\nDFS"); 
	     DFS dfs=new DFS();
	     dfs.solveWithDFS(list, 20);
		 dfs.printCellWithVisitedOrder(y, 20);
		 System.out.println("");
        dfs.printHashDFS(y,20);
        System.out.println("");
       //dfs.printPath();
        
        assertEquals(221, dfs.getPathLength());  //check path length
        assertEquals(230, dfs.getNumVisitedCell());  //check number of visited cells
        
        System.out.println("Length of path: " + dfs.getPathLength());
        System.out.println("Visited cell: " + dfs.getNumVisitedCell());
       
        //check bfs
        System.out.println("\n\nBFS");
        BFS bfs=new BFS();
        bfs.solveWithBFS(list, 20);
        bfs.printCellWithVisitedOrder(y, 20);
        System.out.println("");
        bfs.printHashBFS(y,20);
        System.out.println("");
        //bfs.printPath();
        
        assertEquals(221, bfs.getPathLength());	//check path length
        assertEquals(352, bfs.getNumVisitedCell());//check number of visited cells
        
        System.out.println("Length of path: " + bfs.getPathLength());
        System.out.println("Visited cell: " + bfs.getNumVisitedCell() + "\n\n");
	}
}
