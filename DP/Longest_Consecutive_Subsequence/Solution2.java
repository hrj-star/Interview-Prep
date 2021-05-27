/*

Solution To Use :
 
 1) Optimized than Brute Force - exclude the linear search logic for array instead perform lookup in set.
 2) But space complexity becomes O(n)
 3) Return length of longest consecutive subsequence.


*/



import java.util.*;

class Solution2 {


 static int longest_consecutive_subsequence(int arr[]){

  int len = arr.length;

  if(arr.length == 0 || arr == null)
    return 0;

  int max = Integer.MIN_VALUE;

  Set<Integer> set = new HashSet<>();

  // insert all the elements in set


  for(int i=0;i<len;i++){
    set.add(arr[i]);
  }

  for(int i=0;i<len;i++){
  	int next = arr[i]+1;
  	int current_max = 1;

  	while(set.contains(next)){
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
TC : O(n^2) --> O(n) . O(n) * O(1) = O(n)
SC : O(n) 



Tags : Arrays , DP .

*/