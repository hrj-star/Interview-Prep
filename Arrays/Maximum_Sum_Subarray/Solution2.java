/*

Solution To Use :
 
 1)  Divide and Conquer ( less optimized than kadanes)
 2)  +ves as well as -ves.
 
*/

import java.util.*;

class Solution2 {

 static int  maximum_sum_subarray(int arr[],int left,int right){

 	if (left == right) 
 		return arr[left];
	int mid = left + (right - left) / 2 , leftMax, rightMax;
	
	leftMax = rightMax = Integer.MIN_VALUE;
		
	for (int i = mid, sum = 0; i >= left; --i) 
		leftMax = Math.max(leftMax, sum += arr[i]);
	for (int j = mid + 1, sum = 0; j <= right; ++j)
		rightMax = Math.max(rightMax, sum += arr[j]);

	return Math.max(Math.max(maximum_sum_subarray(arr, left, mid),maximum_sum_subarray(arr, mid + 1, right)), leftMax + rightMax);

  }
  

  public static void main(String[] args) {
    int arr1[] = {1,2,3,-2,5};
    int arr2[] = {-1,-2,-3,-4};
    int arr3[] = {-2,1,-3,4,-1,2,1,-5,4};
    int arr4[] = {1};
   
 

    System.out.println(maximum_sum_subarray(arr1,0,arr1.length-1));
    System.out.println(maximum_sum_subarray(arr2,0,arr2.length-1));
    System.out.println(maximum_sum_subarray(arr3,0,arr3.length-1));
    System.out.println(maximum_sum_subarray(arr4,0,arr4.length-1));


 }
}


/*

Output :
------------------------

9  : Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

-1 : Max subarray sum is -1 of element (-1)

6  : Max subarray sum is 6 of element (4,-1,2,1) .

1  : Max subarray from one element itself.



Complexity Analysis :
---------------------------
TC : O(nlogn) - divide and conquer
SC : O(1) - constant space



*/