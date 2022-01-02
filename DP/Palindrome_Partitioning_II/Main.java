
import java.util.Arrays;

class Main{
	public static void main(String[] args) {
		String s = "abacd";
		System.out.println(Palindrome_Partition_Recursion(s,0,s.length()-1));


		int[][] strg_arr =  new int[s.length()][s.length()];

		for(int i=0;i<strg_arr.length;i++){
			Arrays.fill(strg_arr[i],-1);
		}

		System.out.println(Palindrome_Partition_TopDownDP(s,0,s.length()-1 ,strg_arr));

		System.out.println(Palindrome_Partition_BottonUpDP(s));
	}

	public static int Palindrome_Partition_Recursion(String s , int si , int ei){

		if(isPalindrome(s,si,ei)){
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for(int k = si ; k <= ei-1 ; k++){
			int first = Palindrome_Partition_Recursion(s,si,k);
			int second = Palindrome_Partition_Recursion(s,k+1,ei);

			int total = first + second + 1;

			if(total < min){
				min = total;
			}
		}
		return min;
	}

	public static int Palindrome_Partition_TopDownDP(String s , int si , int ei ,int[][] strg_arr){

		if(isPalindrome(s,si,ei)){
			return 0;
		}

		if(strg_arr[si][ei] != -1){
			return strg_arr[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for(int k = si ; k <= ei-1 ; k++){
			int first = Palindrome_Partition_TopDownDP(s,si,k,strg_arr);
			int second = Palindrome_Partition_TopDownDP(s,k+1,ei,strg_arr);

			int total = first + second + 1;

			if(total < min){
				min = total;
			}
		}

		strg_arr[si][ei] = min;
		return min;
	}


	public 	static int Palindrome_Partition_BottonUpDP(String s){
		
		int n = s.length();

		int[][] strg_arr = new int[n][n];

		for(int slide = 0; slide <= n-1; slide++){
			for(int si = 0; si <= n-slide-1 ; si++){
				int ei = si + slide;

				if(isPalindrome(s,si,ei)){
					strg_arr[si][ei] = 0;
				}else{

					int min = Integer.MAX_VALUE;

					for(int k = si ; k <= ei-1 ; k++){
						int first = strg_arr[si][k];
						int second = strg_arr[k+1][ei];

						int total = first + second + 1;

						if(total < min){
							min = total;
						}
					}

					strg_arr[si][ei] = min;
				}
			}
		}

		return strg_arr[0][n-1];
	}


	public static boolean isPalindrome(String  s , int si , int ei){
		int left = si;
		int right = ei;

		while(left <  right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}