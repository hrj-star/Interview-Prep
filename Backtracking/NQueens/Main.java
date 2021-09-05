class Main{

	static int count = 0;
	public static void main(String[] args) {
		
	}

	public static void NQueen(boolean[][] board, int row ,int col , int queens_placed_so_far ,int total_queens , String ans){

		// positive base case 

		if(queens_placed_so_far == total_queens){
			System.out.println(ans);
			return;
		}


		// negative base case

		if(row == board.length){
			return;
		}
	}
}