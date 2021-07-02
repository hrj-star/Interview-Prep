/*

Solution To Use :
 
 1)  Optimized 
*/

import java.util.*;

class Optimized {

 static int  longest_alternating_subsequence(int arr[],int n){

  if (arr == null || arr.length == 0) {
    return 0  ;
  }


// single element is longest alternating subsequence

// inc = Length of longest alternative subsequence so far with current value being greater than it’s previous value.
// dec = Length of longest alternative subsequence so far with current value being smaller than it’s previous value.
  
  int inc = 1;
  int dec = 1;

  for(int i=1 ; i<n ; i++){

// if current is greater than it’s previous element.
    if(arr[i] > arr[i-1]){
      inc =  dec + 1;
    }

// if current is smaller than it’s previous element.
    else if(arr[i] < arr[i-1]){
      dec = inc + 1;
    }

  }

  return Math.max(inc,dec);

  }
  
  public static void main(String[] args) {
    int arr1[] = {10, 22, 9, 33, 49,50, 31, 60};
    int arr2[] = {8, 9, 6, 4, 5, 7, 3, 2, 4};
    int arr3[] = {8, -1, 2, 1, 9, 10};


   System.out.println("Longest Alternating Subsequence : " + longest_alternating_subsequence(arr1,arr1.length));
   System.out.println("Longest Alternating Subsequence : " + longest_alternating_subsequence(arr2,arr2.length));
   System.out.println("Longest Alternating Subsequence : " + longest_alternating_subsequence(arr3,arr3.length));

 }
}


/*

Output :
------------------------
Longest Alternating Subsequence : 6
Longest Alternating Subsequence : 6
Longest Alternating Subsequence : 5


Complexity Analysis :
---------------------------
TC : O(N) - scans entire array once.
SC : O(1) - constant space



*/