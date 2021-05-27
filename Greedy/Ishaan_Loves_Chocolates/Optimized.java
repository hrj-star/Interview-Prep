/*

Solution To Use :
 
 1)  Optimized Greedy
*/

import java.util.*;

class Optimized {

 static int loves_chocolates(int arr[]){
 	int n=arr.length;
 	
 	int left = 0;
 	int right =n-1;
 	while(left < right){
 		if(arr[left] > arr[right]){
 			left++;
 		}
 		else{
 			right--;
 		}
 	}
 	return arr[left];
 	

  }
  

  public static void main(String[] args) {
  	int[] arr1={5, 3, 1, 6, 9};
  	int[] arr2={5, 9, 2, 6};
   

   System.out.println("Solution : " + loves_chocolates(arr1));
   System.out.println("Solution  : " + loves_chocolates(arr2));


 }
}


/*

Output :
------------------------
Solution : 1
Solution  : 2



Complexity Analysis :
---------------------------
 TC : O(N) 
 SC : O(1)   : constant space



*/