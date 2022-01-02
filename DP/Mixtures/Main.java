// similar to MCM

import java.util.Arrays;

class Main{
	public static void main(String[] args) {
		int[] arr = {40,60,20,50};
		System.out.println(Mixture_Recursion(arr,0,arr.length - 1));

		int[][] strg_arr =  new int[arr.length][arr.length];

		for(int i=0;i<strg_arr.length;i++){
			Arrays.fill(strg_arr[i],-1);
		}

		System.out.println(Mixture_TopDownDP(arr,0,arr.length - 1 ,strg_arr));

		System.out.println(Mixture_BottomUpDP(arr));
	}

	public static int Mixture_Recursion(int[] arr , int si , int ei){

		// base case
		if(si == ei){
			return 0;
		}
		int min = Integer.MAX_VALUE;

		for(int k = si ; k <= ei-1 ; k++){
			int first = Mixture_Recursion(arr,si,k);
			int second = Mixture_Recursion(arr,k+1,ei);

			int self_work = color(arr,si,k) * color(arr,k+1,ei);

			int total = first + second + self_work;

			if(total < min){
				min = total;
			}
		}
		return min;
	}



	public static int Mixture_TopDownDP(int[] arr , int si , int ei , int[][] strg_arr){

		// base case
		if(si == ei){
			return 0;
		}

		if (strg_arr[si][ei] != -1) { // reuse -- 0 can also be the answer so use non-zero
			return strg_arr[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for(int k = si ; k <= ei-1 ; k++){
			int first = Mixture_TopDownDP(arr,si,k,strg_arr);
			int second =Mixture_TopDownDP(arr,k+1,ei,strg_arr);

			int self_work = color(arr,si,k) * color(arr,k+1,ei);

			int total = first + second + self_work;

			if(total < min){
				min = total;
			}
		}
		strg_arr[si][ei] = min;
		return min;
	}

	public static int Mixture_BottomUpDP(int[] arr){

		int n = arr.length;
		int[][] strg_arr = new int[n][n];

		for(int slide = 1 ; slide <= n-1 ; slide++){
			for(int si = 0 ; si <= n-slide-1 ; si++){
				int ei = si + slide;

				if(si == ei) { // base case - if only one matrix
				strg_arr[si][ei] =  0;
				}

				else{
					int min = Integer.MAX_VALUE;

					// k splits
					for(int k=si ; k<=ei-1 ; k++){
						int first = strg_arr[si][k]; // arr[si] * arr[k]
						int second = strg_arr[k+1][ei]; // arr[k] * arr[ei]

						int self_work = color(arr,si,k) * color(arr,k+1,ei);

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
	

	public static int color(int[] arr , int i , int j){
		int sum = 0;
		for(int k=i; k<=j; k++){
			sum += arr[k];
		}
		return sum % 100;
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

3400

3400

0	2400	2400	3400	
0	0	    1200	5200	
0	0	    0	    1000	
0	0		0       0

3400

*/