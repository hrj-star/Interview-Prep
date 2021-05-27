/*

Solution To Use :
 
 1) Return length of longest increasing subsequence

*/



import java.util.*;

class Solution {

 static int longest_decreasing_subsequence(int arr[]){

  int len = arr.length;

  if(arr.length == 0 || arr == null)
    return 0;

  // longest decreasing subsequence

  int[] lds =  new int[len];


  // fill both with 1 as lds is atleast 1

  Arrays.fill(lds,1);


  // compute lds from left to right

  for(int i = 1; i < len; i++){ //  lds[0] = 1
    for(int j = 0; j < i; j++){
      if(arr[j] > arr[i]){    // only change from lis 
        lds[i] = Math.max(lds[i] , lds[j] + 1);
      }
    }
  }

  int max = 1 ; // as atleast one element in lis and its  max length is 1 or max = Integer.MIN_VALUE

  for(int i = 0; i < len; i++){
    max = Math.max(max , lds[i]);
  }


  return max;

}
  

  public static void main(String[] args) {
    int arr1[] = {15, 27, 14, 38, 63, 55, 46, 65, 85};
   
    
    System.out.println("Length of Longest Decreasing Subsequence is : "+ longest_decreasing_subsequence(arr1));
   
  }
}


/*

Output :
----------------------
Length of Longest Decreasing Subsequence is : 3

//The longest decreasing subsequence is {63, 55, 46}


Complexity Analysis :
---------------------------
TC : O(n^2) 
SC : O(n) 


Extension : Solve in O(nlogn) , Print LDS
Link : 
Tags : Arrays , DP .

*/