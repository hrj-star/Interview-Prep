/*

Solution To Use :
 
 1) Using Linear Search 
 
*/

import java.util.*;

class Main {

 static int fixedPointInArray(int arr[],int n){

  for(int i=0 ; i < n ; i++){
    if(arr[i] == i){
      return i; // fixedPointInArray is an index
    }
  }

  return -1 ; // no fixedPointInArrayb

}
  

  public static void main(String[] args) {
    int arr1[] = {-10, -5, 0, 3, 7};

    int arr2[] = {0, 2, 5, 8, 17};

    int arr3[] = {-10, -5, 3, 4, 7, 9};

   
   
    
    System.out.println(fixedPointInArray(arr1,arr1.length));
    System.out.println(fixedPointInArray(arr2,arr2.length));
    System.out.println(fixedPointInArray(arr3,arr3.length));
  
   
  }
}


/*

Output :
----------------------
3
0
-1






Complexity Analysis :
---------------------------
TC : O(n)   // linear search
SC : O(1)  



*/