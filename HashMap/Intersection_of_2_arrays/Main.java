import java.util.*;

class Main{

	public static ArrayList<Integer> getIntersection(int arr1[] ,int arr2[]){
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer,Boolean> map = new HashMap<>();

		// put all elements of array 1 into map with value as false
		for(int ele : arr1){
			map.put(ele,false);
		}

		// iterate over 2nd array and compare in map , if element exists them put their value as false

		for(int ele :arr2){
			if(map.containsKey(ele)){
				map.put(ele, true);
			}
		}

		// now add elements having value = true in arraylist which is the final answer

		Set<Map.Entry<Integer , Boolean>> entries = map.entrySet();

		for(Map.Entry<Integer , Boolean> entry : entries){
			if(entry.getValue()){
				result.add(entry.getKey());
			}
		}

		return result;
	}
	public static void main(String[] args) {
		int[] arr1 = {4, 9, 5};
		int[] arr2 = {9, 4, 9, 8, 4};

		System.out.println("Intersection : " + getIntersection(arr1,arr2));
	}
}

/*
Output :
---------------------
Intersection : [4, 9]


Complexity Analysis :
---------------------

Time : O(n+m) // where n = length of arr1 , m = length of arr2
Space : O(n)