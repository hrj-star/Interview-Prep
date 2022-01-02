public class FtoC{
	public static void main(String[] args) {
		int fmin = 0;
		int fmax = 300;
		int fstep = 20;

		int fcurr = fmin;

		while(fcurr <= fmax){
			int celsius = (int)((fcurr - 32) * (5.0/9));
			System.out.println(fcurr + " " + celsius);
			fcurr += fstep;

			}	
		}
}

/*

0 -17
20 -6
40 4
60 15
80 26
100 37
120 48
140 60
160 71
180 82
200 93
220 104
240 115
260 126
280 137
300 148

*/