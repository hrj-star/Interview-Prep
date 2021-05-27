

import java.util.*;

class Main {

 static int loves_chocolates(int arr[]){
 	int n = arr.length;
 	int ans=arr[0];
 	for(int i=1;i<n;i++){
 		if(ans>arr[i])
 			ans=arr[i];
 	}
 	return ans;
 	

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