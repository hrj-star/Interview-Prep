class Main{
	static int count = 0;
	public static void main(String[] args) {
		QueenCombination(new boolean[4] , 2 , 0 , "" , -1);
	}

	public static void QueenCombination(boolean[] boxes , int total_queens , int queens_placed_so_far , String ans , int lastBoxUsed){

		if(queens_placed_so_far == total_queens){
			count++;
			System.out.println(count + ". " +ans);
			return;
		}
		for(int i=lastBoxUsed + 1;i<boxes.length;i++){
			
				boxes[i] = true; // place the queen
				QueenCombination(boxes,total_queens,queens_placed_so_far + 1 ,ans + "q" + queens_placed_so_far + "b" + i +" " , i); // for current iteration print ans
				boxes[i] = false; //undo
			
		}
	}
}


/*

Output:
----------------------------

1. q0b0 q1b1 
2. q0b0 q1b2 
3. q0b0 q1b3 
4. q0b1 q1b2 
5. q0b1 q1b3 
6. q0b2 q1b3 

*/