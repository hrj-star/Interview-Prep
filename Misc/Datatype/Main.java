class Main{
	public static void main(String[] args) {
		// int literals

	
	
		byte byte_var = 40;  // 1 byte
		short short_var = 30; // 2 bytes
		int  integer_var = 10; // 4 bytes
		float float_var = 10.8f; // 4 bytes	
		double double_var = 10.8; // 8 bytes
		long long_var = 20; // 8 bytes

		System.out.println(float_var); // 10.8


		System.out.println(double_var); //10.8

		// implicit conversion/
		byte_var =  127; // allowed as within byte range - 128 to 127

		//byte_var = 128; // not allowed as range exceeded
		// solution - explicit
		byte_var = (byte)128; // output -> -128

		// implicit conversion bydefault works for byte and short datatype
		// eg :  short(LHS) = int(RHS) -- allowed 
		short_var = 32000;

		System.out.println(short_var); // 32000

		// higher(LHS) = lower(RHS) -- allowed
		short_var = byte_var;
		System.out.println(short_var); // -128

		// lower(LHS) = higher(RHS) -- not allowed - error: incompatible types: possible lossy conversion from int to byte
		
		// float to int -> type casting
		integer_var = (int) float_var;
		System.out.println(integer_var); // 10

		//byte_var = integer_var;
		// Solution : typecast
		byte_var =  (byte)integer_var;

		System.out.println(byte_var); // 10


		float_var = integer_var; // allowed , will have 0 after decimal -> 10.0
		System.out.println(float_var); // 10.0



		// boolean -> only considers as true and false , not 1 and 0 as they are int in java

		boolean boolean_var =  true; // 1

		// usage in conditional stmts
		if(boolean_var)
			System.out.println("True"); // prints True
		else
			System.out.println("False");

	

		// char datatype --> 2 bytes // Uppercase(A-Z) : 65 - 90 , Lowercase(a-z) : 97-122

		char char_var = 'a';
		System.out.println(char_var); // a

		char_var = 65;
		System.out.println(char_var); // A

		char_var = (char) (char_var + 2); // type-casting int to char
		System.out.println(char_var); // C

	}
}