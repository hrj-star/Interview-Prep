/*

Solution To Use :
 
 1)  Optimized
*/

import java.util.*;

class Optimized {

 static int climbStairs(int n){
 	int first = 1, second = 1;
 	int ans = 0;

 	for(int i=2;i<=n;i++){
 		ans = first + second;
 		first = second;
 		second = ans;
 	}


 	return second; // second var has answer stored

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
 TC : O(N) 
 SC : O(1)   : constant space



*/