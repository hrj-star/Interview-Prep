/*

Solution To Use :
 
 1)  Expected Complexity : O(N1+N2)

 
*/

import java.util.*;

class Solution {

 static int[]  merge_arrays(int arr1[],int arr2[] ){


   int[] result = new int[arr1.length + arr2.length];

   int i=0; // for first arr
   int j=0; // for second arr
   int k=0; // for result arr

   while(i < arr1.length && j < arr2.length){

    // compare arr1[i] and arr2[j] , put smaller in result[] and increment
    if(arr1[i] < arr2[j]){   
      result[k++] = arr1[i++];
    }
    else{
      result[k++] = arr2[j++];

    }
   }

   // now fill the result[] with remaining elements of larger array 

   while(i < arr1.length){
    result[k++] = arr1[i++];
   }

    while(j < arr2.length){
    result[k++] = arr2[j++];
   }

   return result;


  }



  // print helper function

  static void print(int arr[]){
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
  }
  

  public static void main(String[] args) {
  
    int arr1[] = {1, 3, 5, 7};
    int arr2[] = {0, 2, 6, 8, 9};

    
   
    int[] ans=merge_arrays(arr1,arr2);
    print(ans);

 }
}


/*

Output :
------------------------

0 1 2 3 5 6 7 8 9.


1



Complexity Analysis :
---------------------------
TC : O(N1+N2) - (Linear) : Only one traversal of the array is needed.
SC : O(N1+N2) 



*/