/*


Solution To Use :
 
 1) No additional data structure.
 2) When allowed to modify the original string.

*/

import java.util.*;

class Solution_sort {

  public static boolean isUnique(String word){
    char[] characters = word.toCharArray();
    Arrays.sort(characters);
    for(int i=0 ; i < word.length()-1 ; i++){
      if(characters[i] == characters[i+1]){
        return false;
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



TC : = O(nlog(n)) + O (n) [sorting + traversal]
     = O(nlog(n))
SC : O(1)

*/