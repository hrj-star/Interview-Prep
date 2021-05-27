/*

Solution To Use :
 
 1) Bottom Up DP :Recursion + Memoization ( cache results)
 
*/

import java.util.*;

class DP{

 static int nth_fibonacci(int n){

  int[] fibo = new int[n+1]; // 1 extra  for 0 case

  fibo[0] = 0;
  fibo[1] = 1;


  for(int i = 2 ; i<=n ; i++){
  	fibo[i] = fibo[i-1] + fibo[i-2];
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