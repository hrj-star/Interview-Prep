class Optimized{

	static boolean isSorted(int arr[] , int n){

		if(n == 0 || n == 1){
			return true;
		}

		for(int i = 1 ; i < arr.length ; i++){
			if(arr[i - 1] > arr[i]){
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] arr = {3 , 8 , 5 , 1 , 10 , 4}; 
		if(isSorted(arr,arr.length)){
			System.out.println("Sorted");
		}
		else{
			System.out.println("Not Sorted");
		}
	
	}
}


/*

Output :
--------------------------

Not Sorted

Complexity Analysis
--------------------------

Time : O(n) 


Space : O(1) 


*/