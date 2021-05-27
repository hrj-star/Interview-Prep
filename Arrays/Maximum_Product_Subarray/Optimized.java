/*

Solution To Use :
 
 1)  Optimized 
*/

import java.util.*;

class Optimized {

 static int  maximum_product_subarray(int arr[],int n){

  if (arr == null || arr.length == 0) {
    return 0  ;
  }

  int max = arr[0];
  int min = arr[0];
  int maxi_subarray = arr[0];

  for(int i=1 ; i<n ; i++){
    int temp_max = arr[i] * max ;
    int temp_min = arr[i] * min ;

    max = Math.max(Math.max(temp_max , temp_min) , arr[i]);
    min = Math.min(Math.min(temp_max , temp_min) , arr[i]);

    maxi_subarray = Math.max(maxi_subarray,max);

  }

  
  return maxi_subarray;



  }
  

  public static void main(String[] args) {
    int arr1[] = {6, -3, -10, 0, 2};
    int arr2[] = {-1, -3, -10, 0, 60};
    int arr3[] = {-2, -40, 0, -2, -3};
    int arr4[] = {40, 0, -20, -10 };
   
 

   System.out.println("Maximum Product Subarray is " +maximum_product_subarray(arr1,arr1.length));
   System.out.println("Maximum Product Subarray is " +maximum_product_subarray(arr2,arr2.length));
   System.out.println("Maximum Product Subarray is " +maximum_product_subarray(arr3,arr3.length));
   System.out.println("Maximum Product Subarray is " +maximum_product_subarray(arr4,arr4.length));


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
TC : O(N) - scans entire array once.
SC : O(1) - constant space



*/