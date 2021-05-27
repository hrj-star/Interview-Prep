
class DP{

	static int minCoins(int coins[] , int total){
		int[][] dp = new int [coins.length+1][total+1];

		for(int i=0;i <=coins.length;i++){
			dp[i][0] = 0;
		}
		for(int j = 0; j <= total; j++) {
			dp[0][j] = j;
		}

		for(int i=1; i <= coins.length; i++){
			for(int j=1; j <= total; j++){

				if(j >= coins[i-1]){
					//include
					dp[i][j] = Math.min(dp[i-1][j] ,dp[i][j-coins[i-1]] + 1);
				}

				else{
					// exclude
					dp[i][j] = dp[i-1][j];
				}
			}
		}


		return dp[coins.length][total];
	}
	
	 public static void main(String[] args) {

	 	int[] coins = {25, 10, 5};
	 	int total = 30;
	 	System.out.println("Minimum coins required is "+ minCoins(coins, total) );
	 }
}

/*

Solution :

Minimum coins required is 2

TC : O(coins * total)
SC : O(coins * total)
*/