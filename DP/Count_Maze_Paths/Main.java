import java.util.*;
class Main{

	/* 
	Type 1 : Recursion 
	TC :  O(2^(end_row + end_col)) - Exponential , SC : Extra Space for Recursion
	*/

	public static int countMazePath(int curr_row, int curr_col,int end_row,int end_col){
		
		// 1 - positive base case , 0 - negative base case.
		if(curr_row == end_row && curr_col == end_col){
			return 1;
		}

		if(curr_row > end_row || curr_col > end_col){ // do not print answer
			return 0;
		}

		int hc = countMazePath(curr_row,curr_col + 1 , end_row,end_col);
		int vc = countMazePath(curr_row + 1 ,curr_col, end_row,end_col);

		return hc + vc;
	}

	/* 
	Type 2 : Top-Down DP =  Recursion + Memo
	Unique problems : (end_row + 1) * (end_col + 1)
	TC : O(end_row * end_col) , SC : O(end_row * end_col) + extra space for recursion
	*/

	public static int countMazePathTopDownDP(int curr_row, int curr_col,int end_row,int end_col,int[][] strg_arr){
		
		// 1 - positive base case , 0 - negative base case.

		if(curr_row == end_row && curr_col == end_col){
			return 1;
		}

		if(curr_row > end_row || curr_col > end_col){ // do not print answer
			return 0;
		}

		if(strg_arr[curr_row][curr_col] != 0){
			return strg_arr[curr_row][curr_col];
		}

		int hc = countMazePathTopDownDP(curr_row, curr_col + 1, end_row, end_col, strg_arr);
		int vc = countMazePathTopDownDP(curr_row + 1, curr_col, end_row, end_col, strg_arr);

		strg_arr[curr_row][curr_col] = hc + vc;

		return hc + vc;
	}	


	/* 
	Type 3 : Bottom-Up DP / Tabulation
	TC : O(end_row * end_col) , SC : O(end_row * end_col) 
	*/


	public static int countMazePathBottomUpDP(int end_row , int end_col){
		int[][] strg_arr = new int[end_row + 2][end_col + 2]; // to handle negative base cases size is 2 more of n

		// start filling from right to left

		for(int row = end_row ; row >= 0 ; row--){
			for(int col = end_col ; col >=0 ; col--){
				if(row == end_row && col == end_col){
					strg_arr[row][col] = 1; // count to reach from itself -  1 
				}else{
					strg_arr[row][col] = strg_arr[row][col + 1] + strg_arr[row + 1][col]; // current value depends on sum of its right and bottom
				}
			}
		}

		return strg_arr[0][0]; // final ans at strg_arr[0][0]
	}


	/* 
	Type 4 : Bottom-Up DP / Tabulation Space Efficient
	TC : O(end_row * end_col) , SC : O(end_col) -- constant
	*/

	public static int countMazePathBottomUpDPSpaceOptimized(int end_row , int end_col){
		int[] strg_arr = new int[end_col + 1];

		Arrays.fill(strg_arr,1);

		for(int slide = end_row - 1; slide >= 0; slide--){
			for(int col = end_col ; col >= 0 ; col--){
				if(col == end_col){
					strg_arr[col] = 1;
				}
				else{
					strg_arr[col] = strg_arr[col] + strg_arr[col + 1];
				}
			}
		}
		return strg_arr[0];
	}

	public static void main(String[] args) {

		/* function to count  paths */
		int n = 2;

		int totalpaths = countMazePath(0,0,n,n);
		System.out.println("Total Paths(Recursion) : "+totalpaths);

		System.out.println("Total Paths(Top Down DP) : "+countMazePathTopDownDP(0,0,n,n, new int[n+1][n+1]));

		System.out.println("Total Paths(Bottom Up DP) : "+countMazePathBottomUpDP(n,n));

		System.out.println("Total Paths(Bottom Up DP - Space Optimized) : "+countMazePathBottomUpDPSpaceOptimized(n,n));
	}
}

/*
Total Paths(Recursion) : 6
Total Paths(Top Down DP) : 6
Total Paths(Bottom Up DP) : 6
Total Paths(Bottom Up DP - Space Optimized) : 6
*/