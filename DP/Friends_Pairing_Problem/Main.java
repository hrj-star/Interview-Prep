/*

Solution To Use :
 
 1)  DP

f(n) = ways n people can remain single 
       or pair up.

For n-th person there are two choices:
1) n-th person remains single, we recur 
   for f(n - 1)
2) n-th person pairs up with any of the 
   remaining n - 1 persons. We get (n - 1) * f(n - 2)

Therefore we can recursively write f(n) as:
f(n) = f(n - 1) + (n - 1) * f(n - 2)


*/

import java.util.*;

class Main {

 static int countFriendsPairings(int n){

 	int[] dp =  new int[n+1];
 	
 	dp[1] = 1;
 	dp[2] = 2;

 	for(int i=3; i<=n ; i++){
 		dp[i] = dp[i-1] + (i-1)*dp[i-2];
 	}

 	return dp[n];
 	

  }
  

  public static void main(String[] args) {
  	int n1=3;
  	int n2=4;
   

   System.out.println("Total pairs: " + countFriendsPairings(n1));
   System.out.println("Total pairs : " + countFriendsPairings(n2));


 }
}


/*

Output :
------------------------
Total pairs: 4
Total pairs : 10



Complexity Analysis :
---------------------------
 TC : O(N) 
 SC : O(N)   : dp array



*/