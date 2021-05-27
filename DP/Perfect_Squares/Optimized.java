/*

Solution To Use :
 
 1) Optimized

By Lagrange’s four-square theorem, every natural 
number can be represented by sum of of four 
integer squares.
And it can be represented by sum of three 
integer squares if and only if it’s not in form 
4^k(8m + 7).

*/



import java.util.*;

class Optimized {

static int  numSquares(int n){

  if (isPerfectSquare(n)) 
    return 1;

  while (n % 4 == 0)
    n /= 4;

  if (n % 8 == 7)
   return 4;

  for (int i = 1; i * i <= n; i++) {
    if (isPerfectSquare(n - i * i))
     return 2;
      }
      return 3;
  }

    private static boolean isPerfectSquare(int i) {
        int a = (int) Math.sqrt(i);
        return a * a == i;
    }


  

  public static void main(String[] args) {
    int n1 = 12;
    int n2 = 13;
   
    
    System.out.println(numSquares(n1));
    System.out.println(numSquares(n2));
  }
}


/*

Output :
----------------------
3  // 12 -> 2^2 + 2^2 + 2^2
2  // 13 -> 3^2 + 2^2



Complexity Analysis :
---------------------------
TC : O(√n)

SC : O(1)



Tags : Arrays , Linear DP , Fibonacci.

*/