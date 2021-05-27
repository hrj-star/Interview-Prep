/*

Solution To Use :
--------------------------
 
 1)  Sorting and Two Pointers.
 2)  Improve Space Complexity.
 3)  Distinct elements only.
 4)  To print triplets.
 

Algorithm :
-------------------------

Sort the given array.
Loop over the array and fix the first element of the possible triplet, arr[i].
Then fix two pointers, one at i + 1 and the other at n – 1. And look at the sum, 
If the sum is smaller than the required sum, increment the first pointer.
Else, If the sum is bigger, Decrease the end pointer to reduce the sum.
Else, if the sum of elements at two-pointer is equal to given sum then print the triplet and break.

*/

import java.util.*;

class Solution3 {

 static void count_triplets(int arr[],int sum ){

 Arrays.sort(arr);

 int n = arr.length;

 for(int i=0; i <= n-3; i++){

  int k = sum-arr[i];
  int left = i+1;
  int right = n-1; // index of last element 

  while(left<right){
    if(arr[left] + arr[right] < k){
      left++;
    }
    else if(arr[left] + arr[right] > k){
      right--;
    }

    else{
      //print triplets

      System.out.println("(" + arr[i] + ", " + arr[left] + ", " +arr[right] + ")");
      
      //increment left , right indexes
      left++;
      right--;
        
       }
     }
   }

}
  

  public static void main(String[] args) {
    int arr1[] = {2, 7, 4, 0, 9, 5, 1, 3};
    int sum1 = 6;
 
    count_triplets(arr1,sum1);
   
  }
}


/*

Output :
------------------------

(0, 1, 5)
(0, 2, 4)
(1, 2, 3)





Complexity Analysis :
---------------------------
TC : O(N^2) 
SC : O(1)  




*/