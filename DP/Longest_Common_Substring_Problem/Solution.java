/*



Solution To Use :
 1) No additional data structure.
 2) Brute Force.
 
*/


class Solution {

  public static void longest_common_substring(String X ,String Y , int m , int n){

    int[][]dp = new int[m+1][n+1];

    int maxlen = 0;
    int ending_index = m;

    for(int i=1;i<=m;i++){
      for(int j=1;j<=n;j++){
        char char_X = X.charAt(i-1);
        char char_Y = Y.charAt(j-1);

        if( char_X != char_Y){
          dp[i][j] = 1;
        }
        else{
          dp[i][j] = dp[i-1][j-1] + 1; 
        }


        if(dp[i][j] > maxlen){
          maxlen = dp[i][j] ;
          ending_index = i ; 
        }

      }
    }


// print lcs & length

System.out.println("Longest common substring is : " + X.substring(ending_index - maxlen,ending_index) + " of length " + maxlen);
 

  }
  
  public static void main(String[] args){

    String X = "GOOGLELENS";
    String Y = "GOOGLEEARTH";

    int m = X.length();
    int n = Y.length();


    longest_common_substring(X,Y,m,n);
 
   
  }
}


/*

Output

----------------

Longest common substring is : GOOGLE of length 6


Complexity
--------------

TC : O(m*n)
SC : O(m*n) extra space.

*/