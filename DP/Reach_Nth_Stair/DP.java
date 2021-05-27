/*

Solution To Use :
 
 1)  DP
*/

import java.util.*;

class DP {

 static int climbStairs(int n){
 	int[] dp = new int[n+1];

 	dp[0] = 1;
 	dp[1] = 1;

 	for(int i=2;i<=n;i++)
 		dp[i] = dp[i-1] + dp[i-2];


 	return dp[n]; // last cell holds ans

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
 SC : O(N)   : dp array



*/