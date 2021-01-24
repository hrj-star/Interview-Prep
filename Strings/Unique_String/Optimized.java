/*


Solution To Use :
 
 1) No Additional data structure 
 2) Optimized [Space Optimized] : Reduce by factor of 8 by using a bit vector.
 3) Scope of characters is a-z .

*/

import java.util.*;

class Optimized {

  public static boolean isUnique(String word){

    if(word.length() > 26){
      return false;
    }
  
    int checker=0;

    for(int i=0 ; i < word.length() ; i++){

      int val = word.charAt(i)-'a'; // a : 97-97 = 0 , b : 98-97 = 1 , c : 99-97 = 2.. i : 105-97 = 8 ...get 0-25 out of total 32 bits.

      int binaryindex = 1 << val; // Gives index of 1 in binary representation of character : for i =  binaryindex : 10000000

      if((checker & binaryindex) > 0){ // if(0 & 10000000 >0) -> return false 
        return false;
      }

      checker|=binaryindex; // set bits in checker , checker = 100000000(8 bit set in checker)

      // Now , as checker's 8 bit is set , if  i appears immediately , the condition will be : 10000000 & 10000000 = 10000000 > 0 , so return false as i is repeated.

    }
    return true;
  }
  
  public static void main(String[] args) {

    System.out.println(isUnique("hello"));
    System.out.println(isUnique("world"));
   
  }
}


/*



TC : O(n) -- if n <= 26
     O(1) -- if n >  26
     
SC : O(c) where c = character-set size or O(1).

*/