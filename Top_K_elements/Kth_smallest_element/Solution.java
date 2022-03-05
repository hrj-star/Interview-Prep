/*
Solution :

1. Sorting 

*/
import java.util.*;
class Solution{
	static int kth_smallest_element(int arr[] , int k){
		int n = arr.length;
		Arrays.sort(arr);
		return arr[k-1];
	}


	public static void main(String[] args) {
		int arr[] = {7, 10, 4, 3, 20, 15};
		int k = 3;
		int kth_smallest = kth_smallest_element(arr,k);
		System.out.println(kth_smallest);
		
	}
}










/*
Solution :
------------------------
7

Complexity Analysis :
--------------------------------
TC : O(n*logn)
SC : O(1)

*/