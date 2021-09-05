class Main{
	static int count = 0;
	
	public static void main(String[] args) {
		QueenCombinationBoxRespect(new boolean[4],0,0,2,"");
	}
	public static void QueenCombinationBoxRespect(boolean[] board, int col_placed ,int queens_placed_so_far ,int total_queens,String ans){


		// positive base case -- if all queens are placed , then return answer
		if(queens_placed_so_far == total_queens){
			count++;
			System.out.println(count + ". " +ans);
			return;
		}


		// negative base case -- if calls made greater than board length , then return , eg : if calls made to board[4] if board is of length 4 (board[0] ,board[1] ,board[2] ,board[3]) , then return from such negative base cases  
		if(col_placed == board.length){
			return;
		}

		// place queen

		board[col_placed] = true;
		QueenCombinationBoxRespect(board , col_placed + 1 , queens_placed_so_far + 1 , total_queens , ans + "b" + col_placed);
		board[col_placed] = false;

		// do not place queen

		QueenCombinationBoxRespect(board , col_placed + 1, queens_placed_so_far , total_queens , ans);

	}
}

/* 
Output :
------------------------

b0b1
b0b2
b0b3
b1b2
b1b3
b2b3


*/