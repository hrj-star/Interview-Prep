class Main{

	static boolean isSorted(int arr[] , int idx){

		if(arr.length - 1 == idx){
			return true;
		}

		if(arr[idx] > arr[idx + 1]){
			return false;
		}
		else{
			return isSorted(arr, idx+1);
		}
	}

	public static void main(String[] args) {
		int[] arr = {3 , 8 , 5 , 1 , 10 , 4}; 
		if(isSorted(arr,0)){
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


Space : O(n) for Recursion Stack


Optimized Version : Iterative version


*/