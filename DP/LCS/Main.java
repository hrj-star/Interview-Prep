class Main{


	/*
	Type 1 : Rrcursion using substring()
	--------------
	TC : O(2^(m+n)) + substring() time
	SC : Recursion extra space

	*/
	public static int LCS_Recursion(String s1 , String s2){
		if(s1.length() == 0 || s2.length() == 0){ // if atleast 1 string is empty , then return 0
			return 0;
		}

		char ch1 = s1.charAt(0); // first char of s1
		char ch2 = s2.charAt(0); // first char of s2

		String ros1 = s1.substring(1); // rest of string from 2nd char of s1
		String ros2 = s2.substring(1); // rest of string from 2nd char of s2

		int ans = 0;
		
		if(ch1 == ch2){  // if 1st char of both strings is equal
			ans = LCS_Recursion(ros1,ros2) + 1 ; // add 1 as ch1 == ch2
		}
		else{
			int option1 = LCS_Recursion(s1,ros2); // looking if s1 exists in ros2
			int option2 = LCS_Recursion(ros1,s2); // looking if s2 exists in ros1
			ans = Math.max(option1 , option2);
		}

		return ans;
	}


	/*
	Type 2 : Recursion with Virtual Index
	--------------
	TC : O(2^(m+n)) 
	SC : Recursion extra space
	*/

	public static int LCS_Recursion_Virtual_Idx(String s1 , String s2 , int vdx1 , int vdx2){
		if(s1.length() == vdx1 || s2.length() == vdx2){
			return 0;
		}
		char ch1 = s1.charAt(vdx1);
		char ch2 = s2.charAt(vdx2);

		int ans = 0;

		if(ch1 == ch2){
			ans = LCS_Recursion_Virtual_Idx(s1,s2,vdx1 + 1 ,vdx2 + 1) + 1;
		}
		else{
			int option1 = LCS_Recursion_Virtual_Idx(s1,s2,vdx1,vdx2 + 1);
			int option2 = LCS_Recursion_Virtual_Idx(s1,s2,vdx1 + 1,vdx2);
			ans = Math.max(option1 , option2);
		}

		return ans;
	}

	/*
	Type 3 : Top Down Recursive Memo
	--------------
	TC : O(m*n) 
	SC : O(m*n) + Recursion extra space
	*/
	
	public static int LCS_TopDown(String s1 , String s2 , int vdx1 , int vdx2 , int[][] strg_arr){ // 2 args vidx1 , vidx2 are changing , so 2D array
		if(s1.length() == vdx1 || s2.length() == vdx2){
			return 0;
		}

		if(strg_arr[vdx1][vdx2] != -1){ // reuse
			return strg_arr[vdx1][vdx2];
		}
		char ch1 = s1.charAt(vdx1);
		char ch2 = s2.charAt(vdx2);

		int ans = 0;

		if(ch1 == ch2){
			ans = LCS_TopDown(s1,s2,vdx1 + 1 ,vdx2 + 1, strg_arr) + 1;
		}
		else{
			int option1 = LCS_TopDown(s1,s2,vdx1,vdx2 + 1,strg_arr);
			int option2 = LCS_TopDown(s1,s2,vdx1 + 1,vdx2,strg_arr);
			ans = Math.max(option1 , option2);
		}

		strg_arr[vdx1][vdx2] = ans; // store
		return ans;
	}



	/*
	Type 4 : Bottom Up Tabulation
	--------------
	TC : O(m*n) 
	SC : O(m*n) 
	*/

	public static int LCS_BottomUpDP(String s1, String s2) {
		int[][] strg_arr = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				char ch1 = s1.charAt(row);
				char ch2 = s2.charAt(col);

				if (ch1 == ch2) {
					strg_arr[row][col] = 1 + strg_arr[row + 1][col + 1];
				} else {
					strg_arr[row][col] = Math.max(strg_arr[row][col + 1], strg_arr[row + 1][col]);
				}
			}
		}

		return strg_arr[0][0];
	}


	public static void main(String[] args) {
		String s1 = "algorithm";
		String s2 = "alignment"; // lcs : algm , length = 4

		// Recursion
		System.out.println(LCS_Recursion(s1,s2)); 

		// Recursion - Using  Virtual Index 
		System.out.println(LCS_Recursion_Virtual_Idx(s1,s2,0,0));

		// Top Down 

		int[][] strg_arr =  new int[s1.length()][s2.length()];

		for(int i=0;i<strg_arr.length;i++){
			for(int j=0;j<strg_arr[0].length;j++){
					strg_arr[i][j] = -1;
			}
		}
		System.out.println(LCS_TopDown(s1,s2,0,0,strg_arr));

		// Bottom up
		System.out.println(LCS_BottomUpDP(s1,s2));
	}
}
