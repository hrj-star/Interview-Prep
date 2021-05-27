/*

Solution To Use :
 
 1)  Naive , Recursive
 2)  Distinct elements only.
 
*/

import java.util.*;

class Solution {

 static boolean count_triplets(int arr[],int sum ,int n){



  Map<Integer,Integer> map = new HashMap<Integer,Integer>();

  for(int i=0;i<n;i++){
    map.put(arr[i],i);
  }

;
 // System.out.print(map); // map: {0=3, 1=6, 2=0, 3=7, 4=2, 5=5, 7=1, 9=4}


  for(int i=0;i<n-1;i++){
    for(int j=i+1;j<n;j++){

      int val = sum-(arr[i]+arr[j]);
      if(map.containsKey(val)){
        if (map.get(val) != i && map.get(val) != j){ // check if triplets dont overlap like (i,j,j) or (i,j,i)
          return true;
        }
      }
    }
  } 

  return false; // if triplet doesnt exists

  }
  

  public static void main(String[] args) {
    int arr1[] = {2, 7, 4, 0, 9, 5, 1, 3};
    int sum1 = 6;
 

    if(count_triplets(arr1,sum1,arr1.length)){
       System.out.println("Triplet exists");

    }
    else{
       System.out.println("Triplet doesn't exists");

    }
   
  }
}


/*

Output :
------------------------

Triplet exists.





Complexity Analysis :
---------------------------
TC : O(N^2) as 2 loops.
SC : O(N)  extra space.




*/