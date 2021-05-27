/*

Solution To Use :
 
 1)  Recursive 

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

class DP {

 static int maximum_product_rod_cutting(int n){

 
   if (n == 0 || n == 1) {
      return 0;
    }
    int[] dp= new int[n + 1];
    dp[1] = 0;
    dp[2] = 1;
    
    for(int i=3;i<=n ;i++){
    	for(int j=1;j<=i; j++){
    		dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i - j));
    	}
    }

    return dp[n];

 }

  public static void main(String[] args) {
  	int n1=2;
  	int n2=3;
  	int n3=4;
  	int n4=5;
  	int n5=10;
  	int n6=15;
   

   System.out.println("Maximum Product : " + maximum_product_rod_cutting(n1));
   System.out.println("Maximum Product : " + maximum_product_rod_cutting(n2));
   System.out.println("Maximum Product : " + maximum_product_rod_cutting(n3));
   System.out.println("Maximum Product : " + maximum_product_rod_cutting(n4));
   System.out.println("Maximum Product : " + maximum_product_rod_cutting(n5));
   System.out.println("Maximum Product : " + maximum_product_rod_cutting(n6));


 }
}


/*

Output :
------------------------
Maximum Product : 2
Maximum Product : 3
Maximum Product : 4
Maximum Product : 6
Maximum Product : 36
Maximum Product : 243



Complexity Analysis :
---------------------------
 TC : O(n^2) 
 SC : O(n) , dp array



*/