/*

Solution To Use :
 
 1) Optimized 
 2) Return length of longest consecutive subsequence.


*/



import java.util.*;

class Optimized {


 static int longest_consecutive_subsequence(int arr[]){

  int len = arr.length;

  if(arr.length == 0 || arr == null)
    return 0;



  Set<Integer> set = new HashSet<>();

  // insert all the elements in set
  for(int num : arr){
    set.add(num);
  }


  int max = Integer.MIN_VALUE; // stores max length for consecutives


  for(int num : set){  
    if(!set.contains(num -1)){  // this condition stops duplicate scans for consecutives
        int next = num + 1;
        int current_max = 1;

      while(set.contains(next)){
        current_max += 1;
        next += 1;
      } // while end

      max = Math.max(max , current_max);
    } // if end
  } // for end

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
TC : O(n) 
SC : O(n) 



Tags : Arrays , DP .

*/