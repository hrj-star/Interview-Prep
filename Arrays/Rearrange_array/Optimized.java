/*

Solution To Use :
 
 1) O(1) Extra space 
 
*/

import java.util.*;

class Optimized {

 static void rearrange_array(int arr[],int n){

  
  for(int i=0 ; i<n ;i++){
    arr[i] += (arr[arr[i]] %n) * n;

  }

  for(int i=0 ; i<n ;i++){
   arr[i]/=n;

  }

  // print original arrays

  for(int i=0 ; i<n ;i++){
    System.out.print(arr[i]+" ");
  }

  System.out.println();

}
  

  public static void main(String[] args) {
    int arr1[] = {3, 2, 0, 1};

    int arr2[] = {4, 0, 2, 1, 3};

    int arr3[] = {0, 1, 2, 3};

   
   
    
    rearrange_array(arr1,arr1.length);
    rearrange_array(arr2,arr2.length);
    rearrange_array(arr3,arr3.length);
  
   
  }
}


/*

Output :
----------------------
1 0 3 2 
3 4 2 0 1 
0 1 2 3 



Working :
---------------------------
 arr[] = 3 2 0 1 

 Increment by arr[arr[i]]%n)*n :

x = 3 , y = arr[arr[0]] = arr[3] = 1 , n = 4

now ,  x + y * n =  3+1*4 = 7 

now , 7%n = 7%4 gives 3 , which is x .
and , 7/n =7/4 gives 1  which is y , and is the desired output at 0th index.



Complexity Analysis :
---------------------------
TC : O(n)  
SC : O(1)  // aux array



*/