import java.util.*;

class Main{

	public static double[] contiguousSubarrayAverage(int arr[], int k){

		double[] result = new double[arr.length-k+1];
		double windowSum = 0;
		int windowStart = 0;

		for(int windowEnd = 0 ;windowEnd < arr.length;windowEnd++){
			windowSum += arr[windowEnd]; // add the next element

			if(windowEnd >= k-1){
				result[windowStart] = windowSum / k; // calculate the average
				windowSum -= arr[windowStart]; // subtract the element going out
				windowStart++; // slide the window ahead
			}
		}
		return result;
	}



	public static void main(String[] args) {
	int arr[] = { 1,3,2,6,-1,4,1,8,2};
    int k = 5;
    double[]  result =contiguousSubarrayAverage(arr,k);
    System.out.println("Average of subarray of size k: "+Arrays.toString(result));

	
	}

}




/*

Solution :

Average of subarray of size k: [2.2, 2.8, 2.4, 3.6, 2.8]

Complexity Analysis :
---------------------------
TC : O(N) 
SC : O(N) 
*/