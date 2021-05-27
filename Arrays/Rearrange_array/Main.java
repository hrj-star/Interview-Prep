/*

Solution To Use :
 
 1) Extra space : aux array
 
*/

import java.util.*;

class Main {

 static void rearrange_array(int arr[],int n){

  // declare new auxiliary arrays
  int[] aux = new int[n];

  for(int i=0 ; i<n ;i++){
    aux[i] = arr[arr[i]];
  }

  // update original with aux

  for(int i=0; i<n;i++){
    arr[i] = aux[i];
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



Complexity Analysis :
---------------------------
TC : O(n)  
SC : O(n)  // aux array



*/