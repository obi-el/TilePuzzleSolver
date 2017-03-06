

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @author Obinna Elobi
 * 
 * A* search with reversal tiles total heuristic
 */

public class Astar2 implements AI{
	
	
		private ArrayList<Integer> endNode;
		private int zero = 0;
		
		private Queue<ProblemModel> unvisitedPMSolvable;
		private Queue<ProblemModel> unvisitedPMUnsolvable;

		private ArrayList<ProblemModel> visited;
		
		
		public Astar2(ProblemModel problemModel){
			
			
			unvisitedPMSolvable = new LinkedList<ProblemModel>();
			unvisitedPMUnsolvable = new LinkedList<ProblemModel>();
			visited = new ArrayList<ProblemModel>();
			//unvisitedList = new LinkedList<Integer>();
			
			for(ProblemModel pm : problemModel.getSubNodes()){
				
				if(pm.isSolvable())unvisitedPMSolvable.add(pm);
				else unvisitedPMUnsolvable.add(pm);
				//unvisitedList.add(pm.hashCode());
			}
			visited.add(problemModel);
			
			
			endNode = problemModel.oneD();
			Collections.sort(endNode);
			endNode.remove(endNode.indexOf(zero));
		}
		
		
		// returns node with smallest f-score
		private ProblemModel findCheapestNode(){
			ProblemModel ret = (unvisitedPMSolvable.isEmpty()) ?unvisitedPMUnsolvable.peek(): unvisitedPMSolvable.peek();
			if(ret ==null)return null;
			
			boolean loc = false;
			if(!unvisitedPMSolvable.isEmpty()){
				for(ProblemModel p : unvisitedPMSolvable){ 
					//f(s) = depth + number of reversal tiles
					if((2 * p.reversalTile())+ p.getDepth() <= (2 *ret.reversalTile()) + ret.getDepth()) ret = p;
					loc = true;
				}
			}else{
				for(ProblemModel p : unvisitedPMUnsolvable){ 
					//f(s) = depth + total out of place
					if((2 * p.reversalTile())+ p.getDepth() <= (2*ret.reversalTile()) + ret.getDepth()) ret = p;
				}
			}
			if (loc)unvisitedPMSolvable.remove(ret);
			else unvisitedPMUnsolvable.remove(ret);
			return ret;
		}
		
		
		@Override
		public void solve() {
			long startTime = System.nanoTime();
			//for(Object pm : unvisitedPMSolvable)System.out.println("" + ((ProblemModel) pm).oneD() + "UL");
			int i = 0;
			while(true){
				i++;
				ProblemModel current = findCheapestNode();
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
					System.out.print( "\n" + "-Astar2 Time taken: " + duration + "ms");
					
					
					break;
				}
				
				visited.add(current);
				
				
				
			}
			
			
		}



		/**
		 * @param current
		 */
		private void printPathTaken(ProblemModel current) {
			
			System.out.println( "\n" + "----------------------------------------------");
			current.printMatrix();
			if(current.getPredecessor() != null)printPathTaken(current.getPredecessor());
		}
			

	
}
