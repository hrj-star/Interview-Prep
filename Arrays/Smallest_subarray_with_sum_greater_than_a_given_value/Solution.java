/*

Solution To Use :
 
 1) Brute Force 
 
*/

import java.util.*;

class Solution {

 static int smallest_subarrays(int arr[],int k , int len){

  int count=Integer.MAX_VALUE;
  for(int i=0;i<len;i++){
    int sum=0;
    for(int j=i;j<len;j++){
      sum+=arr[j];
      if(sum>k){
        count = Math.min(count , j-i+1);
        break;
      }
    }
  }

  return count == Integer.MAX_VALUE ? 0 : count;

  }
  

  public static void main(String[] args) {
    int arr1[] = {1, 4, 45, 6, 0, 19};
    int k1 = 51;

    int arr2[] = {1, 10, 5, 2, 7};
    int k2 = 9;

    int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
    int k3 = 280;

    int arr4[] = {1, 2, 4};
    int k4 = 8;
  
  
   
   
    
    System.out.println(smallest_subarrays(arr1,k1,arr1.length));
    System.out.println(smallest_subarrays(arr2,k2,arr2.length));
    System.out.println(smallest_subarrays(arr3,k3,arr3.length));
    System.out.println(smallest_subarrays(arr4,k4,arr4.length));

   
  }
}


/*

Output :
----------------------
3
1
4
8



Complexity Analysis :
---------------------------
TC : O(n^2) : Two loops
SC : O(1) 



*/