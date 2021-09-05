class Main{
	static int count = 0;
	public static void main(String[] args) {
		QueenPermutation(new boolean[4] , 2 , 0 , "");
	}

	public static void QueenPermutation(boolean[] boxes , int total_queens , int queens_placed_so_far , String ans){

		if(queens_placed_so_far == total_queens){
			count++;
			System.out.println(count + " . " +ans);
			return;
		}
		for(int i=0;i<boxes.length;i++){
			if(boxes[i] == false){ // place only where no queen is placed - marked by false
				boxes[i] = true; // place the queen
				QueenPermutation(boxes,total_queens,queens_placed_so_far + 1 ,ans + "q" + queens_placed_so_far + "b" + i +" "); // for current iteration print ans
				boxes[i] = false; //undo
			}
		}
	}
}