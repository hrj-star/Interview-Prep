/*

Solution To Use :
 
 1) DP + Memoization
*/



import java.util.*;

class DP {

static int  numSquares(int n){

  int[] dp = new int[n+1];

  for(int i=1 ; i<=n ;  i++){
    dp[i] = i;

    for(int j=1 ; j*j <=i ; j++){
      dp[i] =Math.min(dp[i] , dp [i-j*j] + 1);
    }
  }

  return dp[n];

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
TC : O(n√n) or O(n * 1.5) : j is the count of integers that square value is less than i .

SC : O(n)



Tags : Arrays , Linear DP , Fibonacci.

*/