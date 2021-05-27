/*

Solution To Use :
 
 1) Optimized DP - Bottom Up Approach
 
*/

import java.util.*;

class DP {

 static int count_paths(int m , int n){

  // initialize DP array

  int[][] count = new int[m][n];

  // fill 1st row

  for(int j=0 ; j<n ;j++){
    count[0][j] = 1;
  }


  // fill 1st column

  for(int i=0 ; i<m ;i++){
    count[i][0] = 1;
  }

  for(int i=1 ; i< m ; i++){
    for(int j=1 ; j<n ; j++){
      count[i][j] = count[i-1][j] + count[i][j-1];
    }
  }

// ans at last cell

  return count[m-1][n-1];

  }
  

  public static void main(String[] args) {
    int m=3 , n=3 ;
    
    int total_paths =count_paths(m,n);

    System.out.println("Total paths are : " + total_paths);

  }
}


/*

Output :
------------------------

Output : Total paths are : 6 



Complexity Analysis :
---------------------------
TC : O(m * n)
SC : O(m * n) - auxiliary space , can be reduced to O(n) by a 1D array rather than a 2D.





*/