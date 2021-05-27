/*

Solution To Use :
 
 1) Fibonacci approach , as need to consider previous two state

*/



import java.util.*;

class DP {

 static int rob(int[] nums){

  int n= nums.length;

// base case 
  if(n == 0){
    return 0;
  }

  if(n == 1){
    return nums[0];
  }

  if(n == 2){
    return Math.max(nums[0] , nums[1]);
  }



  for(int i=2;i<n;i++){
    nums[i] = Math.max(nums[i] + nums[i-2] , nums[i-1]);
  }

  return nums[n-1];

}
  

  public static void main(String[] args) {
    int arr1[] = {1,2,3,1};
    int arr2[] = {2,7,9,3,1};
   
    
    System.out.println("Total amount that can be robbed : "+ rob(arr1));
    System.out.println("Total amount that can be robbed : "+ rob(arr2));
  }
}


/*

Output :
----------------------
Total amount that can be robbed : 4
Total amount that can be robbed : 12

// Working :
-----------------
 1 2 3 1


nums[2]= Math.max(3+1 ,2) = 4


Complexity Analysis :
---------------------------
TC : O(n) 
SC : O(1) 


Tags : Arrays , Linear DP , Fibonacci.

*/