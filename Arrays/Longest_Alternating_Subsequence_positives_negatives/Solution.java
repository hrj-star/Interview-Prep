/*

Solution To Use :
 
 1)  Optimized 
*/

import java.util.*;

class Solution {

 static int  longest_alternating_subsequence(int arr[],int n){

  if (arr == null || arr.length == 0) {
    return 0  ;
  }


// do 


  }
  

  public static void main(String[] args) {
    int arr1[] = {-4, 3, -5, 9, 10, 12, 2, -1};
    int arr2[] = {10, 12, 2, -1};
   

   System.out.println("Longest Alternating Subsequence : " + longest_alternating_subsequence(arr1,arr1.length));
   System.out.println("Longest Alternating Subsequence : " + longest_alternating_subsequence(arr2,arr2.length));


 }
}


/*

Output :
------------------------
Longest Alternating Subsequence : 5
Longest Alternating Subsequence : 2



Complexity Analysis :
---------------------------
TC : O(N) - scans entire array once.
SC : O(1) - constant space



*/