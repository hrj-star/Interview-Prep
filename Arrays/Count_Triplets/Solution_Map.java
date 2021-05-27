/*

Solution To Use :
 
 1)  Using HashMap.
 
*/

import java.util.*;

class Solution_Map {

 static int count_triplets(int arr[],int n){

  int count=0;

 Map<Integer,Integer> map = new HashMap<>();

 for(int i=0;i<n;i++){
  map.put(arr[i],1); // or map.put(arr[i],i);
 }

 // System.out.println(map); map: {1=1, 2=1, 3=1, 5=1}

 for(int i=0;i<n;i++){
  for(int j=i+1;j<n;j++){
    if(map.containsKey(arr[i]+arr[j])){
      count++;
    }
  }
 }

  return count;

  }
  


  public static void main(String[] args) {
    int arr1[] = {1, 5, 3, 2};
  
    int arr2[] = {2, 3, 4};
   
    System.out.println(count_triplets(arr1,arr1.length));
    System.out.println(count_triplets(arr2,arr2.length));
  }
}


/*

Output :
------------------------

2  - There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5 

0  - No triplet exists




Complexity Analysis :
---------------------------
TC : O(N^2) : 2 loops
SC : O(N) : for HashMap




*/