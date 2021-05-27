/*

Solution To Use :
 
 1) Formula : Fn = {[(√5 + 1)/2] ^ n} / √5 

 Ref : http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html 
 
*/

import java.util.*;

class Optimized2{

 static int nth_fibonacci(int n){

 double ans = (1 + Math.sqrt(5)) / 2 ;

 return (int) Math.round( Math.pow(ans , n) / Math.sqrt(5) );

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
TC : O(1)
SC : O(1) 





*/