class Main{
	 
	static void print_desc(int n){
		if(n==0){ // base case
			return;
		}

		System.out.println(n); // work for descending
		print_desc(n-1); //  call the function recursively
		System.out.println(n); // work for ascending
	}
	public static void main(String[] args) {
		print_desc(5); // pass start point
	}
}