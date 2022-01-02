import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.util.Map;

class Main{
	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();

		// put
		map.put("Apple",1);
		map.put("Mango",2);
		map.put("Orange",3);
		map.put("Kiwi",4);
		map.put("Grapes",5);

		// display map - {Apple=1, Kiwi=4, Grapes=5, Mango=2, Orange=3}
		System.out.println(map);

		map.put("Banana",6);

		System.out.println(map); // {Apple=1, Kiwi=4, Grapes=5, Mango=2, Orange=3, Banana=6}

		// edit value
		map.put("Banana",8);

		System.out.println(map); // {Apple=1, Kiwi=4, Grapes=5, Mango=2, Orange=3, Banana=8}

		// get value
		System.out.println(map.get("Mango")); // 2

		// get value of key that doesn't exist
		System.out.println(map.get("Strawberry")); // null

		// remove key-pair -- will return as well remove
		System.out.println(map.remove("Banana") + " Updated Map :" + map); // 8 Updated Map :{Apple=1, Kiwi=4, Grapes=5, Mango=2, Orange=3}

		// containsKey
		System.out.println(map.containsKey("Mango")); // true
		System.out.println(map.containsKey("Banana")); // false

		// get all keys
		System.out.println("********** Keys ************");
		Set<String> keys = map.keySet();
		for(String key : keys){
			System.out.println(key);
		}

		// get all values
		System.out.println("********** Values ************");
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println(value);
		}

		// get all key value mapping
		System.out.println("********** EntrySet ************");

		Set<Map.Entry<String,Integer>> entries = map.entrySet();

		for(Map.Entry<String,Integer> entry : entries){
			System.out.println(entry.getKey() + " ==> " + entry.getValue());
		}

		// get  max freq character
		String str = "aabbaaabcdda";
		System.out.println("Max Frequency character : " + getMaxFreq(str)); // output : Max Frequency character : a

	}

	public static char getMaxFreq(String str){
			HashMap<Character , Integer> map = new HashMap<>();
			for(int i=0;i<str.length();i++){
				char ch = str.charAt(i);

				if(map.containsKey(ch)){
					// breaking the one-liner into understandable code
					int old_value_from_map = map.get(ch);
					int new_value = old_value_from_map + 1;
					map.put(ch,new_value);
				}else{
					map.put(ch,1);
				}
			}

			char max_char = '\0';

			int max = Integer.MIN_VALUE;
			Set<Map.Entry<Character,Integer>> m_entries = map.entrySet();
			for(Map.Entry<Character,Integer> m_entry : m_entries){
				if(m_entry.getValue() > max){
					max = m_entry.getValue();
					max_char = m_entry.getKey();
				}
			}

			return max_char;
		}
}

/*
Complexity :
---------------------------
get , put , remove , containsKey --> O(1) - constant time
*/