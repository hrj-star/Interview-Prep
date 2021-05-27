

/*

Solution To Use :
 
 1)  Expected Space Complexity : O(1) / Inplace merge / Without any extra data structure.
 2)  Time Complexity is : O(M.N)

Steps :
----------------

1. Consider each element of arr1[] and ignore it if it is already in the correct order (i.e., the element smallest among all remaining elements).
2. Otherwise, swap it with the smallest element, which happens to be the first element of arr2[] . 
3. After swapping, move the element (now present at arr2[0] at its orrect position in arr2[] to maintain sorted order.

*/



import java.util.*;

class Solution {

 static void  merge_arrays(int arr1[],int arr2[] , int m , int n ){

 	for(int i=0 ; i < m ; i++){

 		if(arr1[i] > arr2[0]){
 			int temp = arr1[i];
 			arr1[i]  = arr2[0];
 			arr2[0]  = temp;


 			int first = arr2[0];
            
            int k;

 			for( k = 1 ; k < n &&  arr2[k] < first ; k++){
 				arr2[k-1] = arr2[k];

 			}

 			arr2[k-1] = first;
 		}
 	 }

  }



  // print helper function

  static void print(int arr[]){
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();

  }
  

  public static void main(String[] args) {

    int m=5;
    int arr1[] = {1, 4, 7, 8, 10};
    int n=3;
    int arr2[] = {2, 3, 9};

    
   
    merge_arrays(arr1,arr2,m,n);
    print(arr1);
    print(arr2);

 }
}


/*

Output :
-------------------------

arr1[] = { 1, 2, 3, 4, 7 }
arr2[] = { 8, 9, 10 }





Complexity Analysis :
---------------------------
TC : O(M * N) 
SC : O(1) - not any extra space.


To - do :
--------------------------
Gap theorem - Intution

*/