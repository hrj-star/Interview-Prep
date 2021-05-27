/*

Solution To Use :
 
 1)  Method 3 : Works for +ve numbers 
 
*/

import java.util.*;

class Optimized_1 {

 static int   duplicate_number(int arr[]){

    int n = arr.length;

    for(int i=0;i<n;i++){
      if(arr[Math.abs(arr[i])] >= 0){
        arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
      }
      else{
        return  Math.abs(arr[i]);
      }
    }

   return -1 ; // no duplicates

}
  

  public static void main(String[] args) {
 
    int arr1[] = {1, 2, 3, 4, 4};
    int arr2[] = {1, 2, 3, 4, 2};
    int arr3[] = {1, 2, 3 ,5 ,4 ,2};
  
   
    System.out.println("Duplicate: " +  duplicate_number(arr1));
    System.out.println("Duplicate: " +  duplicate_number(arr2));
    System.out.println("Duplicate: " +  duplicate_number(arr3));

 }
}


/*

Output :
------------------------

Duplicate: 4
Duplicate: 2
Duplicate: 2


Complexity Analysis :
---------------------------
TC : O(N) - Only one traversal of the array is needed.
SC : O(1) - constant space



*/