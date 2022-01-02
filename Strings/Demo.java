// contains snippets of basic operations on strings in java

public class Demo{
	public static void main(String[] args) {
		String s = "Demo String";
		String s2 = "Hello";

		System.out.println(s.length()); // 11

		System.out.println(s.charAt(5)); // S

		// substring(start,end) - returns string from start till end - 1
		System.out.println(s.substring(1,4)); // emo - index 1  to 3

		System.out.println(s.substring(7,11)); // ring - index 7  to 10

		// substring(start) - returns string from start till end  

		System.out.println(s.substring(5)); // String

		// concatenate
		System.out.println(s2+s); // HelloDemo String

		System.out.println(s2.concat(s)); // HelloDemo String

	}
}