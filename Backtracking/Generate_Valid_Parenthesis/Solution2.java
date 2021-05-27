
// Backtracking , Recursion

import java.util.*;

class Solution2{


public static  List<String> generateParenthesis(int n){

	List<String> result = new ArrayList<>();

	if(n==0)
		return result;   

	generateParenthesis(result,"",n,n); // pass n as left , right 
	return result;
}

public static void generateParenthesis(List<String> result , String curr , int open , int close ){

	if(open == 0 && close ==0){
		result.add(curr);
		return;
	}

	if(open > 0){
		generateParenthesis(result,curr+"(",open -1 , close);

	}

	if(close > open){
		generateParenthesis(result,curr+")",open  , close - 1 );
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




Time Complexity: O(2^2n) or O(2^n).For every index there can be two options ‘(‘ or ‘)’. So ,the upperbound of time complexity is O(2^n) or it has exponential time complexity.


Space Complexity: O(n).

*/