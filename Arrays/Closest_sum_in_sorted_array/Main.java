
import java.util.*;
class Main {

 static void closest_sum(int arr[],int target){
  int n=arr.length;

  int left = 0 , right = n-1, current_diff=0, min_diff = Integer.MAX_VALUE, closest_sum=0,current_sum=0;

  int curr_left = 0 , curr_right = n-1;

  while(left < right){
    current_sum =  arr[left] + arr[right];
    current_diff = Math.abs(current_sum - target);
    

    if(current_diff < min_diff){
      min_diff = current_diff;
      closest_sum = current_sum;
      curr_left=left;
      curr_right=right;

    }

    if(current_sum <= target){
      left++;
    }
    else{
      right--;
    }

  } 

  System.out.println("Closest sum is : "+ closest_sum +" ==> "+ " pairs: "+arr[curr_left]+" , "+arr[curr_right]);

    
  }
  
  public static void main(String[] args){
    int arr1[] = { 4,16, 28, 37, 42, 56, 63, 89, 124, 245};
    int x = 101;

    closest_sum(arr1,x);
    
    
   
  }
}


/*

Output :

Closest sum is : 100 ==>  pairs: 37 , 63



TC : O(nlogn) : binary search
SC : O(1) 



*/