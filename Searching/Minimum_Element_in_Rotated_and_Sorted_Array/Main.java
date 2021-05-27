
/*

Solution To Use :
 
 1) Sorted array : Using Binary search
 
*/

import java.util.*;

class Main {

 static int minimum_element_in_rotated_sorted_arr(int arr[],int n){

 	// base case
 	if(arr == null || n == 0){
 		return -1;
 	}

 	if(n == 1){
 		return arr[0];
 	}



 	int left = 0;
 	int right = n-1;

    while(left <right){
    	int mid = left + (right - left) / 2 ;

    	if(mid > 0 && arr[mid] < arr[mid -1]){
    		return arr[mid];
    	}


    	if(arr[mid] >= arr[left] && arr[mid] > arr[right]){ // as it is rotated sorted array
    		left = mid + 1;
    	}
    	else{
    		right = mid - 1;
    	}
    }

    return arr[left];


}
  

  public static void main(String[] args) {
    int arr1[] = {3,4,5,1,2};

    int arr2[] = {4,5,6,7,0,1,2};

    int arr3[] = {11,13,15,17};

   
   
    
    System.out.println(minimum_element_in_rotated_sorted_arr(arr1,arr1.length));
    System.out.println(minimum_element_in_rotated_sorted_arr(arr2,arr2.length));
    System.out.println(minimum_element_in_rotated_sorted_arr(arr3,arr3.length));
  
   
  }
}


/*

Output :
----------------------
1
0
11






Complexity Analysis :
---------------------------
TC : O(logn)   // binary search
SC : O(1)  



*/