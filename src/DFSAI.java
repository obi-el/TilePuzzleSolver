


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Set;

/**
 * 
 * @author Obinna
 *
 * Depth First search algorithm to find endNode
 */
public class DFSAI implements AI{

	private ArrayList<Integer> endNode;
	private int zero = 0;
	
	private Stack<ProblemModel> unvisitedPMSolvable;
	private Stack<ProblemModel> unvisitedPMUnsolvable;
	private ArrayList<ProblemModel> visited;
	
	
	public DFSAI(ProblemModel problemModel){
		
		
		unvisitedPMSolvable = new Stack<ProblemModel>();
		unvisitedPMUnsolvable = new Stack<ProblemModel>();
		visited = new ArrayList<ProblemModel>();
		
		
		for(ProblemModel pm : problemModel.getSubNodes()){
			
			if(pm.isSolvable())unvisitedPMSolvable.add(pm);
			else unvisitedPMUnsolvable.add(pm);
		}
		visited.add(problemModel);
		
		
		endNode = problemModel.oneD();
		Collections.sort(endNode);
		endNode.remove(endNode.indexOf(zero));
		
	}
	
	
	
	@Override
	public void solve() {
		long startTime = System.nanoTime();
	
		int i = 0;
		while(true){
			i++;
			ProblemModel current = (unvisitedPMSolvable.isEmpty()) ?unvisitedPMUnsolvable.pop(): unvisitedPMSolvable.pop();
			if(current == null || i == 50000){
				System.out.println("==========================No Solution Found====================");
				break;
			}
			
	
			for(ProblemModel pm : current.getSubNodes()){
				if(!visited.contains(pm) && !unvisitedPMSolvable.contains(pm)){
					if(pm.isSolvable())unvisitedPMSolvable.add(pm);
					else unvisitedPMUnsolvable.add(pm);
				}
				
			
			}
			
			ArrayList<Integer> temp = current.oneD();
			  temp.remove(temp.indexOf(zero));
			
			
			if(temp.equals(endNode)){

				printPathTaken(current);
				System.out.print( "\n" + "------------done--------------");
				long endTime = System.nanoTime();
				long duration = ((endTime - startTime)/1000000);
				System.out.print( "\n" + "-DFS Time taken: " + duration + "ms");
				
				
				break;
			}
			
			visited.add(current);
			
			
		}
		
		
	}


	private void printPathTaken(ProblemModel current) {
		
		System.out.println( "\n" + "----------------------------------------------");
		current.printMatrix();
		if(current.getPredecessor() != null)printPathTaken(current.getPredecessor());
	}
		
	

public static void main(String[] args){
	ProblemModel pm = new ProblemModel(3,3);
	pm.setBoard(new int[][]{{7,1,2},{5,3,9},{8,0,6}});
	
	DFSAI bfs = new DFSAI(pm);
	System.out.println(bfs.endNode);
}


}