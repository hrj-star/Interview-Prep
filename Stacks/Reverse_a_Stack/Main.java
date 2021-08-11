/* Using Recursion */

import java.util.*;

class Main{

	public static void reverseStack(Stack<Integer> s){
		if(s.isEmpty()){
			return;
		}

		int top = s.pop();
		reverseStack(s);
		bottomInsert(s,top);
	}

	public static void bottomInsert(Stack<Integer> s , int item){
		if(s.isEmpty()){
			s.push(item);
			return;
		}
		else{
			int top = s.pop();
			bottomInsert(s,item);
			s.push(top);
		}
	}
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);

		System.out.println(s);

		reverseStack(s);

		System.out.println(s);
	}
}


/*

Output :
----------------------

[4, 3, 2, 1]
[1, 2, 3, 4]


Complexity Analysis :
---------------------------
Time Complexity  : O(n^2)
Space Complexity : O(n) - call stack



*/