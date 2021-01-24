/*

Solution To Use :
 
 1) Optimized
 
*/

import java.util.*;
class Solution {

 static int[] subarray(int arr[],int sum , int len){

   int currsum = 0;
   int left  = 0;
   int right = -1;

   HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

   for(int i=0;i<len;i++){
     currsum+=arr[i];
     
     if(currsum - sum == 0){
       left = 0;
       right = i;
       break;
     }

     if(map.containsKey(currsum - sum)){
       left = map.get(currsum - sum)+1;
       right = i;
       break;

     }

     map.put(currsum, i);
   }
   // if right has same value , then end is reached without subarray.

   if( right == -1){
     return new int[]{-1};
   }
   else{
      return new int[]{left,right};

   }

  }
  
  public static void main(String[] args) {
    int arr1[] = {10, 2, -2, -20, 10};
    int arr2[] = {1, 4, 0, 0, 3, 10, 5};
    int arr3[] = {-10, 0, 2, -2, -20, 10};
    int sum1 = -10;
    int sum2 = 7;
    int sum3 = 20;
    
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

0 3
1 4
-1



TC : O(N)
SC : O(N) : As HashMap needed.



*/