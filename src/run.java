

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class run {
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Space Management Problem");
		System.out.println("Please type in grid layout seperated by a comma");
		System.out.println("Example: 2 rows x 5 columns = 2,5");
		String s = sc.nextLine();
		String inputs[] = s.split(",");
		
		String row = inputs[0];
		String col = inputs[1];
			
		int i = -1;
		int j = -1;
		try{
			 i = Integer.parseInt(row);
			 j = Integer.parseInt(col);
			}catch(NumberFormatException e1){
				System.out.println( row + " " + col + ": Invalid number Spotted, Please Try again"); 
				System.exit(0);
		}
		
		ProblemModel pm = new ProblemModel(0,0);

		if(i > 0 && j > 0){
			pm = new ProblemModel(i,j);
		}else {
			System.out.println( " Invalid dimensions, Please Try again"); 
			System.exit(0);
		}
		
		
		System.out.println("Please type in grid values by a comma");
		 s = sc.nextLine();
		 inputs = s.split(",");
		 if(inputs.length != i*j){
			 System.out.println(" Invalid number of inputs, Please Try again"); 
				System.exit(0);
		 }
		 
		int[] oneD = new int[i*j];
		for(int index = 0 ; index < i*j ; index++ ){
				try{
					int value = Integer.parseInt(inputs[index]);
					oneD[index] = value;
				}catch(NumberFormatException e1){
						System.out.println( inputs[index] + ": Invalid number Spotted, Please Try again"); 
						System.exit(0);
				}
		
		}
		
		int[][] grid = new int[i][j];
		int index = 0;
		for(int r = 0; r < i; r++){
			for(int c = 0; c < j; c++){
				grid[r][c] = oneD[index];
				index++;
			}
		}
		pm.setBoard(grid);
		pm.printMatrix();
		
		BFSAI bf = new BFSAI(pm);
		DFSAI df = new DFSAI(pm);
		Astar1 a1 = new Astar1(pm);
		Astar2 a2 = new Astar2(pm);
		AstarBoth ab = new AstarBoth(pm);
//		
		
		System.out.println("Please type in Strategy: \n");
		System.out.println("BFS - Breadth First");
		System.out.println("DFS - depth First ");
		System.out.println("ASONE - A-Star one: Tiles out of place");
		System.out.println("ASTWO - A-Star two: Reversal Tile count");
		System.out.println("ASBOTH - finds average of 1 and 2 ");
		
		s = sc.nextLine();
		s = s.toLowerCase();
		if(s.equals("bfs")) bf.solve();
		else if(s.equals("dfs")) df.solve();
		else if(s.equals("asone")) a1.solve();
		else if(s.equals("astwo")) a2.solve();
		else if(s.equals("asboth")) ab.solve();
		else{
			System.out.println( s + ": Invalid input, Please Try again");
			System.exit(0);
		}
	}
	

}
