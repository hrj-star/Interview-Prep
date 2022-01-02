/*

Solution To Use :
 
 1) Bottom Up DP : Memoization ( cache results)
 
*/

import java.util.*;

class DPRecursive_Memo{

 static int nth_fibonacci(int n){

  int[] fibo = new int[n+1]; // 1 extra  for 0 case -- initially array with all 0's


  if(fibo[n] != 0){
    return fibo[n];

  }
  
  if(n == 0 || n == 1){
    fibo[n] = n;
  }
  else{
    fibo[n] = nth_fibonacci(n-1) + nth_fibonacci(n-2);
  }

  return fibo[n];
}
  

  public static void main(String[] args) {
    int n = 8;

    System.out.println("Nth Fibonacci Number is : " + nth_fibonacci(n));

  }
}


/*

Output :
------------------------

Nth Fibonacci Number is : 21



Complexity Analysis :
---------------------------
TC : O(n)
SC : O(n) 





*/