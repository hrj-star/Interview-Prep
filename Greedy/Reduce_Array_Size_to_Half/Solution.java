class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int nums : arr){
            map.put(nums , map.getOrDefault(nums,0) +  1);
        }
        
        int n = arr.length;
        List<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq, Collections.reverseOrder());
        
        int upto = n;
        int i = 0;
        int count = 0;
        while(upto > n/2){
            upto -=freq.get(i);
            i++;
            count++;
        }
        return count;
    }
}


/*
Complexity Analysis :
-------------------------

TC : O(nlogn)
SC : O(n)

*/