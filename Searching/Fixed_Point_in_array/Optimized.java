/*

Solution To Use :
 
 1) Using Binary Search 
 
*/

import java.util.*;

class Optimized {

 static int fixedPointInArray(int arr[],int n){

  // if  mid element is fixedPoint , then return it , else traverse left or right.

  int left = 0;
  int right = n-1;

  while(left <= right){

    int mid = left + (right-left)/2 ;

    if(mid == arr[mid]){
      return mid;
    }

    else if(mid > arr[mid]){
      left = mid + 1;
    }

    else{
      right = mid - 1;
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
TC : O(logn)   //binary search
SC : O(1)  



*/