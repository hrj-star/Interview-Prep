/* When stack is falling */

class Main{
	 
	static void print_asc(int n){
		if(n==0){ // base case
			return;
		}

		print_asc(n-1); //  call the function recursively
		System.out.println(n); // work
		
	}
	public static void main(String[] args) {
		print_asc(5); // pass start point
	}
}