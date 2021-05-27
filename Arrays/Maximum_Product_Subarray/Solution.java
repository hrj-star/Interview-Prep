/*

Solution To Use :
 
 1)  Brute Force
 2)  +ves as well as -ves.
 
*/

import java.util.*;

class Solution {

 static void  maximum_product_subarray(int arr[],int n){

  int left = 0,right = 0;
  int maxi_subarray=Integer.MIN_VALUE;

  for( int i = 0; i < n; i++){
    int curr_product=1;

    for( int j = i; j < n; j++){
      curr_product *= arr[j];

      if(curr_product > maxi_subarray){
        maxi_subarray = curr_product;
        left  = i;
        right = j;
      }
    }
  }

  System.out.println("Maximum Product Subarray is " + maxi_subarray + " from index " + left + " to " + right );



  }
  

  public static void main(String[] args) {
    int arr1[] = {6, -3, -10, 0, 2};
    int arr2[] = {-1, -3, -10, 0, 60};
    int arr3[] = {-2, -40, 0, -2, -3};
    int arr4[] = {40, 0, -20, -10 };
   
 

   maximum_product_subarray(arr1,arr1.length);
   maximum_product_subarray(arr2,arr2.length);
   maximum_product_subarray(arr3,arr3.length);
   maximum_product_subarray(arr4,arr4.length);


 }
}


/*

Output :
------------------------

Maximum Product Subarray is 180 from index 0 to 2 

Maximum Product Subarray is 60 from index 4 to 4

Maximum Product Subarray is 80 from index 0 to 1

Maximum Product Subarray is 200 from index 2 to 3


Complexity Analysis :
---------------------------
TC : O(N^2) - scans entire array twice.
SC : O(1) - constant space



*/