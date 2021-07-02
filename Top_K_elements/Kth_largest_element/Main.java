/*
Solution :

1. Sorting 

*/
import java.util.*;
class Main{
	static int kth_largest_element(int arr[] , int k){
		int n = arr.length;
		Arrays.sort(arr);
		return arr[n-k];
	}


	public static void main(String[] args) {
		int arr[] = {7, 4, 6, 3, 9, 1};
		int k = 2;
		int kth_largest = kth_largest_element(arr,k);
		System.out.println(kth_largest);
		
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