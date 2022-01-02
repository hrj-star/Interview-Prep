class Main{


	/*
	Type 1 : Rrcursion using substring()
	--------------
	TC : O(3^(m+n)) + substring() time
	SC : Recursion extra space

	*/
	public static int ED_Recursion(String s1 , String s2){
		// base case
		if(s1.length() == 0 || s2.length() == 0){ // if atleast 1 string is empty , then return max of length of both
			return Math.max(s1.length() , s2.length());
		}

		char ch1 = s1.charAt(0); // first char of s1
		char ch2 = s2.charAt(0); // first char of s2

		String ros1 = s1.substring(1); // rest of string from 2nd char of s1
		String ros2 = s2.substring(1); // rest of string from 2nd char of s2

		int ans = 0;
		
		if(ch1 == ch2){  // if 1st char of both strings is equal
			ans = ED_Recursion(ros1,ros2); 
		}
		else{
			int insert = ED_Recursion(ros1,s2); 
			int delete = ED_Recursion(s1,ros2); 
			int replace = ED_Recursion(ros1,ros2); 
			ans = Math.min(insert , Math.min(delete ,replace)) + 1;
		}

		return ans;
	}


	/*
	Type 2 : Recursion with Virtual Index
	--------------
	TC : O(3^(m+n)) 
	SC : Recursion extra space
	*/

	public static int ED_Recursion_Virtual_Idx(String s1 , String s2 , int vdx1 , int vdx2){
		if(s1.length() == vdx1 || s2.length() == vdx2){
			return Math.max(s1.length() - vdx1 , s2.length() - vdx2);
		}
		char ch1 = s1.charAt(vdx1);
		char ch2 = s2.charAt(vdx2);

		int ans = 0;

		if(ch1 == ch2){
			ans = ED_Recursion_Virtual_Idx(s1,s2,vdx1 + 1 ,vdx2 + 1);
		}
		else{
			int insert = ED_Recursion_Virtual_Idx(s1,s2,vdx1 + 1,vdx2);
			int delete = ED_Recursion_Virtual_Idx(s1,s2,vdx1,vdx2 + 1);
			int replace = ED_Recursion_Virtual_Idx(s1,s2,vdx1 + 1,vdx2 + 1);
			ans = Math.min(insert , Math.min(delete , replace)) + 1;
		}

		return ans;
	}

	/*
	Type 3 : Top Down Recursive Memo
	--------------
	TC : O(m*n) 
	SC : O(m*n) + Recursion extra space
	*/
	
	public static int ED_TopDown(String s1 , String s2 , int vdx1 , int vdx2 , int[][] strg_arr){ // 2 args vidx1 , vidx2 are changing , so 2D array
		if(s1.length() == vdx1 || s2.length() == vdx2){
			return Math.max(s1.length() - vdx1 , s2.length() - vdx2);
		}

		if(strg_arr[vdx1][vdx2] != -1){ // reuse
			return strg_arr[vdx1][vdx2];
		}
		char ch1 = s1.charAt(vdx1);
		char ch2 = s2.charAt(vdx2);

		int ans = 0;

		if(ch1 == ch2){
			ans = ED_TopDown(s1,s2,vdx1 + 1 ,vdx2 + 1, strg_arr);
		}
		else{
			int insert = ED_TopDown(s1,s2,vdx1 + 1,vdx2,strg_arr);
			int delete = ED_TopDown(s1,s2,vdx1,vdx2 + 1,strg_arr);
			int replace = ED_TopDown(s1,s2,vdx1 + 1,vdx2 + 1,strg_arr);
			ans = Math.min(insert , Math.min(delete , replace)) + 1;
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

	public static int ED_BottomUpDP(String s1, String s2) {
		int[][] strg_arr = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				// base case : deletion operation at bottom boundary
				if(row == s1.length()){ // if its last row
					strg_arr[row][col] = s2.length() - col;
				}

				// base case : insertion operation at right boundary
				else if(col == s2.length()){ // if last col
					strg_arr[row][col] = s1.length() - row;
				}

				// fill middle values
				else{
					char ch1 = s1.charAt(row);
					char ch2 = s2.charAt(col);

					if(ch1 == ch2){
						strg_arr[row][col] = strg_arr[row + 1][col + 1]; // replace 
					}
					else{
						int insert = strg_arr[row + 1][col];
						int delete =  strg_arr[row][col + 1];
						int replace = strg_arr[row + 1][col + 1];
						strg_arr[row][col] = Math.min(insert , Math.min(delete , replace)) + 1;
					}

				}
			}
		}

		return strg_arr[0][0];
	}


	public static void main(String[] args) {
		String s1 = "sunday";
		String s2 = "saturday";

		// Recursion
		System.out.println(ED_Recursion(s1,s2)); 

		// Recursion - Using  Virtual Index 
		System.out.println(ED_Recursion_Virtual_Idx(s1,s2,0,0));

		// Top Down 

		int[][] strg_arr =  new int[s1.length()][s2.length()];

		for(int i=0;i<strg_arr.length;i++){
			for(int j=0;j<strg_arr[0].length;j++){
					strg_arr[i][j] = -1;
			}
		}
		System.out.println(ED_TopDown(s1,s2,0,0,strg_arr));

		// Bottom up
		System.out.println(ED_BottomUpDP(s1,s2));
	}
}
