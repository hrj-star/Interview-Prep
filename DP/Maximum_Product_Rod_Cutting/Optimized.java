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

class Optimized {

 static int maximum_product_rod_cutting(int n){

  if (n == 2 || n == 3) return (n-1); 
  
    // Keep removing parts of size 3  
    // while n is greater than 4 
    int res = 1; 
    while (n > 4) 
    { 
        n -= 3; 
          
        // Keep multiplying 3 to res 
        res *= 3;  
    } 
      
    // The last part multiplied by  
    // previous parts 
    return (n * res); 

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