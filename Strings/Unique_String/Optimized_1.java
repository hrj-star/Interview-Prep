/*

Solution To Use :
 
 1) Additional data structure -[boolean array].
 2) Optimized.
 3) Assume characters as ASCII and 128-character set or 256-c set.
 
*/

import java.util.*;

class Optimized_1 {

  public static boolean isUnique(String word){

    //  return false in length > 128

    if(word.length()>128){
      return false;
    }

    boolean[] characters = new boolean[128];
  
    for(int i=0 ; i < word.length() ; i++){
      int val = word.charAt(i); // a : 97 , b : 98 ....
      if(characters[val]){ //Already found this char in string
        return false;
      }
      characters[val] = true;
    }
    return true;
  }
  
  public static void main(String[] args) {

    System.out.println(isUnique("hello"));
    System.out.println(isUnique("world"));
   
  }
}


/*



TC : O(n) -- if n <= 128
     O(1) -- if n >  128
     
SC : O(c) where c = character-set size or O(1).

*/