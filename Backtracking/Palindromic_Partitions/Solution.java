/*



Solution To Use :
 1) Backtracking , recursive method

 
*/


class Solution {

  // check if palindrome
  public static boolean isPalindrome(String str){
    int left = 0 , right = str.length() - 1;
    while(left < right){
      char leftchar = str.charAt(left);
      char rightchar = str.charAt(right);

      if(leftchar  != rightchar){
        return false;
      }

      left++;
      right--;
    } // while end 
      return true;
  }



  public static void palindromic_partition(String str , String so_far){
    
    // base check - check for empty string / length reached till end and string exhausted  ,return so_far

    if(str.length()== 0){
      System.out.println(so_far);
      return;
    }

    for(int i=0 ; i < str.length() ; i++){
      String prefix = str.substring(0,i+1);
      String remaining = str.substring(i+1);

      if(isPalindrome(prefix)){
        palindromic_partition(remaining,so_far+ "(" +prefix + ")");
      }
    }
  }
  
  public static void main(String[] args) {

    String str1 = "nitin";
    String str2 = "aab"; 

    palindromic_partition(str1,"");
    palindromic_partition(str2,"");
   
  }
}


/*


TC : O(n*2^n) : Palindrome fucntion - O(n) and for all possible combination : 2^n
SC : O(2^n)   : As possible partitions generated for each partiton.

*/