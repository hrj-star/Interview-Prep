/*

Solution To Use :
 
 1)  Using Frequency Array.
 2)  Assuming the value of array elements lies in the range [1, 100].
 3)  Input type : Distinct, positive.
 
*/

import java.util.*;

class Solution2 {

 static int count_triplets(int arr[],int n){

  int count=0;
  int[] freq = new int[100];


  for(int i=0;i<n;i++){
    freq[arr[i]]++;
  }


  for(int i=0;i<n-1;i++){
    for(int j=i+1;j<n;j++){
      if(freq[arr[i] + arr[j]] > 0){
        count++;
      }
    }
  }


  return count;

  }
  


  public static void main(String[] args) {
    int arr1[] = {1, 5, 3, 2};
  
    int arr2[] = {2, 3, 4};
   
    System.out.println(count_triplets(arr1,arr1.length));
    System.out.println(count_triplets(arr2,arr2.length));
  }
}


/*

Output :
------------------------

2  - There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5 

0  - No triplet exists


Working :
------------------------

 
  Declare and Increment freq array elements with indexes same as arr[i],

              0 1 2 3
     arr[] = {1,5,3,2}

     freq array=     0  1  2  3  4  5  6
                     0  1  1  1  0  1  0    and so on.


   If frequency of the sum is greater than 0,increment the count of the triplets.

    1) i=0,j=1 , arr[0] + arr[1] = 1+5 = 6 , freq[6] = 0 , dont increment count.
    2) i=0,j=2 , arr[0] + arr[2] = 1+3 = 4 , freq[4] = 0 , dont increment count.
    3) i=0,j=3 , arr[0] + arr[3] = 1+2 = 3 , freq[3] = 1 , count++ , count = 1
    4) i=1,j=2 , arr[1] + arr[2] = 5+3 = 8 , freq[8] = 0 , dont increment count.
    5) i=1,j=3 , arr[1] + arr[3] = 5+2 = 7 , freq[7] = 0 , dont increment count.
    2) i=2,j=3 , arr[2] + arr[3] = 2+3 = 5 , freq[5] = 1 , count++ , count = 2
 



 



Complexity Analysis :
---------------------------
TC : O(n^2)
SC : O(N) : for frequency array




*/