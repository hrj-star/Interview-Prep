class Main{
	public static void main(String[] args) {
		int[] price = { 1  , 5  , 8  , 9 , 10 , 17 , 17 , 20};

		System.out.println(RodCut_Recursion(price,price.length - 1));

		System.out.println(Top_Down_DP(price,price.length - 1 ,new int[price.length]));

		System.out.println(Bottom_Up_DP(price));
	}

	public static int RodCut_Recursion(int[] price , int n){

		
		int max = price[n];

		int left = 0;
		int right = n-1;

		while(left <= right){

			int first = RodCut_Recursion(price,left);
			int second = RodCut_Recursion(price,right);

			int total = first + second;

			if(total > max){
				max = total;
			}

			left++;
			right--;
		}
		return max;
	}

	public static int Top_Down_DP(int[] price , int n , int[] strg_arr){

		if(strg_arr[n] != 0){
			return strg_arr[n];
		}
		
		int max = price[n];

		int left = 0;
		int right = n-1;

		while(left <= right){

			int first = Top_Down_DP(price,left,strg_arr);
			int second = Top_Down_DP(price,right,strg_arr);

			int total = first + second;

			if(total > max){
				max = total;
			}

			left++;
			right--;
		}
		strg_arr[n] = max;
		return max;
	}

	public static int Bottom_Up_DP(int[] price){

		int[] strg_arr = new int[price.length];

		strg_arr[0] = price[0];
		strg_arr[1] = price[1];

		for(int n=2 ; n<strg_arr.length ; n++){
			int max = price[n];

			int left = 0;
			int right = n-1;

			while(left <= right){

				int first = strg_arr[left];
				int second = strg_arr[right];

				int total = first + second;

				if(total > max){
					max = total;
				}

				left++;
				right--;
			}

			strg_arr[n] = max;
		}

		return strg_arr[strg_arr.length - 1];
	}

}