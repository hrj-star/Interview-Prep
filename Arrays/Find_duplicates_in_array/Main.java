/*

Solution To Use :
 
 1)  Method 2 : Maintain HashSet

 
*/

import java.util.*;

class Main {

 static int  missing_number(int arr[]){

    int n = arr.length;

    HashSet<Integer> set = new HashSet<Integer>();

    for(int ele : arr){
      if(!set.add(ele)){
        return ele;
      }
   
   }

   return -1 ; // no duplicates

}
  

  public static void main(String[] args) {
 
    int arr1[] = {1, 2, 3, 4, 4};
    int arr2[] = {1, 2, 3, 4, 2};
    int arr3[] = {1, 2, 3 ,5 ,4 ,2};
  
   
    System.out.println("Duplicate: " + missing_number(arr1));
    System.out.println("Duplicate: " + missing_number(arr2));
    System.out.println("Duplicate: " + missing_number(arr3));

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
TC : O(N) - O(N)*O(1) 
SC : O(1) or O(n) [ extra space]



*/