/*

Solution To Use :
 
 1)  Brute Force
 2)  +ves as well as -ves.
 
*/

import java.util.*;

class Solution {

 static void  maximum_sum_subarray(int arr[],int n){

  int left = 0,right = 0;
  int maxi_subarray=Integer.MIN_VALUE;

  for( int i = 0; i < n; i++){
    int curr_sum=0;

    for( int j = i; j < n; j++){
      curr_sum += arr[j];

      if(curr_sum > maxi_subarray){
        maxi_subarray = curr_sum;
        left  = i;
        right = j;
      }
    }
  }

   System.out.println("Maximum Sum Subarray is " + maxi_subarray + " from index " + left + "  to " + right );



  }
  

  public static void main(String[] args) {
    int arr1[] = {1,2,3,-2,5};
    int arr2[] = {-1,-2,-3,-4};
    int arr3[] = {-2,1,-3,4,-1,2,1,-5,4};
    int arr4[] = {1};
   
 

    maximum_sum_subarray(arr1,arr1.length);
    maximum_sum_subarray(arr2,arr2.length);
    maximum_sum_subarray(arr3,arr3.length);
    maximum_sum_subarray(arr4,arr4.length);


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
TC : O(N^2) - scans entire array twice.
SC : O(1) - constant space



*/