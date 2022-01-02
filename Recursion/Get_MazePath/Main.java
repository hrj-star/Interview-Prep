import java.util.*;
class Main{
	public static ArrayList<String> getMazePath(int curr_row , int curr_col , int end_row , int end_col){

		if(curr_row == end_row && curr_col == end_col){ // base case -- when reached destination ,return base array of size 1  with one empty string to return recursion result back.
			ArrayList<String> base_res = new ArrayList<String>();
			base_res.add("");
			return base_res;
		}
		if(curr_row > end_row || curr_col > end_col){ // base case  -- return empty base array of size 0 to not return anything to recursion result back.
			ArrayList<String> base_res = new ArrayList<String>();
			return base_res;
		}

		ArrayList<String> result = new ArrayList<String>();


		ArrayList<String> h_res = getMazePath(curr_row,curr_col + 1,end_row,end_col); // move horizontally
		for(String str : h_res){
			result.add("H" + str);
		}

		ArrayList<String> v_res = getMazePath(curr_row + 1,curr_col,end_row,end_col); // move vertically
		for(String str : v_res){
			result.add("V" + str);
		}


		return result;
	}

	public static void printMazePath(int curr_row, int curr_col,int end_row,int end_col,String ans){
		if(curr_row == end_row && curr_col == end_col){
			System.out.println(ans); // print answer
			return;
		}

		if(curr_row > end_row || curr_col > end_col){ // do not print answer
			return;
		}

		printMazePath(curr_row,curr_col + 1 , end_row,end_col, ans + "H");
		printMazePath(curr_row + 1 ,curr_col, end_row,end_col, ans + "V");
	}

	public static int countMazePath(int curr_row, int curr_col,int end_row,int end_col){
		
		// 1 - positive base case , 0 - negative base case.

		if(curr_row == end_row && curr_col == end_col){
			return 1;
		}

		if(curr_row > end_row || curr_col > end_col){ // do not print answer
			return 0;
		}

		int hc = countMazePath(curr_row,curr_col + 1 , end_row,end_col);
		int vc = countMazePath(curr_row + 1 ,curr_col, end_row,end_col);

		return hc + vc;
	}

	public static void main(String[] args) {
		// execute one functions at a time 

		/* function to return arraylist & count of paths */
		ArrayList<String> mazepaths = getMazePath(0,0,2,2);
		System.out.println(mazepaths);
		System.out.println("Total paths count : " + mazepaths.size());

		/* function to print paths */
        System.out.println("\nPrinting MazePaths :");
		printMazePath(0,0,2,2,"");

		/* function to count  paths */
		int totalpaths = countMazePath(0,0,2,2);
		System.out.println(totalpaths);

	}
}

/*

[HHVV, HVHV, HVVH, VHHV, VHVH, VVHH]
Total paths count : 6

Printing MazePaths :
HHVV
HVHV
HVVH
VHHV
VHVH
VVHH
6

*/