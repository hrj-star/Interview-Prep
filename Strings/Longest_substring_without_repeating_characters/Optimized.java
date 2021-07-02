
/*

Approach : Sliding Window

*/
import java.util.*;
class Optimized{


    public static int substring_without_repetition(String  s){

        int n = s.length();

        // base case
        if(n == 0 || s == null)
            return 0;

        int i=0,j=0,max=0;

        Set<Character> set = new HashSet<>();

        while(i < n){
            char c = s.charAt(i);

            while(set.contains(c)){
                //System.out.println("set before"+set);
                set.remove(s.charAt(j)); // if present in set , remove char at j , for reset process
               
                //System.out.println("before " + j);
               // System.out.println("j " + s.charAt(j));
                //System.out.println("set after"+set);
                ++j;
               
            }

            set.add(c);
            max = Math.max(max , i-j+1);
            ++i;
        }

          return max; // as it contains unique elements
    }


	public static void main(String[] args){

		String s1 = "abcabcbb"; // abc
        String s2 = "bbbbb"; // b
        String s3 = "pwwkew"; // wke
        String s4 = ""; // 0
        String s5 = "geeksforgeeks"; // eksforg

        System.out.println(substring_without_repetition(s1)); 
        System.out.println(substring_without_repetition(s2));
        System.out.println(substring_without_repetition(s3));
        System.out.println(substring_without_repetition(s4));
        System.out.println(substring_without_repetition(s5));
	}
    	
}


/*

Solution : 

3
1
3
0
7

Working:
---------------
s = "abcabcbb"

set = a
    = ab
    = abc
    = bc (as a is repeated , j is pointed to first a and gets removed)
    = 




Complexity Analysis :
------------------

TC :  O(n)

SC :  O(26) or O(1).





*/