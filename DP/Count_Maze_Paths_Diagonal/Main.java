import java.util.*;
class Main{

	/* 
	Type 1 : Recursion 
	TC :  O(3^(end_row + end_col)) - Exponential , SC : Extra Space for Recursion
	*/

	public static int countMazePathDiagonal(int curr_row, int curr_col,int end_row,int end_col){
		
		// 1 - positive base case , 0 - negative base case.

		if(curr_row == end_row && curr_col == end_col){
			return 1;
		}

		if(curr_row > end_row || curr_col > end_col){ 
			return 0;
		}

		int hc = countMazePathDiagonal(curr_row,curr_col + 1 , end_row,end_col);
		int vc = countMazePathDiagonal(curr_row + 1 ,curr_col, end_row,end_col);
		int dc = countMazePathDiagonal(curr_row + 1 ,curr_col + 1, end_row,end_col);

		return hc + vc + dc;
	}

	/* 
	Type 2 : Top-Down DP =  Recursion + Memo
	Unique problems : (end_row + 1) * (end_col + 1)
	TC : O(end_row * end_col) , SC : O(end_row * end_col) + extra space for recursion
	*/

	public static int countMazePathDiagonalTopDownDP(int curr_row, int curr_col,int end_row,int end_col, int[][] strg_arr){
			
			// 1 - positive base case , 0 - negative base case.

			if(curr_row == end_row && curr_col == end_col){
				return 1;
			}

			if(curr_row > end_row || curr_col > end_col){ 
				return 0;
			}

			if(strg_arr[curr_row][curr_col] != 0){ // re-use
			return strg_arr[curr_row][curr_col];
			}

			int hc = countMazePathDiagonalTopDownDP(curr_row,curr_col + 1 , end_row,end_col, strg_arr);
			int vc = countMazePathDiagonalTopDownDP(curr_row + 1 ,curr_col, end_row,end_col, strg_arr);
			int dc = countMazePathDiagonalTopDownDP(curr_row + 1 ,curr_col + 1, end_row,end_col, strg_arr);

			strg_arr[curr_row][curr_col] = hc + vc + dc; // store
			return hc + vc + dc;
		}


	/* 
	Type 3 : Bottom - Up DP / Tabulation
	TC : O(end_row * end_col) , SC : O(end_row * end_col) 
	*/
	public static int countMazePathDiagonalBottomUpDP(int end_row , int end_col){
		int[][] strg_arr = new int[end_row + 2][end_col + 2];

		for(int row = end_row; row >= 0; row--){
			for(int col =  end_col; col >=0; col--){
				if(row == end_row && col == end_col){
					strg_arr[row][col] = 1;
				}else{
					strg_arr[row][col] = strg_arr[row][col + 1] + strg_arr[row + 1][col] + strg_arr[row + 1][col + 1];
				}
			}
		}

		return strg_arr[0][0];
	}

	/* 
	Type 4 : Bottom - Up DP / Tabulation Space Efficient 
	TC : O(end_row * end_col) , SC : O(end_col) 
	*/

	public static int countMazePathDiagonalBottomUpDPSpaceOptimized(int end_row , int end_col){
		int[] strg_arr = new int[end_col + 1];

		Arrays.fill(strg_arr,1);

		int diagonal = 0;

		for(int slide = end_row - 1; slide >= 0; slide--){
			for(int col =  end_col ; col >= 0 ; col--){
				if(col == end_col){
					strg_arr[col] = 1;
					diagonal = 1;
				}
				else{
					int sum = strg_arr[col] + strg_arr[col + 1] + diagonal;
					diagonal = strg_arr[col]; // first set diagonal , then update strg_arr[col]
					strg_arr[col] = sum;
				}
			}
		}

		return strg_arr[0];
	}

	public static void main(String[] args) {

		/* function to count  paths */
		int n = 2;

		//System.out.println("Total Paths(Recursion) : " + countMazePathDiagonal(0,0,n,n));

		System.out.println("Total Paths(Top Down DP) : " + countMazePathDiagonalTopDownDP(0,0,n,n, new int[n+1][n+1]));

		System.out.println("Total Paths(Bottom Up DP) : " + countMazePathDiagonalBottomUpDP(2,3));

		System.out.println("Total Paths(Bottom Up DP - Space Optimized) : " + countMazePathDiagonalBottomUpDPSpaceOptimized(n,n));
	}
}

/*

Total Paths(Top Down DP) : 13
Total Paths(Bottom Up DP) : 25
Total Paths(Bottom Up DP - Space Optimized) : 13


*/