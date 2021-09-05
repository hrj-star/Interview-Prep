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

		// [, a, b, ab, c, ac, bc, abc] -- for example
		for(String str : rec_res){ // loop for recursion result iteration
			result.add("" + str);
			result.add(first  + str);
		} 

		/*

		//for sequence : [, c, b, bc, a, ac, ab, abc] -- for example
		
		for(String str : rec_res){
			result.add("" + str);
		}

		for(String str : rec_res){
			result.add(first  + str);
		}

		*/
		return result;
	}
	

	public static void printSubsequences(String s , String ans){
		if(s.length() == 0){
			System.out.println(ans);
			return;
		}

		char first = s.charAt(0);
		String remaining = s.substring(1);

		printSubsequences(remaining , ans + first);
		printSubsequences(remaining , ans + "");
				
	}

	/* 
		Output :      abc
				 	  ab
					  ac
					  a
					  bc
					  b
					  c
	*/	
					  
	public static void main(String[] args) {
		System.out.println(getSubsequences("abc"));
		printSubsequences("abc","");
	}
}

/*

abc -> subsequences of "bc" -> " ","b","c","bc"
append a to above to get subsequences of "abc" -> " ","a","b","ab","c","ac","bc","abc"

Output :
-------------------
[, a, b, ab, c, ac, bc, abc]

Time Complexity  : O(2^n)

To -do : Get subsequences with ascii
*/