/* Using Recursion */

import java.util.*;

class Main{

	public static void sortStack(Stack<Integer> s){
		if(s.isEmpty()){
			return;
		}

		int top = s.pop();
		sortStack(s);
		insertInOrder(s,top);
	}

	public static void insertInOrder(Stack<Integer> s , int item){
		if(s.isEmpty() || s.peek() < item){
			s.push(item);
			return;
		}
		else{
			int top = s.pop();
			insertInOrder(s,item);
			s.push(top);
		}
	}
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(10);
		s.push(-1);
		s.push(100);
		s.push(8);

		System.out.println(s);

		sortStack(s);

		System.out.println(s);
	}
}


/*

Output :
----------------------

[10, -1, 100, 8]
[-1, 8, 10, 100]


Complexity Analysis :
---------------------------
Time Complexity  : O(n^2)
Space Complexity : O(n) - call stack



*/