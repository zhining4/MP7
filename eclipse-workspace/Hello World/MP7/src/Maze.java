import java.util.Stack;
import java.util.*;
public class Maze {
	public int height;
	public int length;
	public Cell[][] initial;
	public Maze(int height, int length) {
		this.height = height;
		this.length = length;
		setCell();
		stack = new Stack<Cell>();
		mazeGenerator();
	}
	public void setCell() {
		initial = new Cell[length][height];
		for (int x = 0; x < this.length; x++) {
			for (int y = 0; y < this.height; y++) {
				initial[x][y] = new Cell();
				if (x == 0) {
					initial[x][y].setLeft(false);
				}
				if (x == this.length - 1) {
					initial[x][y].setRight(false);
				}
				if (y == 0) {
					initial[x][y].setDown(false);
				}
				if (y == this.length - 1) {
					initial[x][y].setUp(false);
				}
				initial[x][y].setX(x);
				initial[x][y].setY(y);
			}
		}
	}
	public Stack<Cell> stack;
	public void depthFirstSearch(Cell c) {
		ArrayList<Cell> possibleNeibours = new ArrayList<Cell>();
		c.neighbours = 0;
		if (c.x + 1 < this.length && !initial[c.x + 1][c.y].isVisited) {
			c.neighbours++;
			possibleNeibours.add(initial[c.x + 1][c.y]);
		}
		if (c.x - 1 >= 0 && !initial[c.x - 1][c.y].isVisited) {
			c.neighbours++;
			possibleNeibours.add(initial[c.x - 1][c.y]);
		}
		if (c.y + 1 < this.height && !initial[c.x][c.y + 1].isVisited) {
			c.neighbours++;
			possibleNeibours.add(initial[c.x][c.y + 1]);
		}
		if (c.y - 1 >= 0 && !initial[c.x][c.y - 1].isVisited) {
			c.neighbours++;
			possibleNeibours.add(initial[c.x][c.y - 1]);
		}
		if (c.neighbours == 0) {
			if (stack.empty()) {
				;
			} else {
				depthFirstSearch(stack.pop());
			}
		} else {
			Cell next = possibleNeibours.get((int) (Math.random() * possibleNeibours.size()));
			stack.push(c);
			c.isVisited = true;
			next.isVisited = true;
			if (c.x == next.x) {
				if (c.y > next.y) {
					c.setDown(true);
					next.setUp(true);
				} else {
					c.setUp(true);
					next.setDown(true);
				}
			} else {
				if (c.x > next.x) {
					c.setLeft(true);
					next.setRight(true);
				} else {
					c.setRight(true);
					next.setLeft(true);
				}
			}
			depthFirstSearch(next);
		}
	}
	String[][] maze;
	public String toString() {
		String result = "";
		for (int y = maze[0].length - 1; y >= 0; y--) {
			for (int x = 0; x < maze.length; x++) {
				result += maze[x][y];
			}
			result += "\n";
		}
		return result;
	}
	public void mazeGenerator() {
		depthFirstSearch(initial[0][0]);
		maze = new String[2 * (initial.length) + 1][2 * (initial[0].length) + 1];
		for(int i =0; i < 2 * (initial.length) + 1; i++) {
			  for(int j = 0; j < 2 * (initial[0].length) + 1; j++) {
				  maze[i][j] = "*";
			  }
			 }
		  for(int i = 1; i < 2 * (initial.length) + 1; i+=2) {
			  for(int j = 1; j < 2 * (initial[0].length) + 1; j+=2) {
				  maze[i][j] = " ";
			  }
		  }
		  for(int i = 0; i < initial.length; i++) {
			  for(int j = 0; j < initial[0].length; j++) {
				  if(initial[i][j].up == true) {
					  maze[2 * i + 1][2 * j + 2] = " ";
				  } 
				  if (initial[i][j].down == true) {
					  maze[2 * i + 1][2 * j] = " ";
				  } 
				  if (initial[i][j].left == true) {
					  maze[2 * i][2 * j + 1] = " ";
				  } 
				  if (initial[i][j].right == true) {
					  maze[2 * i + 2][2*j + 1] = " ";
				  }
			  }
		  }
		  maze[maze.length - 2][maze[0].length - 1] = " ";
	}
}
class Cell{
	public boolean up = false;
	public boolean left = false;
	public boolean down = false;
	public boolean right = false;
	public boolean isVisited = false;
	public int x;
	public int y;
	public int neighbours = 0;
	public Cell() {
		
	}
	public void setX(int xCoordinate){
		this.x = xCoordinate;
	}
	public void setY(int yCoordinate) {
		this.y = yCoordinate;
	}
	public void setUp(boolean flag) {
		this.up = flag;
	}
	public void setLeft(boolean flag) {
		this.left = flag;
	}
	public void setDown(boolean flag) {
		this.down = flag;
	}
	public void setRight(boolean flag) {
		this.right = flag;
	}


}
