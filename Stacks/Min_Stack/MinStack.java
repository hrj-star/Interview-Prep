import java.util.*;

public class MinStack{
	
	Stack<Integer> stack;
	Stack<Integer> minstack;

	public  MinStack(){
		stack = new Stack<>();
		minstack = new Stack<>();
	}

	public void push(int item){
		int mini = item;

		if(!minstack.isEmpty() && item > minstack.peek()){
			mini = minstack.peek();
		}
		stack.push(item);
		minstack.push(mini);
	}

	public void pop(){
		stack.pop();
		minstack.pop();
	}

	public int top(){
		return stack.peek();
	}

	public int getMin(){
		return minstack.peek();
	}

	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);

       // System.out.println("Minimum element is :" + s.getMin());  // Minimum element is : 1

 
        s.pop();

        System.out.println("Minimum element is : " + s.getMin()); // get Minimum 
	}
}


/*

Output :
----------------------


Minimum element is : 4


Complexity Analysis :
---------------------------
Time Complexity  : O(1)
Space Complexity : O(n) - min stack -2 stacks used. 

To-do : O(1) space



*/