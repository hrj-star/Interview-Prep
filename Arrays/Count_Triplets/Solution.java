/*

Solution To Use :
 
 1)  Brute Force.
 
*/

import java.util.*;

class Solution {

 static int count_triplets(int arr[],int n){

  int count=0;

  for(int i=0;i<n-2;i++){
    for(int j=i+1;j<n-1;j++){
      for(int k=j+1;k<n;k++){
        if(arr[i] + arr[j] == arr[k] || arr[i] + arr[k] == arr[j] || arr[k] + arr[j] == arr[i]){
          count++;
        }
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
TC : O(n^3)
SC : O(1) 




*/