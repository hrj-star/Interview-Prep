/*

Solution To Use :
 
 1) Optimized - Fibonacci approach , as need to consider previous two state

*/



import java.util.*;

class Main {

 static int rob(int[] nums){

  int n= nums.length;

// base case 
  if(n == 0){
    return 0;
  }

  int a=0;
  int b=nums[0];

  for(int i=1;i<n;i++){
    int c = Math.max(a+nums[i],b);
    a=b;
    b=c;
  }

  return b;

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


Complexity Analysis :
---------------------------
TC : O(n) 
SC : O(1) 


Tags : Arrays , Linear DP , Fibonacci.

*/