class Main{
	 
	static void print_desc(int n){
		if(n==0){ // base case
			return;
		}
		System.out.println(n); // work
		print_desc(n-1); //  call the function recursively
	}
	public static void main(String[] args) {
		print_desc(5); // pass start point
	}
}