// Similar to iterative version
// https://www.ideserve.co.in/learn/how-to-find-the-power-of-a-number 

class Solution{

	static double calcpower(int num , int power){

		if(num == 0){
			return 0;
		}

		if(power == 0){
			return 1;
		}

		if(power < 0){
			return 1 /  calcpower(num , -power);
		}

		if(power % 2 == 0){
			return calcpower(num , power / 2) * calcpower(num , power / 2);
		}
		else{
			return num * calcpower(num , (power - 1 ) / 2) * calcpower(num , (power - 1 ) / 2);
		}

	}

	public static void main(String[] args) {
		double getPower = calcpower(2,-3); 
		System.out.println(getPower);
	}
}

/*

Output :
--------------------------

0.125

Complexity Analysis
--------------------------

Time : O(log n) , n = power


Space : O(1) , Aux Space 


*/