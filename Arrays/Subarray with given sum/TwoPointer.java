/*

Solution To Use :
 
 1)Apply two pointer technique
 2)Unsorted array
 3)Optimized
*/

import java.util.*;
class TwoPointer {

 static int subarray(int arr[],int sum , int len){

   int left  = 0;
   int right = 1;
   int currsum = arr[0];

   while(right <= len){

     while(currsum > sum && left < right-1){
       currsum-=arr[left];
       left++;
       }
     

      if(currsum == sum){
        System.out.print(left + " " +(right-1)+"\n");
        return 1;
      }

      if(right < len){
        currsum+=arr[right];
      }

      right++;

   }

    System.out.println("No subarray found");
    return 0;
    
  }
  
  public static void main(String[] args) {
    int arr1[] = {1, 4, 20, 3, 10, 5};
    int arr2[] = {1, 4, 0, 0, 3, 10, 5};
    int arr3[] = {1, 4};
    int sum1 = 33;
    int sum2 = 7;
    int sum3 = 0;
    
    subarray(arr1,sum1,arr1.length);
    subarray(arr2,sum2,arr2.length);
    subarray(arr3,sum3,arr3.length);
   
  }
}


/*

Output :

2 4
1 4
No subarray found



TC : O(n) : Only one traversal of the array is required. 
SC : O(1) : Constant Extra Space needed.



*/