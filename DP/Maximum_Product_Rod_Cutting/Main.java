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

class Main {

 static int maximum_product_rod_cutting(int n){

 	if(n <= 1){
 		return 0;
 	}
  


 	int maxi = n; // eg : 4 length = max 4 product , rod of length n has at least cost of n

 	for(int i=1 ;i<=n ;i++){
 		maxi = Math.max(maxi, i * maximum_product_rod_cutting(n-i));
 	}

 	return maxi;

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
 TC : O(n^n) , exponential
 SC : Stack call space   



*/