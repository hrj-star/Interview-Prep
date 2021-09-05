// Similar to iterative version
// https://www.ideserve.co.in/learn/how-to-find-the-power-of-a-number 

class Main{

	static int calcpower(int num , int power){

		if(power == 0){
			return 1;
		}

		if(num == 0){
			return 0;
		}

		return num  * calcpower(num , power-1);
	}

	public static void main(String[] args) {
		int getPower = calcpower(2,5); 
		System.out.println(getPower);
	}
}

/*

Output :
--------------------------

32

Complexity Analysis
--------------------------

Time : O(log n) , n = power


Space : O(1) , Aux Space 


*/