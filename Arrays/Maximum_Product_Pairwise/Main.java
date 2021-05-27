/*

Solution To Use :
 
 1)  Brute Force
*/

import java.util.*;

class Main {

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

  int a = arr[0] , b = arr[1];

  for(int i=0 ;i<n ;i++){
    for(int j=i+1 ; j<n ;j++){
      if(arr[i] * arr[j] > a*b){
        a = arr[i];
        b = arr[j];
      }
    }
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
Product : 140  Pair : 14 & 10
Product : 42  Pair : 6 & 7
Product : 20  Pair : -4 & -5


Complexity Analysis :
---------------------------
TC : O(N^2) - 2 loops.
SC : O(1) 



*/