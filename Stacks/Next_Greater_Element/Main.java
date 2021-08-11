import java.util.*;

class Main{

	static void next_greater_element(int arr[],int n){
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i < n; i++){
			while(!s.isEmpty() && arr[i] > s.peek()){
				int popped = s.pop();

				System.out.println(popped+ " --> " + arr[i]);
			}
			s.push(arr[i]);
		}

		// for remaining elements in stack who are not popped as they do not have next greater to the right.

		while(!s.isEmpty()){
			int popped = s.pop();

			System.out.println(popped+ " --> " + "-1");
		}
	}

	public static void main(String[] args) {
		int arr[]= {11, 13, 21, 3};
		int n = arr.length;
		next_greater_element(arr,n);
	}
}

/*

Output :
----------------------


11 --> 13
13 --> 21
21 --> -1
3 --> -1


Complexity Analysis :
---------------------------
Time Complexity  : O(n)
Space Complexity : O(n)  // aux space for stack 


*/