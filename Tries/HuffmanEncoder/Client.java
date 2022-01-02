import java.util.BitSet;

public class Client{
	public static void main(String[] args) {
		String str = "abbcdda";
		HuffmanEncoder h = new HuffmanEncoder(str);
		String encodedString =  h.encode(str);

		System.out.println(encodedString);

		String decodedString = h.decode(encodedString);

		System.out.println(decodedString);

		// size reduction

		BitSet bitSet = new BitSet(encodedString.length());
		int bitcounter = 0;

		for(Character c : encodedString.toCharArray()){
			if(c.equals('1')){
				bitSet.set(bitcounter);
			}
			bitcounter++;
		}

		byte[] arr = bitSet.toByteArray();

		System.out.println(arr.length);
	}
}


/*

01001001100000001
abbcdda
3     // or 7*2 = 14 = 2

O(nlogn) where n is the number of unique characters.
*/