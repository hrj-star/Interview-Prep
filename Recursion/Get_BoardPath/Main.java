import java.util.*;
class Main{

	public static ArrayList<String> getBoardPath(int curr , int end){

		if(curr == end){   // base case -- return base array of size 1  with one empty string to return recursion result back.
			ArrayList<String> base_res = new ArrayList<String>();
			base_res.add("");
			return base_res;
		}

		if(curr > end){  // base case  -- return empty base array of size 0 to not return anything to recursion result back.
			ArrayList<String> base_res = new ArrayList<String>();
			return base_res;
		}

		ArrayList<String> result = new ArrayList<String>();

		for(int dice = 1 ;dice <= 6 ;dice++){
			ArrayList<String> rec_res = getBoardPath(curr + dice , end);

			for(String str : rec_res){
				result.add(dice + str); // add self to recursion result , eg - for n = 4 ,if recursion returns 111 , then add 1 to it to sum up.
			}
		}

		return result;
	}

	/* print board path without returning arraylist */

	public static void printBoard(int curr , int end , String ans){
		if(curr == end){
			System.out.println(ans);
			return;
		}

		if(curr > end){
			return;
		}

		for(int dice = 1;dice <= 6;dice++){
			printBoard(curr + dice , end , ans + dice);
		}
	}

	/* return count of total paths */

	public static int countBoardPaths(int curr , int end){
		if(curr == end){ // positive base case 
			return 1;
		}

		if(curr > end){ // negative base case 
			return 0;
		}

		int count = 0;
		for(int dice = 1;dice <= 6;dice++){
			count += countBoardPaths(curr + dice , end );
		}
		return count;
	}
	
	public static void main(String[] args) {
		// execute one functions at a time 

		/* function to return arraylist & count of paths */
		ArrayList<String> boardpaths = getBoardPath(0,4);
		System.out.println(boardpaths);
		System.out.println("Total paths count : " + boardpaths.size());

		/* function to print paths */
        System.out.println("\nPrinting BoardPaths :");
		printBoard(0,4,"");

		/* function to count  paths */
		int paths = countBoardPaths(0,4);
		System.out.println("Total paths count : " + paths);
	}
}

/*

Output :
-------------------

[1111, 112, 121, 13, 211, 22, 31, 4]
Total paths count : 8

Printing BoardPaths :
1111
112
121
13
211
22
31
4
Total paths count : 8



Complexity Analysis :
------------------------

Time Complexity : O(6^n)
Space Complexity : Extra Space


*/