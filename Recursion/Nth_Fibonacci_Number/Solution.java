/*

Solution To Use :
 
 1) Recursion (Top Down Approach)
 
*/

import java.util.*;

class Solution{

 static int nth_fibonacci(int n){

  if(n <= 1)
    return n;

  return nth_fibonacci(n-1) + nth_fibonacci(n-2);

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
TC : Expotential or O(2 ^ n) 
SC : O(n) [Extra Space] or O(1)


Optimization :
---------------------------

DP or iterative



*/