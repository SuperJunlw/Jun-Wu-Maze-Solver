package GuptaWu_cs146_project3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/*
 * create a CellStack (LIFO) to hold a list of cell locations 
	set TotalCells= number of cells in grid 
	choose the starting cell and call it CurrentCell 
	set VisitedCells = 1 
	while VisitedCells < TotalCells 
		find all neighbors of CurrentCell with all walls intact 
		if one or more found choose one at random 
		knock down the wall between it and CurrentCell 
		push CurrentCell location on the CellStack 
		make the new cell CurrentCell 
		add 1 to VisitedCells 
		else 
	pop the most recent cell entry off the CellStack 
	make it CurrentCell 

 */

public class GenerateRandomMaze 
{
	private int size;  //size of each row and each column
	private Cell[][] cells; //2d array to hold cell object and represent maze


	/**
	 *  constructor that initializes grid for the maze.
	 */
	public GenerateRandomMaze(int size)
	{
		this.size = size;
		cells = new Cell[size][size];
		
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				cells[i][j] = new Cell(i, j);
			}
		}
	}
	
	/**
	 *
	 * @return cells that represent maze
	 */
	public Cell[][] getCells() {
		return cells;
	}

	/**
	 * generates the random maze, edits the grid so that some "walls are broken"
	 */
	public void generateMaze()
	{
		Stack<Cell> cellStack= new Stack<Cell>();  //initialize stack to hold maze
		int totalCells= size * size;

		
		Cell currentCell= cells[0][0]; //start at left, topmost cell
		
		int visitedCells=1; //start the counter of visited cells at one since first cell is already visited
		Random r = new Random(20); //using seed so same maze generated each time
		
		while (visitedCells < totalCells)
		{
		
			ArrayList<Cell> neighbors= new ArrayList<Cell>();
			
			neighbors= findNeighbors(currentCell); //assign all neighbor cells that are intact of current cell in neighbors arraylist
			int neighborSize=neighbors.size();
			
			if(neighborSize > 0)
			{
				int random = r.nextInt(neighborSize);
				Cell temp=neighbors.get(random); //get one of the random neighbor cells to break
				
				if(temp.getY() < currentCell.getY()) // if the random cell is to the west of current cell, 										
				{									//then break current cell's west wall and random cell's east wall
					currentCell.setWest(false);
					temp.setEast(false);
				}
				if(temp.getY() > currentCell.getY()) // if the random cell is to the east of current cell, 									
				{									//	then break current cell's east wall and random cell's west wall
					currentCell.setEast(false);
					temp.setWest(false);
				}
				if(temp.getX() > currentCell.getX()) // if the random cell is to the south of current cell, 
				{									//then break current cell's south wall and random cell's north wall
					currentCell.setSouth(false);
					temp.setNorth(false);
				}
				if(temp.getX() < currentCell.getX()) // if the random cell is to the north of current cell, 					
				{									//then break current cell's north wall and random cell's south wall
					currentCell.setNorth(false);
					temp.setSouth(false);
				}
				cellStack.push(currentCell);	//push current cell to stack
				currentCell=temp;
				visitedCells++;
			}	
			else
			{
				currentCell = cellStack.pop(); //if  no neighbor cells then move to next cell
			}
		}
	}
	
	/**
	 * finds the fully intact east, west, south, and north cells of the cell passed in
	 * @param currentCell
	 * @return an arraylist of neighbor cells
	 */
	public ArrayList<Cell> findNeighbors(Cell currentCell)
	{
	 	ArrayList<Cell> neighborCells= new ArrayList<Cell>(); //arraylist to hold all neighbors of current cell
	 	
		if(currentCell.getY() -1 >= 0  )	//if current cell's west is not end of the maze
		{
			Cell westCell= cells[currentCell.getX()][currentCell.getY()-1];
			if(westCell.isIntact())		//if west cell has all the wall intact, add to the neighbor
			{
				neighborCells.add(westCell);
			}
		}
		if(currentCell.getY() + 1 <= size -1  )	//if current cell's east is not end of the maze
		{
			Cell eastCell= cells[currentCell.getX()][currentCell.getY()+1];
			if(eastCell.isIntact())		//if east cell has all the wall intact, add to the neighbor
			{
				neighborCells.add(eastCell);
			}
		}
		if(currentCell.getX() -1 >= 0)		//if current cell's north is not end of the maze
		{
			Cell northCell= cells[currentCell.getX()-1][currentCell.getY()];
			if(northCell.isIntact())	//if north cell has all the wall intact, add to the neighbor
			{
				neighborCells.add(northCell);
			}
		}
		if(currentCell.getX() +1 <= size -1)	//if current cell's south is not end of the maze
		{
			Cell southCell= cells[currentCell.getX()+1][currentCell.getY()];
			if(southCell.isIntact())	//if south cell has all the wall intact, add to the neighbor
			{
				neighborCells.add(southCell);
			}
	}

		return neighborCells;
	}	

	public void printMaze()
	{
		cells[0][0].setNorth(false);   //we know entrance is always left,topmost cell.
		cells[size-1][size-1].setSouth(false); //we know exit is always right, bottom most cell
		String maze="";

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				if (cells[i][j].isNorth() == true) { // checks for north wall
					if (j == cells[0].length - 1) {
						System.out.println("+-+");  //if it reaches end of the row
						maze = maze + "+-+\n";
					} else {
						System.out.print("+-"); //if it has not reached end of row
						maze = maze + "+-";
					}
				} else //if no north wall
				{
					if (j == cells[0].length - 1) { //if there is no north wall print out opening at the end of row
						System.out.println("+ +");
						maze = maze + "+ +\n";
					} else {//if not the end of the row
						System.out.print("+ ");
						maze = maze + "+ ";
					}
				}
			}

			for (int j = 0; j < size; j++) {
				if (cells[i][j].isWest() == true) { //checks for west wall
					if (j == cells[0].length - 1) { //if end of the row
						System.out.println("| |");
						maze = maze + "| |\n";
					} else {//if not the end of the row and west wall exists
						System.out.print("| ");
						maze = maze + "| ";
					}
				} else {//if no west wall
					if (j == cells[0].length - 1) { //if end of row
						System.out.println("  |");
						maze = maze + "  |\n";
					} else {//if not the end of the row
						System.out.print("  ");
						maze = maze + "  ";
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
			FileWriter fileWriter = new FileWriter("Output.txt");
			BufferedWriter buff = new BufferedWriter(fileWriter);
			buff.write("Maze of size " + this.size + "\n");
			buff.write(maze);
			buff.newLine();
			buff.flush();
			buff.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

