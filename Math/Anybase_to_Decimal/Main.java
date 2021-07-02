
class Main{
	
	public static void main(String[] args) {

		int decimal_converted = anybase_to_decimal(1423,5);
		System.out.println(decimal_converted);
	}

	public static int anybase_to_decimal(int source_num , int source_base){
	int multiplier = 1; // first time raised to 0 is 1
	int ans = 0;
	while(source_num!=0){
		int rem = source_num % 10;
		ans += (rem * multiplier);
		multiplier = multiplier * source_base;

		source_num/=10;
	}

	return ans;
	

	}
}



/*

Output :
--------------------------

238


*/