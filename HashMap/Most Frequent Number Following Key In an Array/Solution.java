class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
      for(int i=0 ; i < nums.length-1; i++){
            if(nums[i] == key){
                int key_in_map = nums[i+1];
                if(map.containsKey(key_in_map)){
                    int freq = map.get(key_in_map);
                    freq++;
                    map.put(key_in_map , freq);
                }
                else{
                map.put(key_in_map,1);
                }
            }
            
        }
        
        
        int maxi_count = 0, maxi_element = -1;
		for(Map.Entry<Integer,Integer> val : map.entrySet()){
		    if(maxi_count < val.getValue()){
		        maxi_element = val.getKey();
		        maxi_count = val.getValue();
		    }
		}
        
        return maxi_element;
    }
}