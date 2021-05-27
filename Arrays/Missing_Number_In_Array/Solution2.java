/*

Solution To Use :
 
 1)  Method 2 : Using XOR
 2)  For limited range array.

 
*/

import java.util.*;

class Solution2 {

 static int  missing_number(int arr[],int n){


    int xor = 0 ; 

    for(int i=0; i < n-1; i++){ // for(int i=0; i < arr.length; i++)
        xor ^= arr[i];

    }

   for(int i=1; i <= n; i++){  //  for(int i=1; i <= arr.length+1; i++)
    xor ^= i;
   }
   
    return xor;
  }
  

  public static void main(String[] args) {
    int n1=5 , n2=10;
    int arr1[] = {1,2,3,5};
    int arr2[] = {1,2,3,4,5,6,7,8,10};
  
   
    System.out.println(missing_number(arr1,n1));
    System.out.println(missing_number(arr2,n2));

 }
}


/*

Output :
------------------------

4 : Missing number is 4

9 : Missing number is 9



Complexity Analysis :
---------------------------
TC : O(N) - Only one traversal of the array is needed.
SC : O(1) - No extra space.



*/