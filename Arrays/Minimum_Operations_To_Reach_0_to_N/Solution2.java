/*

Solution To Use :
 
 1)  Method 1 : Greedy approach(Apply reverse of question , go from N to 0)

 
*/

import java.util.*;

class Solution {

 static int  minimum_operation(int n){

    int count = 0;
    

    // if n is even , divide else subtract
    while(n != 0){

        if(n % 2 == 0){
            n/=2;
            count++;
        }
        else{
            n-=1;
            count++;
        }
        
    }

    return count;
  }
  

  public static void main(String[] args) {
    int n1=8;
    int n2=7;
   
    System.out.println(minimum_operation(n1));
    System.out.println(minimum_operation(n2));

 }
}


/*

Output :
------------------------

4   Explanation: 0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8

5   Explanation: 0 + 1 = 1, 1 + 1 = 2,1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7



Complexity Analysis :
---------------------------
TC : O(log N) 
SC : O(1) - Auxiliary



*/