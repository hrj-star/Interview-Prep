class Main{

	static int lastIndex(int arr[] , int idx , int key){

		if(arr.length  == idx){
			return -1;
		}

		int lastIndexInSmallerArray =  lastIndex(arr, idx+1 , key);

		if(lastIndexInSmallerArray == -1){
			if(arr[idx] == key){
				return idx;
			}
			else{
				return -1;
			}
		}
		else{
			return lastIndexInSmallerArray;
		}

	}

	public static void main(String[] args) {
		int[] arr = {3 , 8 , 1 , 8 , 8 , 4}; 
  
		System.out.println(lastIndex(arr , 0 , 8));
		System.out.println(lastIndex(arr , 0 , 4));
		System.out.println(lastIndex(arr , 0 , 20));
	
	}
}

/*

Output :
--------------------------

4
5
-1


Complexity Analysis
--------------------------

Time : O(n) 


Space : O(n) for Recursion Stack


Optimized Version : Iterative version


*/