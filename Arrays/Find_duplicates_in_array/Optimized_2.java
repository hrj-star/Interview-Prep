/*

Solution To Use :
 
 1)  Method 4 : XOR 
 2) Works for twice repeated elements
 
*/

import java.util.*;

class Optimized_2 {

 static int   duplicate_number(int arr[]){

    int n = arr.length;

     int xor = 0;
 
  
     // take xor of all array elements
    for (int i = 0; i < n; i++) {
        xor ^= arr[i];
    }
 
    // take xor of numbers from 1 to `n-1`
    for (int i = 1; i <= n-1; i++) {
        xor ^= i;
    }

    // same elements will cancel each other as a ^ a = 0,
    // 0 ^ 0 = 0 and a ^ 0 = a
 
    // `xor` will contain the missing number
    return xor;

}
  

  public static void main(String[] args) {
 
    int arr1[] = {1, 2, 3, 4, 4};
    int arr2[] = {1, 2, 3, 4, 2};
    int arr3[] = {1, 2, 3 ,5 ,4 ,2};
  
   
    System.out.println("Duplicate: " +  duplicate_number(arr1));
    System.out.println("Duplicate: " +  duplicate_number(arr2));
    System.out.println("Duplicate: " +  duplicate_number(arr3));

 }
}


/*

Output :
------------------------

Duplicate: 4
Duplicate: 2
Duplicate: 2


Complexity Analysis :
---------------------------
TC : O(N) - Only one traversal of the array is needed.
SC : O(1) - constant space



*/