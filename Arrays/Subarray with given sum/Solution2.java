/*

Solution To Use :
 
 1) Apply two pointer technique
 2) Unsorted array
 3) Optimized
 4) Return sublist.
*/

import java.util.*;
class Solution2 {

 static int[] subarray(int arr[],int sum , int len){

   int left  = 0;
   int right = 1;
   int currsum = arr[0];

   while(right <= len){

     while(currsum > sum && left < right-1){
       currsum-=arr[left];
       left++;
       }
     

      if(currsum == sum){
        return new int[]{left,right-1};
      }

      if(right < len){
        currsum+=arr[right];
      }

      right++;

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



TC : O(n) : Only one traversal of the array is required. 
SC : O(1) : Constant Extra Space needed.



*/