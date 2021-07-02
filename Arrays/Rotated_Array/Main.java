class Main{

	static void leftrotated(int[] arr ,int n , int k){
		int[] rotatedArray = new int[n];
		for(int i=0;i<n;i++){
			int rotated = (i+(n-k))%n;
			rotatedArray[rotated] = arr[i];
		}
		printArray(rotatedArray,n);
	}


	static void rightrotated(int[] arr ,int n , int k){
		int[] rotatedArray = new int[n];
		for(int i=0;i<n;i++){
			int rotated = (i+k)%n;
			rotatedArray[rotated] = arr[i];
		}
		printArray(rotatedArray,n);
	}

	static void printArray(int[] rotatedArray , int n){
		for(int i=0;i<n;i++){
			System.out.print(rotatedArray[i]+" ");
		}
	}

	public static void main(String[] args) {
		int arr[] = {1,3,5,7,9,11};
		int k=1;
		System.out.println("Right Rotated Array : ");
		rightrotated(arr,arr.length,k);
		System.out.println("\nLeft Rotated Array : ");
		leftrotated(arr,arr.length,k);

	}
}


/*

Output :

Right Rotated Array : 
11 1 3 5 7 9 
Left Rotated Array : 
3 5 7 9 11 1 

*/