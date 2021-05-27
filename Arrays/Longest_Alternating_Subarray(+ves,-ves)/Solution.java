/*

Solution To Use :
 
 1)  Optimized
 2)  +ves as well as -ves.
 
*/

import java.util.*;

class Solution {

 static void  longest_alternate_subarray(int arr[],int n){

  // length of longest alternating subarray found so far

  int maxlen = 1; // single element is longest alternating subsequence


  // ending index of longest alternating subarray found so far

  int endIndex = 0 ;


  // length of longest alternating subarray ending at the current position

  int currLen = 1;

  for(int i=1; i<n; i++){

    // if current and previous have opposite signs

    if(arr[i] *  arr[i-1] < 0){
      currLen++;

      if(currLen > maxlen){
        maxlen = currLen;
        endIndex = i;
      }
    }

    // reset currLen  if both have same signs

    else{
      currLen = 1;
    }
  }

  int[] subarray = Arrays.copyOfRange(arr, (endIndex - maxlen + 1), endIndex + 1);

  System.out.println("Longest Alternating  Subarray is " + Arrays.toString(subarray));



  }
  

  public static void main(String[] args) {

   int arr[] = { 1, -2, 6, 4, -3, 2, -4, -3};

   longest_alternate_subarray(arr,arr.length);
 }
}


/*

Output :
------------------------

Longest Alternating  Subarray is [4, -3, 2, -4]



Complexity Analysis :
---------------------------
TC : O(N) 
SC : O(N) - extra  space



*/