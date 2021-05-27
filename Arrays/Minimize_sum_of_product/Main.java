
import java.util.*;
class Main {

 static int minimize_sum_of_product(int a[],int b[], int n){
  int ans=0;
  Arrays.sort(a);
  Arrays.sort(b);

  for(int i=0;i<n;i++){
    ans+=a[i]*b[n-i-1];
  }

  return ans;
 

    
  }
  
  public static void main(String[] args){
    int n=5; // equal sized arrays
    int arr1[] = { 6, 1, 9, 5, 4};
    int arr2[] = { 3, 4, 8, 2, 4};
   
    System.out.println(minimize_sum_of_product(arr1,arr2,n));
   
  }
}


/*

Output :

80

After sorting a[] and b[] ,

a[] = 1,4,5,6,9
b[] = 2,3,4,4,8

a[] as it is , b[] compute reverse

ans = 1*8 + 4*4 + 5*4 + 6*3 + 9*2 = 8+16+20+18+18 = 80 which is minimize_sum_of_product.

TC : O(nlogn) : sorting
SC : O(1) 



*/