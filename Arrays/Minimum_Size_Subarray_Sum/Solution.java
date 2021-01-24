/*

Solution To Use :
 
 1) Brute Force 
 
*/

import java.util.*;

class Solution {

 static int minimum_subarrays(int arr[],int k , int len){

  int count=Integer.MAX_VALUE;
  for(int i=0;i<len;i++){
    int sum=0;
    for(int j=i;j<len;j++){
      sum+=arr[j];
      if(sum>=k){
        count = Math.min(count , j-i+1);
        break;
      }
    }
  }

  return count == Integer.MAX_VALUE ? 0 : count;

  }
  

  public static void main(String[] args) {
    int arr1[] = {2,3,1,2,4,3};
    int arr2[] = {1};
    int arr3[] = {1,2};
    int arr4[] = {2,-1,2};
    int k1 = 7;
    int k2 = 1;
    int k3 = 4;
    int k4 = 3;
    
    System.out.println(minimum_subarrays(arr1,k1,arr1.length));
    System.out.println(minimum_subarrays(arr2,k2,arr2.length));
    System.out.println(minimum_subarrays(arr3,k3,arr3.length));
    System.out.println(minimum_subarrays(arr4,k4,arr4.length));

   
  }
}


/*

Output :
----------------------

2 : [4,3] has minimal length as 4+3 = 7 >= k.
1 : [1] has minimal length.
0 : Sum >=4 cannot be made by [1,2].
3 : [2,-1,2] has minimal length.



Complexity Analysis :
---------------------------
TC : O(n^2) : Two loops
SC : O(1) 



*/