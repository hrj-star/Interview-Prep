/*



Solution To Use :
 1) No additional data structure.
 2) Brute Force.
 
*/


class Solution {

  public static boolean isUnique(String word){
    int len = word.length();
    for(int i=0;i<len-1;i++){
      char selected = word.charAt(i);
        for(int j=i+1;j<len;j++){
          if(selected == word.charAt(j)){
            return false;
          }
        }
    }

    return true;
  }
  
  public static void main(String[] args) {

    System.out.println(isUnique("hello"));
    System.out.println(isUnique("world"));
   
  }
}


/*
The above method has two nested for-loops. Given a String with n number of characters, the outer loop iterates n - 1 times. The inner loop iterates n - 1 times for the first time, n - 2 times for the second time, n - 3 times for the third time and only one time for the last time. So the time complexity can be written as:
T(n) = O(n - 1) + O (n - 2) + O(n - 3) + ... + 2 + 1
     = O(n - 1) * O(n) / 2
     = O(n^2)


TC : O(n^2)
SC : O(1)

*/