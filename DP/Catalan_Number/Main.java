// Use catalan number series 

class Main{
	public static void main(String[] args) {
		int n = 5;
		System.out.println(Unique_BST_Recursion(n));

		System.out.println(Unique_BST_Top_Down_DP(n , new int[n+1])); // + 1 for self

		System.out.println(Unique_BST_Bottom_Up_DP(n)); // + 1 for self
	}

	public static int Unique_BST_Recursion(int n){
		if(n<=1){ // if n = 1 , return 1 for self result , if n = 0 meaning right subtree has returned 0 , so return 1 not 0 as * would result in 0. 
			return 1;
		}

		int total = 0;
		for(int i=1;i<=n;i++){
			int left = Unique_BST_Recursion(i-1); // left subtree of ith node
			int right = Unique_BST_Recursion(n-i);// right subtree of ith node

			int ith_node_ans = left * right ;

			total += ith_node_ans;
		}
		return total;
	}

	public static int Unique_BST_Top_Down_DP(int n , int[] strg_arr){
		if(n<=1){ // if n = 1 , return 1 for self result , if n = 0 meaning right subtree has returned 0 , so return 1 not 0 as * would result in 0. 
			return 1;
		}

		if(strg_arr[n] != 0){
			return strg_arr[n];
		}

		int total = 0;
		for(int i=1;i<=n;i++){
			int left = Unique_BST_Top_Down_DP(i-1 , strg_arr); // left subtree of ith node
			int right = Unique_BST_Top_Down_DP(n-i , strg_arr);// right subtree of ith node

			int ith_node_ans = left * right ;

			total += ith_node_ans;
		}
		strg_arr[n] = total;
		return total;
	}

	public static int Unique_BST_Bottom_Up_DP(int total_nodes){
		int[] strg_arr = new int[total_nodes + 1];

		strg_arr[0] = strg_arr[1] = 1;

		for(int n = 2; n < strg_arr.length; n++){
			int total = 0;
			for(int i=1;i<=n;i++){
				int left = strg_arr[i-1]; // left subtree of ith node
				int right = strg_arr[n-i];// right subtree of ith node

				int ith_node_ans = left * right ;

				total += ith_node_ans;
			}
			strg_arr[n] = total;
		}
		return strg_arr[total_nodes];
	}
}