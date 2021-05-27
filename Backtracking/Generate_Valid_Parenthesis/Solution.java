
// Backtracking , Recursion

import java.util.*;

class Solution{


public static  List<String> generateParenthesis(int n){

	List<String> result = new ArrayList<>();
	generateParenthesis(result,"",0,0,n);
	return result;
}

public static void generateParenthesis(List<String> result , String curr , int open , int close , int n){

	if(curr.length() == n*2 ){
		result.add(curr);
		return;
	}

	if(open < n){
		generateParenthesis(result,curr+"(",open + 1 , close,n);

	}

	if(close < open){
		generateParenthesis(result,curr+")",open  , close + 1 ,n);
	}
}

public static void main(String[] args){

int n=3;


System.out.println(generateParenthesis(n));
  
  }
}

/*

Output :
----------------

[((())), (()()), (())(), ()(()), ()()()]




Time Complexity: O(2^n).For every index there can be two options ‘{‘ or ‘}’. So it can be said that the upperbound of time complexity is O(2^n) or it has exponential time complexity.


Space Complexity: O(n).

*/