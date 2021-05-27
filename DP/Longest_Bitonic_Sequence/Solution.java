/*

Solution To Use :
 
 1) Return length of longest bitonic subsequence

*/



import java.util.*;

class Solution {

 static int longest_bitonic_subsequence(int arr[]){

  int len = arr.length;

  if(arr.length == 0 || arr == null)
    return 0;

  // longest increasing subsequence

  int[] lis =  new int[len];


  // longest decreasing subsequence

  int[] lds =  new int[len];

  // fill both with 1 as lis and lds is atleast 1

  Arrays.fill(lis,1);
  Arrays.fill(lds,1);

  // compute lis from left to right

  for(int i = 1; i < len; i++){ //  lis[0] = 1
    for(int j = 0; j < i; j++){
      if(arr[j] < arr[i]){
        lis[i] = Math.max(lis[i] , lis[j] + 1);
      }
    }
  }

  // compute lds from  right to left

  for(int i = len-2; i >= 0; i--){   //  lds[len - 1] = 1
    for(int j = i + 1; j <= len - 1; j++){
      if(arr[j] < arr[i]){
        lds[i] = Math.max(lds[i] , lds[j] + 1);
      }
    }
  }

  int max = 1 ; // as atleast one element in lbs and its max = Integer.MAX_VALUE

  for(int i = 0; i < len; i++){
    max = Math.max(max , lis[i] + lds[i] -1);
  }


  return max;

}
  

  public static void main(String[] args) {
    int arr1[] = {4,2,5,9,7,6,10,3,1};
   
    
    System.out.println("Length of Longest Bitonic Subsequence is : "+ longest_bitonic_subsequence(arr1));
   
  }
}


/*

Output :
----------------------
Length of Longest Bitonic Subsequence is : 7  //  4  5 9 7 6 3 


Complexity Analysis :
---------------------------
TC : O(n^2) 
SC : O(n) 



*/