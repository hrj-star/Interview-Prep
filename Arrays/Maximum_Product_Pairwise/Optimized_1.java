/*

Solution To Use :
 
 1) Optimized than Brute Force   
*/

import java.util.*;

class Optimized_1 {

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

  int a,b;
  Arrays.sort(arr);

  int combined_sum = arr[n-1] * arr[n-2]; // 2 largest elements products in combined array
  int neg_sum = arr[0] * arr[1]; // 2 smallest elements products in neg arrays

  // compare which one gives maximum pair

  if(combined_sum > neg_sum){
    a = arr[n-2];
    b = arr[n-1];
  }

  else {
    a = arr[0];
    b = arr[1];
  }



  
  System.out.println("Product : "+(a*b) + " " + " Pair : "+ a + " & " +b);



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

Product : 6  Pair : 2 & 3
Product : 140  Pair : 10 & 14
Product : 42  Pair : 6 & 7
Product : 20  Pair : -5 & -4


Complexity Analysis :
---------------------------
TC : O(NlogN) - sorting
SC : O(1) 



*/