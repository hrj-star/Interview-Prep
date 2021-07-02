/*

Solution To Use :
 
 1) Optimized
 2) As there are negative numbers also , using HashMap is better than Sliding window.
 
*/

import java.util.*;

class Optimized {

 static int count_subarrays(int arr[],int k , int len){

  Map<Integer,Integer> prevSum = new HashMap<>();
  
  // initial case  when (sum-k = 0) means current subarray is valid . 
  prevSum.put(0,1); // Initialize

  int count=0,sum=0;

  for(int i=0;i<len;i++){

    sum += arr[i]; // sum so far
    if(prevSum.containsKey(sum - k)){
      count += prevSum.get(sum-k);
    }
     // if (sum-k) is seen before , there exists subarray with given sum , increase count
    prevSum.put(sum,prevSum.getOrDefault(sum,0)+1); // if already exists then add value by 1 else 0 .

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
TC : O(n)
SC : O(n) 



*/