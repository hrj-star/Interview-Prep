/*

Solution To Use :
 
 1) Return length of longest increasing subsequence

*/



import java.util.*;

class Solution {

 public static void main(String[] args) {
    int arr1[] = {3, 10, 2, 1, 20};
   
    
    System.out.println("Length of Longest Increasing Subsequence is : "+ longest_increasing_subsequence(arr1));

    System.out.println("Length of Longest Increasing Subsequence(Bottom up) is : "+ longest_increasing_subsequence_BU(arr1));
   
  }

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

  int max = 1 ; // as atleast one element in lis and its  max length is 1 -- avoid max = Integer.MIN_VALUE on online judge

  for(int i = 0; i < len; i++){
    max = Math.max(max , lis[i]);
  }


  return max;

}

static int longest_increasing_subsequence_BU(int arr[]){

  int len = arr.length;

  // base case

  if(len == 0){
    return 0;
  }

  int[] lis = new int[len];

  lis[0] = arr[0]; // fill 1st with 1st

  int lis_len = 1;

  for(int i=1;i<len;i++){
    if(arr[i] > lis[lis_len - 1]){ // eg : 0 then just add 4  after 0 --  0 4 , increase length
      lis[lis_len] = arr[i];  
      lis_len++;
    } 
    else{ // eg : 0 8 and 4 encountered then search next increasing of 4 and change to 0 4 

      int to_replace_next_inc = binarySearch(lis , 0 ,lis_len - 1 ,arr[i]);
      lis[to_replace_next_inc] = arr[i]; 
    }
  }

  return lis_len;
}


public static int binarySearch(int[] lis, int si , int ei , int item){ // for immediate next increasing number
  int low = si;
  int high = ei;

  while(low <= high){
    int mid = (low + high) / 2;

    if(item > lis[mid]){
      low = mid + 1;
    }
    else{
      high = mid - 1;
    }
  }

  return low;
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

Bottom UP : O(nlogn)
SC : O(n)

Extension : Solve in O(nlogn) , Print LIS

https://leetcode.com/problems/longest-increasing-subsequence/discuss/74880/JAVA-Easy-Version-To-Understand!!!!!!!!

Tags : Arrays , DP .

*/