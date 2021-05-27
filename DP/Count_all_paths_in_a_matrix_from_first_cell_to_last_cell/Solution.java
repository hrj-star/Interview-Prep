/*

Solution To Use :
 
 1) Recursion.
 
*/

import java.util.*;

class Solution {

 static int count_paths(int m , int n){

  // fill 1 for 1st row , 1st column as there is only way to reach them

  if( m ==1 || n==1){
    return 1;
  }

// else return top + left cell addition 

  return count_paths(m-1 , n) + count_paths(m , n-1);

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
TC : Exponential as its  recursive  and uses overlapping subproblems . 
     The problem has an optimal substructure as solution to problem can be derived using solutions to its subproblems.

     Thus , this can be solved by DP.








*/