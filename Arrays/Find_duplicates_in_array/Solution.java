/*

Solution To Use :
 
 1)  Method 1 : Maintain visited array

 
*/

import java.util.*;

class Solution {

 static int  duplicate_number(int arr[]){

    int n = arr.length;

   boolean[] visited = new boolean[n];

   for(int ele : arr){
    if(visited[ele] == true){
        return ele;  // return duplicate
     }

     visited[ele] = true;
   }

   return -1 ; // no duplicates

}
  

  public static void main(String[] args) {
 
    int arr1[] = {1, 2, 3, 4, 4};
    int arr2[] = {1, 2, 3, 4, 2};
    int arr3[] = {1, 2, 3 ,5 ,4 ,2};
  
   
    System.out.println("Duplicate :" +  duplicate_number(arr1));
    System.out.println("Duplicate :" +  duplicate_number(arr2));
    System.out.println("Duplicate :" +  duplicate_number(arr3));

 }
}


/*

Output :
------------------------

Duplicate :4
Duplicate :2
Duplicate :2



Complexity Analysis :
---------------------------
TC : O(N) - Only one traversal of the array is needed.
SC : O(N) - visited array space



*/