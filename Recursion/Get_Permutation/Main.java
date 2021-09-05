import java.util.*;
class Main{

	public static ArrayList<String> getSubsequences(String s){

		if(s.length() == 0){   // base case -- return base array of size 1  with one empty string 
			ArrayList<String> base_res = new ArrayList<String>();
			base_res.add("");
			return base_res;
		}

		char first = s.charAt(0);
		String remaining = s.substring(1);

		ArrayList<String> rec_res = getSubsequences(remaining);
		ArrayList<String> result = new ArrayList<String>();
		
		for(String str : rec_res){ // loop for recursion result iteration --  [bc , cb]
			for(int i=0;i<=str.length();i++){ 
				//for looping inside individual element to insert character at all possible positions -- [abc,bac,bca,acb,cab,cba]
				String val = str.substring(0,i) + first + str.substring(i);
				result.add(val); 
			}
		} 
		return result;
	}



	public static void printPermutation(String s , String ans_so_far){
		if(s.length() == 0){
			System.out.println(ans_so_far);
			return;
		}

		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			String s_left = s.substring(0,i);
			String s_right = s.substring(i+1);

			String rest_of_s = s_left + s_right;

			printPermutation(rest_of_s , ans_so_far + ch);
		}
	}
	
	/* 
	Solution :

		abc
		acb
		bac
		bca
		cab
		cba

	*/

	public static void main(String[] args) {
		System.out.println(getSubsequences("abc"));
		printPermutation("abc","");
	}
}

/*

Output
-------------------

[abc, bac, bca, acb, cab, cba]

Time Complexity  : O(n * n!)

*/