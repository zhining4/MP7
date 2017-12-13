import java.util.Scanner;

public class PlayTheMaze {
	private static Scanner sc;

	public static void main(String[] arg) {
		String representation = null;
		int initx = 1;
		int inity = 1;
		Boolean isFinished = false;
	    sc = new Scanner(System.in); 
	    System.out.println("Please enter your name:(At least two character)");
	    String name = sc.nextLine();
	    while(name.length() < 2 ) {
	    	System.out.println("Come on Man! Please enter your name:");
	    	name = sc.nextLine();
	    }
	    Player Name = new Player(name);
	    System.out.println("Please enter your representation to be moved in the maze!(Only one character!)");
		representation = sc.nextLine();
		while(representation.length() != 1) {
			System.out.println("Please enter your representation to be moved in the maze!(Only one character!)");
			representation = sc.nextLine();
		}
		Name.setRep(representation);
		System.out.println("Ok! Now you can start to play the maze! Which size of the maze would you like to play?");
		System.out.println("Please enter a number between (5 - 40) for your Width:");
		int mazeWidth = sc.nextInt();
		while(!(mazeWidth >= 5 && mazeWidth <= 40) ) {
			System.out.println("Invalid Input! Please enter a number between (5 - 40):");
			mazeWidth = sc.nextInt();
		}
		System.out.println("Please enter a number between (5 - 40) for your Length:");
		int mazeLength = sc.nextInt();
		while(!(mazeLength >= 5 && mazeLength <= 40) ) {
			System.out.println("Invalid Input! Please enter a number between (5 - 40):");
			mazeLength = sc.nextInt();
		}
		Maze thisGame = new Maze(mazeWidth, mazeLength);
		thisGame.maze[initx][inity] = representation;
		String up = sc.nextLine();
		while(up.length() != 1) {
			System.out.println("Choose your character to move upward:(Only one character!)");
			up = sc.nextLine();
		}
		System.out.println("Choose your character to move downward:(Only one character!)");
		String down = sc.nextLine();
		while(down.length() != 1) {
			System.out.println("Choose your character to move downward:(Only one character!)");
			down = sc.nextLine();
		}
		System.out.println("Choose your character to move left:(Only one character!)");
		String left = sc.nextLine();
		while(left.length() != 1) {
			System.out.println("Choose your character to move left:(Only one character!)");
			left = sc.nextLine();
		}
		System.out.println("Choose your character to move right:(Only one character!)");
		String right = sc.nextLine();
		while(right.length() != 1) {
			System.out.println("Choose your character to move right:(Only one character!)");
			right = sc.nextLine();
		}
		System.out.println("Are you ready to start?(Say true or false!)");
		boolean ready = sc.nextBoolean();
		while(!ready) {
			System.out.println("Are you ready to start?(Say true or false!)");
			ready = sc.nextBoolean();
		}
		int count = 0;
		while(!isFinished) {
			if(thisGame.maze[thisGame.maze.length - 2][thisGame.maze[0].length - 1] == representation) {
				System.out.println("Perfect! " + name + " run out of this Maze with " + count + " steps!");
				isFinished = true;
			} 
				String type = sc.nextLine();
				if (type.equals(down) && thisGame.maze[initx][inity-1] == " " ) {
					String temp = thisGame.maze[initx][inity];
					thisGame.maze[initx][inity] = thisGame.maze[initx][inity-1];
					thisGame.maze[initx][inity-1] = temp;
					System.out.println("\n" + "movement" + " " + count + " \n" + thisGame);
			        inity--;
		        } else if (type.equals(up) && thisGame.maze[initx][inity+1] == " ") {  
		        	String temp = thisGame.maze[initx][inity];
					thisGame.maze[initx][inity] = thisGame.maze[initx][inity+1];
					thisGame.maze[initx][inity+1] = temp;
					System.out.println("\n" + "movement" + " " + count + " \n" + thisGame);
		        	inity++;
		        } else if (type.equals(right) && thisGame.maze[initx+1][inity] == " ") {  
		        	String temp = thisGame.maze[initx][inity];
					thisGame.maze[initx][inity] = thisGame.maze[initx+1][inity];
					thisGame.maze[initx+1][inity] = temp;
					System.out.println("\n" + "movement" + " " + count + " \n" + thisGame);
					initx++;
		        } else if (type.equals(left) && thisGame.maze[initx-1][inity] == " ") {  
		        	String temp = thisGame.maze[initx][inity];
		        	thisGame.maze[initx][inity] = thisGame.maze[initx-1][inity];
				    thisGame.maze[initx-1][inity] = temp;
					System.out.println("\n" + "movement" + " " + count + " \n" + thisGame);
		            initx--;
		        } else {
		        	System.out.println("\n" + "movement" + " " + count + " \n" + thisGame);
		        }
				count++;
		}
		
	}


}