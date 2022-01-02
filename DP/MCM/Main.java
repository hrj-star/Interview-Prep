class Main{
	public static void main(String[] args) {

		/*
		   matrices dimensions:
			 * M1: 4 x 2
			 * M2: 2 x 3
			 * M3: 3 x 5
			 * M4: 5 x 1
		 */
		int[] arr = {4,2,3,5,1};
		System.out.println(MCM_Recursion(arr,0,arr.length - 1));

		System.out.println(MCM_TopDown(arr,0,arr.length - 1 , new int[arr.length][arr.length]));

		System.out.println(MCM_Bottom_Up(arr));
	}

	public static int MCM_Recursion(int[] arr , int si , int ei){

		if(si + 1 == ei) { // base case - if only one matrix
			return 0;
		}

		int min = Integer.MAX_VALUE;

		// k splits
		for(int k=si+1 ; k<=ei-1 ; k++){
			int first = MCM_Recursion(arr,si,k); // arr[si] * arr[k]
			int second = MCM_Recursion(arr,k,ei); // arr[k] * arr[ei]

			int self_work = arr[si] * arr[k] * arr[ei];

			int total = first + second + self_work;

			if(total < min){
				min = total;
			}
		}
		return min;
	}

	/* 
	Type 2 : Top-Down DP =  Recursion + Memo
	TC : O(n^3) , SC : O(n^2) + extra space for recursion // check
	*/

	public static int MCM_TopDown(int[] arr , int si , int ei , int[][] strg_arr){

		if(si + 1 == ei) { // base case - if only one matrix
			return 0;
		}

		if(strg_arr[si][ei] != 0){ // re-use
			return strg_arr[si][ei];
		}

		int min = Integer.MAX_VALUE;

		// k splits
		for(int k=si+1 ; k<=ei-1 ; k++){
			int first = MCM_TopDown(arr,si,k,strg_arr); // arr[si] * arr[k]
			int second = MCM_TopDown(arr,k,ei,strg_arr); // arr[k] * arr[ei]

			int self_work = arr[si] * arr[k] * arr[ei];

			int total = first + second + self_work;

			if(total < min){
				min = total;
			}
		}
		strg_arr[si][ei] = min; // store
		return min;
	}

	/* 
	Type 3 : Bottom-Up DP / Tabulation 
	TC : O(n^2 /2) as filling only upper half  * O(n) for self work = O(n^3) , SC : O(n^2)
	*/


	public static int MCM_Bottom_Up(int[] arr){

		int n = arr.length;
		int[][] strg_arr = new int[n][n];

		for(int slide = 1 ; slide <= n-1 ; slide++){
			for(int si = 0 ; si <= n-slide-1 ; si++){
				int ei = si + slide;

				if(si + 1 == ei) { // base case - if only one matrix
				strg_arr[si][ei] =  0;
				}

				else{
					int min = Integer.MAX_VALUE;

					// k splits
					for(int k=si+1 ; k<=ei-1 ; k++){
						int first = strg_arr[si][k]; // arr[si] * arr[k]
						int second = strg_arr[k][ei]; // arr[k] * arr[ei]

						int self_work = arr[si] * arr[k] * arr[ei];

						int total = first + second + self_work;

						if(total < min){
							min = total;
						}
					}
					strg_arr[si][ei] = min; // store
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
}


/*

29
29
0	0	24	70	29	
0	0	0	30	21	
0	0	0	0	15	
0	0	0	0	0	
0	0	0	0	0	
29

*/