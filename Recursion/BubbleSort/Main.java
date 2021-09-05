class Main{

	static void bubbleSort(int arr[] , int n){

		if(n == 1){ // base -  when only one element left , the array is already sorted 
			return ;
		}

		for(int i=0;i<n-1;i++){
			if(arr[i] > arr[i+1]){
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}

		bubbleSort(arr,n-1); // after each pass , last element is at its correct positio
	}

	public static void main(String[] args) {
		int[] arr = {3 , 8 , 5 , 1 , 10 , 4}; 
		int n = arr.length;  
		bubbleSort(arr , n);

		for(int i : arr){
			System.out.print(i + " ");
		}
	}
}

/*

Output :
--------------------------

1
4
-1

Complexity Analysis
--------------------------

Time : O(n*2) - calling the same function recursively for each element. 


Space : O(n) , for N elements , N stack calls storage allocated.

*/