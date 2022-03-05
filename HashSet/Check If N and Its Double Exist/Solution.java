class Solution {
    public boolean checkIfExist(int[] arr) {
      Set<Integer> set = new HashSet<Integer>();
    
      for(int num : arr){
          if(set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))){
              return true;
          }
          else{
              set.add(num);
          }
      }
        return false;
    }
}

/*
TC : O(n) //avg - lookup - O(1)
SC : O(n) // worst case
*/