class Main{
	public static void main(String[] args) {
		int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(DungeonGameRec(arr,0,0,arr.length-1,arr[0].length-1));

		int[][] strg_arr = new int[arr.length][arr[0].length];

		System.out.println(DungeonGameTopDownDP(arr,0,0,arr.length-1,arr[0].length-1,strg_arr));

		System.out.println(DungeonGameBottomUpDP(arr));
	}

	public static int DungeonGameRec(int[][] arr, int cr, int cc, int er, int ec){
		if(cr==er && cc==ec){
			return arr[cr][cc] <= 0 ? -arr[cr][cc] + 1 : 1 ;
		}

		if(cr > er || cc > ec){ // no path exists outside boundary , return infinity
			return Integer.MAX_VALUE;
		}

		int right = DungeonGameRec(arr,cr,cc+1,er,ec);
		int down = DungeonGameRec(arr,cr+1,cc,er,ec);

		int maxpath = Math.min(right,down);

		int amountAlreadyHave = maxpath - arr[cr][cc];

		int ans;

		if(amountAlreadyHave >= 1){
			ans = amountAlreadyHave;
		}
		else{
			ans = 1;
		}

		return ans;
	}

	public static int DungeonGameTopDownDP(int[][] arr, int cr, int cc, int er, int ec,int[][] strg_arr){
		if(cr==er && cc==ec){
			return arr[cr][cc] <= 0 ? -arr[cr][cc] + 1 : 1 ;
		}

		if(cr > er || cc > ec){ // no path exists outside boundary , return infinity
			return Integer.MAX_VALUE;
		}

		if(strg_arr[cr][cc] != 0){
			return strg_arr[cr][cc];
		}

		int right = DungeonGameTopDownDP(arr,cr,cc+1,er,ec,strg_arr);
		int down = DungeonGameTopDownDP(arr,cr+1,cc,er,ec,strg_arr);

		int maxpath = Math.min(right,down);

		int amountAlreadyHave = maxpath - arr[cr][cc];

		int ans;

		if(amountAlreadyHave >= 1){
			ans = amountAlreadyHave;
		}
		else{
			ans = 1;
		}

		strg_arr[cr][cc] = ans;
		return ans;
	}

	public static int DungeonGameBottomUpDP(int[][] arr){
		int[][] strg_arr = new int[arr.length + 1][arr[0].length + 1]; // one extra size 

		int strg_arr_row = strg_arr.length;
		int strg_arr_col = strg_arr[0].length;

		for(int row = strg_arr_row - 1 ; row >= 0 ; row-- ){
			for(int col = strg_arr_col -1 ; col >= 0 ; col--){

				// base cases

				// -- handle last cell where Queen is there

				if(row == strg_arr_row - 2 && col == strg_arr_col - 2){
					strg_arr[row][col] = arr[row][col] <=0 ? -arr[row][col] + 1 : 1;
				}
				else if(row == strg_arr_row - 1){ // out of boundary row  - put infinity
					strg_arr[row][col] = Integer.MAX_VALUE;
				}
				else if(col == strg_arr_col - 1){ // out of boundary col  - put infinity
					strg_arr[row][col] = Integer.MAX_VALUE;
				}

				else{ // same as top down

					int right = strg_arr[row][col + 1];
					int down = strg_arr[row + 1][col];

					int maxpath = Math.min(right,down);

					int amountAlreadyHave = maxpath - arr[row][col];

					int ans;

					if(amountAlreadyHave >= 1){
						ans = amountAlreadyHave;
					}
					else{
						ans = 1;
					}

					strg_arr[row][col] = ans;
					
				}
			}
		}

		return strg_arr[0][0];
	}
}


/*

7
7
7

*/