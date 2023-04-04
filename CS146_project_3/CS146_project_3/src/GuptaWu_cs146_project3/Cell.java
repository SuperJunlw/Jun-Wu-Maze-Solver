package GuptaWu_cs146_project3;
public class Cell 
{
	private int x;
	private int y;
	private boolean north; //north wall
	private boolean south; //south wall
	private boolean east; //east wall
	private boolean west; // west wall
	private boolean visited;
		
	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.north=true; //true means wall is intact (should be intact by default)
		this.south=true; //true means wall is intact (should be intact by default)
		this.east=true; //true means wall is intact (should be intact by default)
		this.west=true; //true means wall is intact (should be intact by default)
		this.visited = false; //all cells are not visited by default
	}

	/**
	 *
	 * @return x of the cell
	 */
	public int getX() {
		return x;
	}

	/**
	 *
	 * @param x set x of cell
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 *
	 * @return y of the cell
	 */
	public int getY() {
		return y;
	}

	/**
	 *
	 * @param y set y of cell
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 *
	 * @return north  if true wall is intact, false otherwise
	 */
	public boolean isNorth() {
		return north;
	}

	/**
	 * allows user to set wall as intact or not
	 * @param north
	 */
	public void setNorth(boolean north) {
		this.north = north;
	}

	/**
	 *
	 * @return south  if true wall is intact, false otherwise
	 */
	public boolean isSouth() {
		return south;
	}

	/**
	 * allows user to set wall as intact or not
	 * @param south
	 */
	public void setSouth(boolean south) {
		this.south = south;
	}

	/**
	 *
	 * @return east  if true wall is intact, false otherwise
	 */
	public boolean isEast() {
		return east;
	}

	/**
	 * allows user to set wall as intact or not
	 * @param east
	 */
	public void setEast(boolean east) {
		this.east = east;
	}

	/**
	 *
	 * @return west  if true wall is intact, false otherwise
	 */
	public boolean isWest() {
		return west;
	}

	/**
	 * allows user to set wall as intact or not
	 * @param west
	 */
	public void setWest(boolean west) {
		this.west = west;
	}

	/**
	 *
	 * @return whether cell has been visited or not
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * allows user to set whether a cell has been visited or not
	 * @param visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 *
	 * @return whether or not all 4 walls of cell are intact or not.
	 */
	public boolean isIntact()
	{
		if(north == true && south == true && west == true && east == true)
		{ 
			return true;
		}
		return false;
	}
}


