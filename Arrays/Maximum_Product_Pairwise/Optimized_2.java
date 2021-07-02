/*

Solution To Use :
 --------------------------
 
 1) Optimized solution - single traversal.

 Steps :

 1.  Compute max , second max.
 2.  Compute min , second minimum
 3.  Compare max and return pairs.
*/

import java.util.*;

class Optimized_2 {

 static void  maximum_product_pairwise(int arr[],int n){


// base cases

  if(n < 2){
   System.out.println("No pairs exists");
   return; 
  }

  if(n == 2){
    System.out.println("Product : "+(arr[0]*arr[1]) + " " + " Pair : "+ arr[0] + " & " +arr[1]);
    return;
  }


  int max1 = Integer.MIN_VALUE;
  int max2 = Integer.MIN_VALUE;

  int min1 = Integer.MAX_VALUE;
  int min2 = Integer.MAX_VALUE;


  for (int i=0 ; i < n ;i++){

    // compute max , second max

    if(arr[i] > max1){
      max2 = max1; // update this first 
      max1 = arr[i];
      
    }
    else if (arr[i] > max2){
      max2 = arr[i];
    }

    if(arr[i] < min1){
      min2 = min1; // update this first 
      min1 = arr[i];
     
    }
    else if (arr[i] < min2){
      min2 = arr[i];
    }



  } // end for 


if((max1 * max2) > (min1 * min2) ){
   System.out.println("Product : "+(max1*max2) + " " + " Pair : "+ max1 + " & " + max2);
}
else{
  System.out.println("Product : "+(min1*min2) + " " + " Pair : "+ min1 + " & " + min2);
}

}
  

  public static void main(String[] args) {
    int arr1[] = {1, 2, 3};
    int arr2[] = {7 ,5 ,14 ,2 ,8 ,8 ,10 ,1 ,2 ,3};
    int arr3[] = {1, 4, 3, 6, 7, 0};
    int arr4[] = {-1, -3, -4, 2, 0, -5 };
   
 

    maximum_product_pairwise(arr1,arr1.length);
    maximum_product_pairwise(arr2,arr2.length);
    maximum_product_pairwise(arr3,arr3.length);
    maximum_product_pairwise(arr4,arr4.length);


 }
}


/*

Output :
------------------------

Product : 6  Pair : 3 & 2
Product : 140  Pair : 14 & 10
Product : 42  Pair : 7 & 6
Product : 20  Pair : -5 & -4


Complexity Analysis :
---------------------------
TC : O(N) 
SC : O(1) 



*/