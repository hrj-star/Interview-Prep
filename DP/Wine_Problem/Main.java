class Main{

	/* 
	Type 1 : Recursion 
	TC :   Exponential , SC : Extra Space for Recursion
	*/

	public static int WP_Recursion(int[] arr, int si , int ei , int year){

		// base case
		if(si == ei){
			return arr[si] * year;
		}

		int start = WP_Recursion(arr, si+1, ei, year+1) + arr[si] * year;
		int end = WP_Recursion(arr, si, ei-1, year+1) + arr[ei] * year;

		int ans = Math.max(start,end);
		return ans;
	}

	/* 
	Type 2 : Top-Down DP =  Recursion + Memo
	TC : O(n^2) , SC : O(n^2) + extra space for recursion // check
	*/


	public static int Top_Down_DP(int[] arr, int si, int ei, int[][] strg_arr){

		// year depends on si , ei : so calculate year

		int n = arr.length;

		int year = n - (ei - si + 1) + 1;
		// base case
		if(si == ei){
			return arr[si] * year;
		}

		if(strg_arr[si][ei] != 0){ // reuse 
			return strg_arr[si][ei];
		}

		// pass along

		int start = Top_Down_DP(arr, si+1, ei, strg_arr) + arr[si] * year;
		int end = Top_Down_DP(arr, si, ei-1, strg_arr) + arr[ei] * year;

		int ans = Math.max(start,end);
		strg_arr[si][ei] = ans; // store
		return ans;
	}

	/* 
	Type 3 : Bottom-Up DP / Tabulation 
	TC : O(n^2 /2) as filling only upper half = O(n^2) , SC : O(n^2)
	*/

	public static int Bottom_Up_DP(int[] arr){
		int n = arr.length;
		int[][] strg_arr = new int[n][n];
		for(int slide = 0; slide <= n-1; slide++){
			for(int si = 0; si <= n-slide-1 ; si++){
				int ei = si + slide;


				// same logic as top down but instead of recursive calls , fill storage array
				int year = n - (ei - si + 1) + 1;

				if(si == ei){
					strg_arr[si][ei] = arr[si] * year;
				}
				else{
					int start = strg_arr[si+1][ei]  + arr[si] * year;
					int end = strg_arr[si][ei-1]  + arr[ei] * year;

					int ans = Math.max(start,end);
					strg_arr[si][ei] = ans; 
				}
			}
		}

		display(strg_arr); // to understand Bottom Up Array
		return strg_arr[0][n-1];
	}

	public static void display(int[][] strg_arr){
		for(int i=0;i<strg_arr.length;i++){
			for(int j=0;j<strg_arr[0].length;j++){
				System.out.print(strg_arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] arr = {2,3,5,1,4};
		int n = arr.length;

		System.out.println(WP_Recursion(arr, 0, n - 1, 1));

		System.out.println(Top_Down_DP(arr, 0, n - 1, new int[n][n]));

		System.out.println(Bottom_Up_DP(arr));
	}
}

/*
50

50

10	23	43	45	50	
0	15	37	40	48	
0	0	25	29	41	
0	0	0	5	24	
0	0	0	0	20	

50
*/