/*

Solution To Use :
 
 1)  Optimized
 2)  +ves as well as -ves.
 
*/

import java.util.*;

class Optimized {

 static int  maximum_sum_subarray(int arr[],int n){

  int curr_sum=arr[0], overall_sum=arr[0];

  for(int i=1;i<n;i++){

    // if curr_sum is positive and beneficial , add current element and curr_sum
    
    if(curr_sum>=0){
      curr_sum+=arr[i];

    }

   // if curr_sum is negative or less , start new subarray from current element.

    else{
      curr_sum=arr[i];
    }

    if(curr_sum>overall_sum){
      overall_sum = curr_sum;
    }
    
  }


   return overall_sum;


  }
  

  public static void main(String[] args) {
    int arr1[] = {1,2,3,-2,5};
    int arr2[] = {-1,-2,-3,-4};
    int arr3[] = {-2,1,-3,4,-1,2,1,-5,4};
    int arr4[] = {1};
   
 

    System.out.println(maximum_sum_subarray(arr1,arr1.length));
    System.out.println(maximum_sum_subarray(arr2,arr2.length));
    System.out.println(maximum_sum_subarray(arr3,arr3.length));
    System.out.println(maximum_sum_subarray(arr4,arr4.length));


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
TC : O(N) - scans entire array exactly once.
SC : O(1) - constant space



*/