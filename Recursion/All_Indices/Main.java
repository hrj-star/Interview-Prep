class Main{

	static int[] all_indices(int arr[] , int target , int idx , int target_idx_found_so_far){

		if(idx == arr.length){
			return new int[target_idx_found_so_far];
		}
		if(arr[idx] == target){
			int[] idx_array =  all_indices(arr,target,idx + 1 ,target_idx_found_so_far + 1);
			idx_array[target_idx_found_so_far] = idx;
			return idx_array;
		}
		else{
			int[] idx_array =  all_indices(arr,target,idx + 1 ,target_idx_found_so_far);
			return idx_array;
		}
	}

	public static void main(String[] args) {
		int[] arr = {2 , 3 , 6 , 9 , 8 , 3 , 2 , 3 , 6 , 4}; 
		int target = 3; 
		int[] index_arr = all_indices(arr , target , 0, 0);

		for(int i : index_arr){
			System.out.print(i + " ");
		}

		System.out.println("Output array size : "+index_arr.length);
	}
}

/*

Output :
--------------------------
1 5 7

Complexity Analysis
--------------------------

Time : O(n*2) - calling the same function recursively for each element. 


Space : O(n) , for N elements , N stack calls storage allocated.

*/