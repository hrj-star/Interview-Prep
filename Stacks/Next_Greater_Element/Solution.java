class Solution{

	static void next_greater_element(int arr[],int n){
		int next;
		for(int i = 0; i < n; i++){
			next = -1;
			for(int j = i+1; j < n; j++){
				if(arr[j] > arr[i]){
					next = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + " --> " + next);
		}
	}

	public static void main(String[] args) {
		int arr[]= {11, 13, 21, 3};
		int n = arr.length;
		next_greater_element(arr,n);
	}
}

/*

Output :
----------------------


11 --> 13
13 --> 21
21 --> -1
3 --> -1


Complexity Analysis :
---------------------------
Time Complexity  : O(n^2)
Space Complexity : O(1) 


*/