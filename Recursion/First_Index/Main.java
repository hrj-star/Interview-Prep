class Main{

	static int firstIndex(int arr[] , int idx , int key){

		if(arr.length  == idx){
			return -1;
		}

		if(arr[idx] == key){
			return idx;
		}
		else{
			return firstIndex(arr, idx+1 , key);
		}
	}

	public static void main(String[] args) {
		int[] arr = {3 , 8 , 5 , 1 , 10 , 4}; 
  
		System.out.println(firstIndex(arr , 0 , 8));
		System.out.println(firstIndex(arr , 0 , 10));
		System.out.println(firstIndex(arr , 0 , 20));
	
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

Time : O(n) 


Space : O(n) for Recursion Stack


Optimized Version : Iterative version


*/