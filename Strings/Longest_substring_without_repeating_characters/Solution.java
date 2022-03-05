

/*

Approach : Using HashSet - Sliding Window

*/

import java.util.*;

class Solution{

    public static int substring_without_repetition(String  s){

        int n = s.length();

        // base case
        if(n == 0 || s == null)
            return 0;

        int start = 0;
        int end = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                max = Math.max(set.size(), max);
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return max;
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