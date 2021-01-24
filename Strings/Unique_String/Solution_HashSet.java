/*

Solution To Use :
 
 1) Additional data structure - HashSet.
 
 
*/

import java.util.*;

class Solution_HashSet {

  public static boolean isUnique(String word){

    boolean isUnique=true;
    HashSet<Character> set= new HashSet<Character>();
    
    for(int i=0 ; i < word.length() ; i++){
      char val = word.charAt(i);
      if(!set.add(val)){ //Already present in set
        isUnique = false;
        break;
      }
    }
    return isUnique;
  }
  
  public static void main(String[] args) {

    System.out.println(isUnique("hello"));
    System.out.println(isUnique("world"));
   
  }
}


/*



TC : O(n) or O(1) [if ignored the string length].
     
SC : O(n)

*/