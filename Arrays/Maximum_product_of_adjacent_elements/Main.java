

import java.util.*;

class Main {

 static void  maximum_product_adjacent(int arr[],int n){


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

  int maxi = arr[0] * arr[1];

  for (int i=1 ; i < n-1 ;i++){

    if(arr[i] * arr[i+1] > maxi){
      maxi = arr[i] * arr[i+1];
      a = arr[i];
      b = arr[i+1];
    }
  } // end for 

  System.out.println("Product : "+ maxi + " " + " Pair : "+ a + " & " +b);

}
  

  public static void main(String[] args) {
    int arr1[] = {1, 2, 3};
    int arr2[] = {7 ,5 ,14 ,2 ,8 ,8 ,10 ,1 ,2 ,3};
    int arr3[] = {1, 4, 3, 6, 7, 0};
    int arr4[] = {-1, -3, -4, 2, 0, -5 };
    int arr5[] = {3, 6, -2, -5, 7, 3};
    int arr6[] = {3};
    int arr7[] = {10,6};
   
 
    maximum_product_adjacent(arr1,arr1.length);
    maximum_product_adjacent(arr2,arr2.length);
    maximum_product_adjacent(arr3,arr3.length);
    maximum_product_adjacent(arr4,arr4.length);
    maximum_product_adjacent(arr5,arr5.length);
    maximum_product_adjacent(arr6,arr6.length);
    maximum_product_adjacent(arr7,arr7.length);
 }
}


/*

Output :
------------------------

Product : 6  Pair : 2 & 3
Product : 80  Pair : 8 & 10
Product : 42  Pair : 6 & 7
Product : 12  Pair : -3 & -4
Product : 21  Pair : 7 & 3
No pairs exists
Product : 60  Pair : 10 & 6


Complexity Analysis :
---------------------------
TC : O(N) 
SC : O(1) 



*/