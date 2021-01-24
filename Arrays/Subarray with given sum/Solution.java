/*

Solution To Use :
 
 1) Brute Force 
 
*/

import java.util.*;
class Solution {

 static int[] subarray(int arr[],int sum , int len){

   
   int currsum ;

 // outer loop start from 0
   for(int i=0;i<len;i++){
// assign current value to the value at ith index
     currsum = arr[i];

  // inner loop starts from i+1

     for(int j=i+1;j<=len;j++){

       // if equal , return indexes
       if(currsum == sum){
         return new int[]{i , j-1};
       }
      
      // if currsum exceeds sum , then break
       if(currsum > sum){
         break;
       }

       if(j<len){
         currsum+=arr[j]; 
       }

     }

   }

  

    return new int[]{-1};
    
  }
  
  public static void main(String[] args) {
    int arr1[] = {1, 4, 20, 3, 10, 5};
    int arr2[] = {1, 4, 0, 0, 3, 10, 5};
    int arr3[] = {1, 4};
    int sum1 = 33;
    int sum2 = 7;
    int sum3 = 0;
    
    int result1[] = subarray(arr1,sum1,arr1.length);
    int result2[] = subarray(arr2,sum2,arr2.length);
    int result3[] = subarray(arr3,sum3,arr3.length);

    for(int val : result1){
      System.out.print(val+" ");
    }
    for(int val : result2){
      System.out.print(val+" ");
    }
    for(int val : result3){
      System.out.print(val+" ");
    }
   
  }
}


/*

Output :

2 4
1 4
No subarray found



TC : O(n^2)
SC : O(1) : Constant Extra Space needed.



*/