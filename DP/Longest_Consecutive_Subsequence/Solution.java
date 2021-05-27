/*

Solution To Use :
 
 1) Brute Force
 2) Return length of longest consecutive subsequence

*/



import java.util.*;

class Solution {


 static boolean linearSearch(int element , int arr[] , int n){

 	for(int i=0;i<n;i++){
 		if(arr[i] == element){
 			return true;
 		}
 	}

 	return false;
 }

 static int longest_consecutive_subsequence(int arr[]){

  int len = arr.length;

  if(arr.length == 0 || arr == null)
    return 0;

  int max = Integer.MIN_VALUE;

  for(int i=0;i<len;i++){
  	int next = arr[i]+1;
  	int current_max = 1;

  	while(linearSearch(next , arr , len) == true){
  		current_max += 1;
  		next += 1;
  	}
  	max = Math.max(max , current_max);
  }
  
 
  return max;

}
  

  public static void main(String[] args) {
    int arr1[] = { 1, 9, 3, 10, 4, 20, 2};
   
    
    System.out.println("Length of Longest Consecutive Subsequence is : "+ longest_consecutive_subsequence(arr1));
   
  }
}


/*

Output :
----------------------
Length of Longest Consecutive Subsequence is : 4

//The longest consecutive subsequence is 1, 3, 4, 2


Complexity Analysis :
---------------------------
TC : O(n^3) --> for loop (n) , while loop (n) , linear search worst case (n)
SC : O(1) 



Tags : Arrays , DP .

*/