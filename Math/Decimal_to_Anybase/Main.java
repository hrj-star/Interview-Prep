
class Main{
	
	public static void main(String[] args) {

		int anybase_converted = decimal_to_anybase(10,2);
		System.out.println(anybase_converted);
	}

	public static int decimal_to_anybase(int source_num , int destination_base){
	int multiplier = 1; // first time raised to 0 is 1
	int ans = 0;
	while(source_num!=0){
		int rem = source_num % destination_base;
		ans += (rem * multiplier);
		multiplier = multiplier * 10;

		source_num/=destination_base;
	}

	return ans;
	

	}
}



/*

Output :
--------------------------

1010


*/