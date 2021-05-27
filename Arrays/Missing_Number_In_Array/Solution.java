/*

Solution To Use :
 
 1)  Method 1 : sum(1 to N) - sum(array)

 
*/

import java.util.*;

class Solution {

 static int  missing_number(int arr[],int n){

    // find total sum

    int total = n ; // if total= arr.length  then  do total = arr.length + 1 as one number missing

    int total_sum = total*(total+1) / 2;
    
    int array_sum=0;

    for(int i=0; i < arr.length; i++){
        array_sum += arr[i];

    }

    return total_sum - array_sum;

 	
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