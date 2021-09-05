class Main{
	 
	static void print_skipped_numbers(int n){

		if(n == 0){
			return;
		}

		if(n % 2 == 1){  // print odd first
			System.out.println(n); 
		}

		print_skipped_numbers(n-1); // recirsive decrement

		if(n % 2 == 0){  // print even 
			System.out.println(n); 
		}

	}
	public static void main(String[] args) {
		print_skipped_numbers(5); // pass start point
	}
}