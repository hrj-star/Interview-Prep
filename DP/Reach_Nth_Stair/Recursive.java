/*

Solution To Use :
 
 1)  Brute force - recursive
*/

import java.util.*;

class Recursive {

 static int climbStairs(int n){
 	if(n == 0 || n == 1)
 		return 1;

 	else
 		return climbStairs(n-1) + climbStairs(n-2);

  }
  

  public static void main(String[] args) {
  	int n1=4;
  	int n2=10;
   

   System.out.println("Ways : " + climbStairs(n1));
   System.out.println("Ways : " + climbStairs(n2));


 }
}


/*

Output :
------------------------
Ways : 5
Ways : 89



Complexity Analysis :
---------------------------
 TC : O(2^n) : exponential - as two step problem 
 SC : O(1)   : constant space



*/