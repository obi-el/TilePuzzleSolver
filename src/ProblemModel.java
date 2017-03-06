

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Obinna Elobi
 * 
 * Tile Puzzle with added possible move to increase space problem.
 * 
 * Representation of a node for a NxN or NxM tile puzzle 
 * With addition of the Knight piece move from chess, on non-blank tiles.
 */


public class ProblemModel {
	private final int row;
	private final int column;
	private int[][] board;
	private ProblemModel predecessor;
	
	
	public ProblemModel(int row, int column){
		
		this.row = row;
		this.column = column;
		board = new int[row][column];
		
		for(int i = 0; i < row ; i++){
			for(int j = 0; j < column ; j++){
				this.board[i][j] = 0;
			}
		}
	}
	
	public ProblemModel(int row, int column, int[][] board){
		this.row = 0 + row;
		this.column = 0 + column;
		this.board = new int[row][column];
		
		for(int i = 0; i < row ; i++){
			for(int j = 0; j < column ; j++){
				this.board[i][j] = 0 + board[i][j];
			}
		}
	}
	
	/**
	 * 
	 * @return parent of current node
	 */
	public ProblemModel getPredecessor() {
		return predecessor;
	}

	/**
	 *  sets parent
	 *  
	 * @param predecessor parent of current node
	 */
	public void setPredecessor(ProblemModel predecessor) {
		this.predecessor = predecessor;
	}

	/**
	 * 
	 * @return Board
	 */
	public int[][] getBoard() {
		return board;
	}

	/**
	 * sets nodes bourd to param board
	 * 
	 * @param board
	 */
	public void setBoard(int[][] board) {
		this.board = board;
	}

	/**
	 * 
	 * @return list of child nodes of current node
	 */
	public ArrayList<ProblemModel> getSubNodes(){
		ArrayList<ProblemModel> ret = new ArrayList<ProblemModel>();
		
		//if solvable add moves to blank tile only
		//if not solvable only add horse moves to try and generate more solvable states
		if(this.isSolvable())ret.addAll(moveZero());
		else ret.addAll(moveHorse());
		
		for(ProblemModel p: ret){
			p.setPredecessor(this);
		}
		return ret;
	}
	
	
	/**
	 * 
	 * Swap The tiles at the specified row, column indexes
	 * 
	 * @param fromR  Row index of tile being moved from
	 * @param fromC  Column index of tile being moved from
	 * @param toR  Row index of tile being moved to
	 * @param toC  Column Index of Tile being moved to
	 * @param board board to make move on
	 */
	private void swapTiles(int fromR, int fromC, int toR, int toC, int[][] board){
		int temp = 0 + board[toR][toC];
		board[toR][toC] = 0 + board[fromR][fromC];
		board[fromR][fromC] = 0 + temp;
		
	}
	
	/**
	 * 
	 * @return list of child nodes with Knights L shaped moves on all positions where possible
	 */
	public ArrayList<ProblemModel> moveHorse(){
		ArrayList<ProblemModel> ret = new ArrayList<ProblemModel>();
		
		for(int i = 0; i < row ; i++){
			for(int j = 0; j < column ; j++){
				if(this.board[i][j] != 0){
					
					//move: 2 down, 1 left
					if(i + 2 < row && j -1 >= 0 && board[i+2][j-1] != 0){
						ProblemModel temp = new ProblemModel(this.row,this.column,this.board);
						swapTiles(i,j,i+2,j-1,temp.getBoard());
						ret.add(temp);
					}
					//move: 2 down, 1 right
					if(i + 2 < row && j +1 < column && board[i+2][j+1] != 0){
						ProblemModel temp = new ProblemModel(this.row,this.column,this.board);
						swapTiles(i,j,i+2,j+1,temp.getBoard());
						ret.add(temp);
					}
					//  move: 2 up, 1 left
					if(i - 2 >= 0 && j -1 >= 0 && board[i-2][j-1] != 0){
						ProblemModel temp = new ProblemModel(this.row,this.column,this.board);
						swapTiles(i,j,i-2,j-1,temp.getBoard());
						ret.add(temp);
					}
					//move: 2 up, 1 right
					if(i - 2 >= 0 && j +1 < column && board[i-2][j+1] != 0){
						ProblemModel temp = new ProblemModel(this.row,this.column,this.board);
						swapTiles(i,j,i-2,j+1,temp.getBoard());
						ret.add(temp);
					}
					//move: 1 up, 2 right
					if(i - 1 >= 0 && j +2 < column && board[i-1][j+2] != 0){
						ProblemModel temp = new ProblemModel(this.row,this.column,this.board);
						swapTiles(i,j,i-1,j+2,temp.getBoard());
						ret.add(temp);
					}
					//move: 1 down, 2 right
					if(i + 1 < row && j +2 < column && board[i+1][j+2] != 0){
						ProblemModel temp = new ProblemModel(this.row,this.column,this.board);
						swapTiles(i,j,i+1,j+2,temp.getBoard());
						ret.add(temp);
					}
				//  move: 1 up, 2 left
					if(i - 1 >= 0 && j -2 >= 0 && board[i-1][j-2] != 0){
						ProblemModel temp = new ProblemModel(this.row,this.column,this.board);
						swapTiles(i,j,i-1,j-2,temp.getBoard());
						ret.add(temp);
					}
					//move: 1 down, 2 left
					if(i + 1 < row && j -2 >= 0 && board[i+1][j-2] != 0){
						ProblemModel temp = new ProblemModel(this.row,this.column,this.board);
						swapTiles(i,j,i+1,j-2,temp.getBoard());
						ret.add(temp);
					}
				}	
			}
		}
		
		return ret;
	}
	
	/**
	 * 
	 * @return list of all child nodes with the blank tile done all its available moves
	 */
	public ArrayList<ProblemModel> moveZero(){
		ArrayList<ProblemModel> ret = new ArrayList<ProblemModel>();
		int rowZ = -1;
		int colZ = -1;
		
		outer: 
			for(int i = 0; i < row ; i++){
				for(int j = 0; j < column ; j++){
					if(this.board[i][j] == 0){
					rowZ = i;
					colZ = j;
					break outer;
				}
			}
		}
		if(rowZ < 0 || colZ < 0)return new ArrayList<ProblemModel>();
		
		//move up
		ProblemModel temp = new ProblemModel(this.row,this.column,this.board);
		temp = moveUp(rowZ, colZ, temp);
		if(temp != null)ret.add(temp);
		
		//move down
		temp = new ProblemModel(this.row,this.column,this.board);
		temp = moveDown(rowZ, colZ, temp);
		if(temp != null)ret.add(temp);
							
		//moveright
		temp = new ProblemModel(this.row,this.column,this.board);
		temp = moveRight(rowZ, colZ, temp);
		if(temp != null)ret.add(temp);
		
		//move left
		temp = new ProblemModel(this.row,this.column,this.board);
		temp = moveLeft(rowZ, colZ, temp);
		if(temp != null)ret.add(temp);
						
		
		
		return ret;
		
	}

	/**  
	 * Move one space up
	 * 
	 * @param rowZ
	 * @param colZ
	 * @param temp
	 */
	private ProblemModel moveUp(int rowZ, int colZ, ProblemModel temp) {
		//Move up
		if(rowZ - 1 < row && rowZ -1 >= 0){
			swapTiles(rowZ, colZ, rowZ-1, colZ, temp.getBoard());
			
		}else return null;
		
		return temp;
	}
	
	/**  
	 * Move one space down
	 * 
	 * @param rowZ
	 * @param colZ
	 * @param temp
	 */
	private ProblemModel moveDown(int rowZ, int colZ, ProblemModel temp) {
		//Move up
		if(rowZ + 1 < row && rowZ +1 >= 0){
			swapTiles(rowZ, colZ, rowZ+1, colZ, temp.getBoard());
			
		}else return null;
		
		return temp;
	}
	
	/**  
	 * Move one space right
	 * 
	 * @param rowZ
	 * @param colZ
	 * @param temp
	 */
	private ProblemModel moveRight(int rowZ, int colZ, ProblemModel temp) {
		//Move right
		if(colZ + 1 < column && colZ + 1 >= 0){
				swapTiles(rowZ, colZ, rowZ, colZ+1, temp.getBoard());
									
			}	else return null;	
		return temp;
	}
	
	
	/**  
	 * Move one space left
	 * 
	 * @param rowZ
	 * @param colZ
	 * @param temp
	 */
	private ProblemModel moveLeft(int rowZ, int colZ, ProblemModel temp) {
		//Move left
		if(colZ - 1 < column && colZ - 1 >= 0){
			swapTiles(rowZ, colZ, rowZ, colZ-1, temp.getBoard());		
		}else return null;
		
		return temp;
	}
	
	/**
	 * 
	 * @return board as a list of its values
	 */
	public ArrayList<Integer> oneD() {
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    for (int i = 0; i < row; i++) {
	        // tiny change 1: proper dimensions
	        for (int j = 0; j < column; j++) { 
	            // tiny change 2: actually store the values
	            list.add(board[i][j]); 
	           // System.out.print("" + board[i][j]);
	        }
	    }
	    return list;
	}
	
	
	@Override
	public boolean equals(Object obj){
		 if (obj == null) {
		        return false;
		    }
		    if (!ProblemModel.class.isAssignableFrom(obj.getClass())) {
		        return false;
		    }
		    final ProblemModel other = (ProblemModel) obj;
		    if(other.row != this.row)return false;
		    if(other.column != this.column)return false;
		    
		    Integer zero = 0;
		    ArrayList<Integer> temp = other.oneD();
		    ArrayList<Integer> temp2 = this.oneD();
		    temp.remove(temp.indexOf(zero));
		    temp2.remove(temp2.indexOf(zero));
		    for(int i = 0; i < row*column -1; i++){
				if(temp.get(i) != temp2.get(i))return false;
			}
		    
		return true;    
	}
	
	/**
     * second attempt to count the number of inversions in the input array. pls work
     * 
     * @param a the input array
     * @return  the number of inversions.
     */
    public int countInversions2(int[] pList){
    	 int inversions = 0;

    for(int i=0;i <pList.length;i++){
        for(int j=i+1;j<pList.length;j++){
            if(pList[j]<pList[i]){
                inversions++;
            }
        }
    }
    
    return inversions;
    }

   /**
    * @return true if node can be solved by moving blank tile
    */
	public boolean isSolvable(){
		
		ArrayList<Integer> lis = oneD();
		int[] arr = new int[lis.size()-1];
		int index = 0;
		for(Integer i : lis){
			if(i == 0)continue;
			arr[index] = i;
			index++;
		}
		
		int inv2 = countInversions2(arr);
		
		int rowZ = -1;
		int colZ = -1;
		
		outer: 
			for(int i = 0; i < row ; i++){
				for(int j = 0; j < column ; j++){
					if(this.board[i][j] == 0){
					rowZ = i;
					colZ = j;
					break outer;
				}
			}
		}
		
		// Formula to check if node is solvable. Source= https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
		
		//( (grid width odd) && (#inversions even) )  ||  ( (grid width even) && ((blank on odd row from bottom) == (#inversions even)) )
		boolean result = ((column%2==1) && (inv2%2==0)) ||  ( (column%2==0) && (( ((row-1)-rowZ+1)%2==1) == (inv2%2==0)));
		
		
	
		return result;
	}
	
	public static void main(String args[]){
//		ProblemModel pm = new ProblemModel(3,3);
//		pm.setBoard(new int[][]{{1,8,2},{0,4,3},{7,6,5}});
//		ProblemModel pm2 = new ProblemModel(3,3);
//		pm2.setBoard(new int[][]{{7,1,2},{5,3,9},{0,8,6}});
//		ProblemModel pm3 = new ProblemModel(3,3);
//		pm3.setBoard(new int[][]{{7,1,2},{5,3,9},{0,8,6}});
//		ProblemModel pm4 = new ProblemModel(3,3);
//		pm4.setBoard(new int[][]{{7,1,2},{5,3,9},{0,8,6}});
		
		//solvable
		ProblemModel pm5 = new ProblemModel(4,4);
		pm5.setBoard(new int[][]{{13,2,10,3},{1,12,8,4},{5,0,9,6},{15,14,11,7}});
		
		//not solvable
		ProblemModel pm6 = new ProblemModel(4,4);
		pm6.setBoard(new int[][]{{2,1,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}});
		
//		pm.setPredecessor(pm2);
//		pm2.setPredecessor(pm3);
//		pm3.setPredecessor(pm4);
//		pm4.setPredecessor(pm5);
//		pm5.setPredecessor(pm6);
		
		//
		boolean s = pm5.isSolvable();
		//boolean s2 = pm2.isSolvable();
		//System.out.println(s);
		System.out.println(s);
		
		
	}
	
	
	//Heuristic: Hamming distance
	public int outOfPlace(){
		ArrayList<Integer> list = this.oneD();
		int ret = 0;
		list.remove(list.indexOf(ret));
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) != i+1)ret++;
		}
		return ret;
	}
	
	
	//Heuristic: number of reversal tiles
	public int reversalTile(){
		ArrayList<Integer> list = this.oneD();
		int ret = 0;
		list.remove(list.indexOf(ret));
		for(int i = 0; i < list.size()-1; i++){
			if((list.get(i) == i+2) && (list.get(i+1) == i+1))ret++;
		}
		return ret;
	}
	
	
	/**
	 * 
	 * @return Depth of node if in tree
	 */
	public int getDepth(){
		int d = 0;
		if(this.predecessor != null)d =  1 + predecessor.getDepth();
		return d;
	}
	
	
	/**
	 * Displays a 2d array in the console, one line per row.
	 */
	public void printMatrix() {
	    for(int r=0; r<row; r++) {
	       for(int c=0; c<column; c++)
	           System.out.print(board[r][c] + " ");
	       System.out.println();
	    }
	    System.out.println("Depth: " + this.getDepth());
	    
	}
	
	
	
}


