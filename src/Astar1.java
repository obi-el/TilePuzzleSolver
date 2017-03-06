

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @author Obinna Elobi
 * 
 * A* search with hamming distance heuristic(number of tiles out of place)
 */

public class Astar1 implements AI{
		private ArrayList<Integer> endNode;
		private int zero = 0;
		
		
		//Two queues, one containing solvable nodes the other unsolvable states
		//solvable node queue given priority over unsolvable state queue
		private Queue<ProblemModel> unvisitedPMSolvable;
		private Queue<ProblemModel> unvisitedPMUnsolvable;

		private ArrayList<ProblemModel> visited;
		
		
		public Astar1(ProblemModel problemModel){
			unvisitedPMSolvable = new LinkedList<ProblemModel>();
			unvisitedPMUnsolvable = new LinkedList<ProblemModel>();
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
		
		
		// returns node with smallest f-score
		private ProblemModel findCheapestNode(){
			ProblemModel ret = (unvisitedPMSolvable.isEmpty()) ?unvisitedPMUnsolvable.peek(): unvisitedPMSolvable.peek();
			if(ret ==null)return null;
			
			boolean loc = false;
			if(!unvisitedPMSolvable.isEmpty()){
				for(ProblemModel p : unvisitedPMSolvable){ 
					//f(s) = depth + total out of place
					if(p.outOfPlace()+ p.getDepth() <= ret.outOfPlace() + ret.getDepth()) ret = p;
					loc = true;
				}
			}else{
				for(ProblemModel p : unvisitedPMUnsolvable){ 
					//f(s) = depth + total out of place
					if(p.outOfPlace()+ p.getDepth() <= ret.outOfPlace() + ret.getDepth()) ret = p;
				}
			}
			if (loc)unvisitedPMSolvable.remove(ret);
			else unvisitedPMUnsolvable.remove(ret);
			return ret;
		}
		
		/**
		 * 
		 * In 5000 iterations, find solution to given problemModel
		 */
		
		public void solve() {
			long startTime = System.nanoTime();
			int i = 0;
			while(true){
				i++;
				ProblemModel current = findCheapestNode();
				if(current == null || i == 50000){
					System.out.println("==========================No Solution Found====================");
					break;
				}
				
		
				//if node has been visited or has been queued to be visited don't add to queue
				for(ProblemModel pm : current.getSubNodes()){
					if(!visited.contains(pm) && !unvisitedPMSolvable.contains(pm)){
						if(pm.isSolvable())unvisitedPMSolvable.add(pm);
						else unvisitedPMUnsolvable.add(pm);
					}
					
				
				}
				
				ArrayList<Integer> temp = current.oneD();
				  temp.remove(temp.indexOf(zero));
				
				//break condition
				if(temp.equals(endNode)){

					printPathTaken(current);
					System.out.print( "\n" + "------------done--------------");
					long endTime = System.nanoTime();
					long duration = ((endTime - startTime)/1000000);
					System.out.print( "\n" + "-AStar1 Time taken: " + duration + "ms");
					
					
					break;
				}
				
				visited.add(current);
				
				
				
				
				
			}
			
			
		}



		/**
		 * @param current node/problemModel currently on
		 * 
		 * 	prints nodes visited to reach current
		 */
		private void printPathTaken(ProblemModel current) {
			
			System.out.println( "\n" + "----------------------------------------------");
			current.printMatrix();
			if(current.getPredecessor() != null)printPathTaken(current.getPredecessor());
		}
		
	

	
}
