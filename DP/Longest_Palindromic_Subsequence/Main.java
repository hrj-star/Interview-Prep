
class Main{
	public static void main(String[] args) {
		String s = "bbbab";
		// Output: 4 -- One possible longest palindromic subsequence is "bbbb".
		System.out.println(LPS_Recursion(s,0,s.length()-1));

		System.out.println(LPS_TopDownDP(s,0,s.length()-1,new int[s.length()][s.length()]));

		System.out.println(LPS_BottomUpDP(s));
	}


	public static int LPS_Recursion(String s , int si , int ei){

		if(si > ei){
			return 0;
		}

		if(si == ei){ // if one left , then si == ei , like -- a , so its pal , return 1
			return 1;
		}

		int ans = 0;

		if(s.charAt(si) == s.charAt(ei)){ // start and end equal , then recur middle , add + 2 for chars at si, ei
			ans = LPS_Recursion(s,si+1,ei-1) + 2;
		} 
		else{ //if start , end chars dont match
			int first = LPS_Recursion(s,si+1,ei);
			int second = LPS_Recursion(s,si,ei-1);

			ans = Math.max(first,second);
		}
		return ans;
	}


	public static int LPS_TopDownDP(String s , int si , int ei , int[][] strg_arr){

		if(si > ei){
			return 0;
		}

		if(si == ei){ // if one left , then si == ei , like -- a , so its pal , return 1
			return 1;
		}

		if(strg_arr[si][ei] != 0){
			return strg_arr[si][ei];
		}

		int ans = 0;

		if(s.charAt(si) == s.charAt(ei)){ // start and end equal , then recur middle , add + 2 for chars at si, ei
			ans = LPS_TopDownDP(s,si+1,ei-1,strg_arr) + 2;
		} 
		else{ //if start , end chars dont match
			int first = LPS_TopDownDP(s,si+1,ei,strg_arr);
			int second = LPS_TopDownDP(s,si,ei-1,strg_arr);

			ans = Math.max(first,second);
		}
		strg_arr[si][ei] = ans;
		return ans;
	}

	public static int LPS_BottomUpDP(String s){
		int n = s.length();
		int[][] strg_arr = new int[n][n];

		for(int slide = 0; slide <= n-1; slide++){
			for(int si = 0; si <= n-slide-1; si++){
				int ei = si + slide;

				if(si == ei){
					strg_arr[si][ei] = 1;
				}
				else{

					int ans = 0;

					if(s.charAt(si) == s.charAt(ei)){ // start and end equal , then recur middle , add + 2 for chars at si, ei
						ans = strg_arr[si+1][ei-1] +  2;
					} 
					else{ //if start , end chars dont match
						int first = strg_arr[si+1][ei];
						int second = strg_arr[si][ei-1]; 

						ans = Math.max(first,second);
					}
					strg_arr[si][ei] = ans;
				}
			}
		}

		return strg_arr[0][n-1];
	}


}