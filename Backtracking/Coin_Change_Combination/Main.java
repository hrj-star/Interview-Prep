class Main{

	static int count = 0;
	public static void main(String[] args) {
		CoinChange(new int[] {2,3,5,6},10,"",0);
	}

	public static void CoinChange(int[] coins_deno , int amount , String ans , int last_deno_idx){
		if(amount == 0){
			count++;
			System.out.println(count + ". " +ans);
			return;
		}

		for(int i=last_deno_idx;i<coins_deno.length;i++){
			if(amount >= coins_deno[i]){ // eg : if coin = 5 and amount = 6 so cannot call further as 5-6 = -1 or put a base case above that handles negative ans - if(amount < 0){ return;}
				CoinChange(coins_deno,amount - coins_deno[i], ans + coins_deno[i],i);
			}
		}
	}
}

/*

Output :

1. 22222
2. 2233
3. 226
4. 235
5. 55

*/