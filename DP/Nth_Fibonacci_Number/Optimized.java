/*

Solution To Use :
 
 1) Space Optimized - Bottom Up DP
 
*/

import java.util.*;

class Optimized{

 static int nth_fibonacci(int n){

  if( n == 0 || n == 1 ){
    return n;
  }

  int a = 0 , b = 1 , c;

  for(int i = 2 ; i <= n ; i++){
    c = a+b ;
    a = b ;
    b = c ;
  }

  return b;

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
SC : O(1) 





*/