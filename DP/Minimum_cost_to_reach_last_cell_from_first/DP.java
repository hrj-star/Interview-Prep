/*

Solution To Use :
 
 1) Optimized DP - Bottom Up Approach
 2) findCost(i,j, cost) = cost(i,j) + Min( findCost(i-1,j, cost), findCost(i,j-1, cost))
*/

import java.util.*;

class DP {

 static int minimum_cost(int cost[][]){

  int m = cost.length;
  int n = cost[0].length;

  // initialize DP array
  int[][] dp = new int[m][n];


for(int i=0 ; i<m ; i++ ){

  for(int j=0 ; j<n ; j++){

    dp[i][j] = cost[i][j];

    // cost of first row = current + adjacent left cell
     if(i == 0 && j > 0){
      dp[0][j] += dp[0][j-1];
    }
     

    // cost of first column = current + adjacent top cell
      else if(j == 0 && i > 0){
        dp[i][0] += dp[i-1][0];
      }


    // else fill for rest 
      else if (i > 0 && j > 0){
        dp[i][j] += Math.min(dp[i-1][j] , dp[i][j-1]);
      }

   }
}
 

return dp[m-1][n-1];


}
  

  public static void main(String[] args) {
   
    
    int[][] cost =
    {
        { 4, 7, 8, 6, 4 },
        { 6, 7, 3, 9, 2 },
        { 3, 8, 1, 2, 4 },
        { 7, 1, 7, 3, 7 },
        { 2, 9, 8, 9, 3 }
    };
 

    System.out.println("Minimum cost is : " + minimum_cost(cost));

  }
}


/*

Output :
------------------------

Output : Total paths are : 6 



Complexity Analysis :
---------------------------
TC : O(m * n)
SC : O(m * n) - auxiliary space





*/