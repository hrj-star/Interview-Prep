/*

Solution To Use :
 
 1) Space Optimized DP.
 
*/

import java.util.*;

class Optimized{

 static int count_paths(int m , int n){

  // initialize 1D  DP array

  int[] count = new int[n];

  // initialize count[0] = 1

  count[0] = 1;

  for(int i=0 ; i< m ; i++){
    for(int j=1 ; j<n ; j++){
      count[j] += count[j-1];
    }
  }

// ans at last cell

  return count[n-1];
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
SC : O(n) 





*/