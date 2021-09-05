class Main{

	static int factorial(int n){

		if(n == 0){
			return 1;
		}

		return n  * factorial(n-1);
	}

	public static void main(String[] args) {
		int getFactorial = factorial(5); 
		System.out.println(getFactorial);
	}
}

/*

Output :
--------------------------

120

Complexity Analysis
--------------------------

Time : O(n) [ 1 operation for comparison base case , 1 for multiplication , 1 for subtraction , and time for factorial of (n-1)]
	   so , T(n) = T(n-1) + 3 
	   		T(0) = 1


Space : O(n) , for factorial of N , N stack calls storage allocated.


*/