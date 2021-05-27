/*

Solution To Use :
 
 1) Recursion 

*/



import java.util.*;

class Solution {

 
static int func(int n){
  // base cases 

  if(n < 0)
    return Integer.MAX_VALUE;


  if(n <= 3)
    return n;

  int min = n ; // obvious case , 12 -> made from 12 * 1^2

  for(int i=1; i*i <= n ; i++){
    min = Math.min(func(n-(i*i)) , min);

  }
  
  return min + 1;


}

static int  numSquares(int n){

  return func(n);


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
TC : Exponential



Tags : Arrays , Linear DP , Fibonacci.

*/