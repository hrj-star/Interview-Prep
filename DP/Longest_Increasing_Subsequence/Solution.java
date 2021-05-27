/*

Solution To Use :
 
 1) Return length of longest increasing subsequence

*/



import java.util.*;

class Solution {

 static int longest_increasing_subsequence(int arr[]){

  int len = arr.length;

  if(arr.length == 0 || arr == null)
    return 0;

  // longest increasing subsequence

  int[] lis =  new int[len];


  // fill both with 1 as lis  is atleast 1

  Arrays.fill(lis,1);


  // compute lis from left to right

  for(int i = 1; i < len; i++){ //  lis[0] = 1
    for(int j = 0; j < i; j++){
      if(arr[j] < arr[i]){
        lis[i] = Math.max(lis[i] , lis[j] + 1);
      }
    }
  }

  int max = 1 ; // as atleast one element in lis and its  max length is 1 or max = Integer.MIN_VALUE

  for(int i = 0; i < len; i++){
    max = Math.max(max , lis[i]);
  }


  return max;

}
  

  public static void main(String[] args) {
    int arr1[] = {3, 10, 2, 1, 20};
   
    
    System.out.println("Length of Longest Increasing Subsequence is : "+ longest_increasing_subsequence(arr1));
   
  }
}


/*

Output :
----------------------
Length of Longest Increasing Subsequence is : 3

//The longest increasing subsequence is 3, 10, 20


Complexity Analysis :
---------------------------
TC : O(n^2) 
SC : O(n) 


Extension : Solve in O(nlogn) , Print LIS

https://leetcode.com/problems/longest-increasing-subsequence/discuss/74880/JAVA-Easy-Version-To-Understand!!!!!!!!

Tags : Arrays , DP .

*/