/*

Solution To Use :
 
 1) Brute Force 
 
*/

import java.util.*;

class Solution {

 static int count_subarrays(int arr[],int k , int len){

  int count=0;
  for(int i=0;i<len;i++){
    int sum=0;
    for(int j=i;j<len;j++){
      sum+=arr[j];
      if(sum==k){
        count++;
      }
    }
  }

  return count;

  }
  

  public static void main(String[] args) {
    int arr1[] = {1,1,1};
    int arr2[] = {1,2,3};
    int arr3[] = {10, 2, -2, -20, 10};
    int k1 = 2;
    int k2 = 3;
    int k3 = -10;
    
    System.out.println(count_subarrays(arr1,k1,arr1.length));
    System.out.println(count_subarrays(arr2,k2,arr2.length));
    System.out.println(count_subarrays(arr3,k3,arr3.length));

   
  }
}


/*

Output :
-------------
2
2
3

Complexity Analysis :
---------------------------
TC : O(n^2)
SC : O(1) : Constant Extra Space needed.



*/