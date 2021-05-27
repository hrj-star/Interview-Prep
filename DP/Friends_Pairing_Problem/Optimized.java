/*

Solution To Use :
 
 1)  Optimized : Fibonacci solution.

f(n) = ways n people can remain single 
       or pair up.

For n-th person there are two choices:
1) n-th person remains single, we recur 
   for f(n - 1)
2) n-th person pairs up with any of the 
   remaining n - 1 persons. We get (n - 1) * f(n - 2)

Therefore we can recursively write f(n) as:
f(n) = f(n - 1) + (n - 1) * f(n - 2)

Thus , from the formula , only two values - previous , and previous of previous are needed.
This is done by Fibonacci logic.


*/

import java.util.*;

class Optimized {

 static int countFriendsPairings(int n){
 	
 	
 	int a = 1; // acts as previous of previous
 	int b = 2; // acts as previous 
 	int c = 0 ; // stores current value

 	for(int i=3; i<=n ; i++){
 		c = b + (i-1)*a;
 		a = b;
 		b = c;
 	}

 	return b;
 	

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
 SC : O(1)   : constant



*/