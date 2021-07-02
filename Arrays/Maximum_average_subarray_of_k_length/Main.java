import java.util.*;

class Main{

	public static int findMaxAverage(int arr[], int k , int n){
		if(k>n){
			return -1;
		}

		// compute sum of first 'k' elements

		int sum =  arr[0];
		for(int i=0;i<k;i++){
			sum+=arr[i];
		} 

		// assign current sum to max
		int max_sum = sum,max_end = k-1;

		for(int i=k;i<n;i++){
			sum = sum + arr[i] - arr[i-k];

			if(sum > max_sum){
				max_sum = sum;
				max_end = i;
			}
		}

		// return starting index

		return max_end - k + 1;
	}



	public static void main(String[] args) {
	int arr[] = { 1, 12, -5, -6, 50, 3};
    int k = 4;

    int n = arr.length;

    System.out.println("Maximum average subarray of length "+k+" begins at index "+ findMaxAverage(arr,k,n));
    

	
	}

}




/*

Solution :

Maximum average subarray of length 4 begins at index 1

Complexity Analysis :
---------------------------
TC : O(N) 
SC : O(1) 
*/