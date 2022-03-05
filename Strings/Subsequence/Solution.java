class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        // corner case - if input string empty , return true
        if(sLen == 0){
            return true;
        }
        
        int indexS = 0 , indexT = 0;
        
        // traverse both s and t simultaneously , if same then increment both simultaneously else increment t pointer
        while(indexS < sLen &&  indexT < tLen){
            if(s.charAt(indexS) == t.charAt(indexT)){
               indexS++;
            }
            indexT++;
        }
        return indexS == sLen; // returns true meaning all chars of s are found in t
    }
}

/*

TC : O(sLen + tLen) / O(min(sLen , tLen))
SC : O(1)

Runtime: 1 ms, faster than 88.36% of Java online submissions for Is Subsequence.
Memory Usage: 42.1 MB, less than 28.44% of Java online submissions for Is Subsequence.


To - do : Follow - up

*/
