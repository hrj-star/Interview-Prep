// all calls are undoed implicitly

class Main{

	static int count = 0;

	public static void main(String[] args) {
		CoinChangeCoinRespect(new int[]{2,3,5,6} ,0,10,"");
	}

	public static void CoinChangeCoinRespect(int[] coins_deno , int curr_idx , int amount , String ans){

		// positive base case -- return answer when amount is 0 / exactly reached
		if(amount == 0){
			count++;
			System.out.println(count + ". " +ans);
			return;
		}
		/*

		  negative base cases - 
		  1. when negative amount reached i.e when amount = 1 cannot be made from coin value = 3 
          2. when coins array becomes empty

         */

         if(amount < 0 || curr_idx == coins_deno.length){
         	return;
         }

		// include current Coin
		CoinChangeCoinRespect(coins_deno , curr_idx , amount - coins_deno[curr_idx] , ans + coins_deno[curr_idx]);
	
		// do not include current coin // move to coin at forward idx
		CoinChangeCoinRespect(coins_deno , curr_idx + 1, amount , ans);
	}
}

/* 
Output
-----------------------

22222
2233
226
235
55

*/