// Top Down DP - Memoization

import java.util.*;
class Main{


	/* 
	Type 1 : Recursion 
	TC : O(6^n) , SC : Extra Space for Recursion
	*/

	public static int countBoardPathsRec(int curr , int end){
		if(curr == end){ // positive base case 
			return 1;
		}

		if(curr > end){ // negative base case 
			return 0;
		}

		int count = 0;
		for(int dice = 1;dice <= 6;dice++){
			count += countBoardPathsRec(curr + dice , end );
		}
		return count;
	}

	/* 
	Type 2 : Recursion + Memo
	TC : O(n) , SC : O(n) + extra space for recursion
	*/


	public static int countBoardPathsRec_Memo(int curr , int end , int[] storage_array){

		if(curr == end){ // positive base case 
			return 1;
		}

		if(curr > end){ // negative base case 
			return 0;
		}


		if(storage_array[curr] != 0){ // reuse -  curr has value > 0
			return storage_array[curr];
		}


		int count = 0;
		for(int dice = 1;dice <= 6;dice++){
			count += countBoardPathsRec_Memo(curr + dice , end , storage_array);
		}

		storage_array[curr] = count; // store  computed count
		return count ;
	}

	/* 
	Type 3 : Bottom Up DP
	TC : O(n) , SC : O(n)
	*/

	public static int countBoardPathsBottomUpDP(int end){
		// storage array of size end + 6 to handle base cases.

		int[] storage_array = new int[end + 6];
		storage_array[end] = 1; // one way to reach from end from itself

		for(int i=end - 1 ; i>=0 ; i--){
			storage_array[i] = storage_array[i+1] + storage_array[i+2] + storage_array[i+3] + storage_array[i+4] + storage_array[i+5] +storage_array[i+6];	
		}

		return storage_array[0];
	}

	/* 
	Type 3 : Bottom Up DP - Space Optimized
	TC : O(n) , SC : O(1)
	*/

	public static int countBoardPathsDPSpace(int end){
		int[] s_arr = new int[6];
		s_arr[0] = 1;

		for(int i=1 ; i<=end ; i++){
			int sum = s_arr[0] + s_arr[1] + s_arr[2] + s_arr[3] + s_arr[4] + s_arr[5];

			s_arr[5] = s_arr[4];
			s_arr[4] = s_arr[3];
			s_arr[3] = s_arr[2];
			s_arr[2] = s_arr[1];
			s_arr[1] = s_arr[0];
			s_arr[0] = sum;
		}
		return s_arr[0];
	}
	
	public static void main(String[] args) {

		// recursion
		System.out.println("Total paths (Recursion) : " + countBoardPathsRec(0,4));

		// recursion + memo 
		int n = 10;
		// storage to store computed answer
		int[] storage_array =  new int[n]; // for 0 also -- 0th index gives total ways from 0 to n , 1st index gives total ways from 1 to n and so on.... 
		int paths = countBoardPathsRec_Memo(0,n,storage_array);
		System.out.println("Total paths (Recursive + Memo) : " + paths);

		// bottom-up DP
		System.out.println("Total paths (Bottom - Up DP) : " + countBoardPathsBottomUpDP(40));

		// bottom-up DP space
		System.out.println("Total paths (Bottom - Up DP Space Optimized) : " +  countBoardPathsDPSpace(40));
	}
}

/*

Output :
-------------------
Total paths (Recursion) : 8
Total paths (Recursive + Memo) : 492
Total paths (Bottom - Up DP) : 250544224
Total paths (Bottom - Up DP Space Optimized) : 250544224

*/