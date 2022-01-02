import java.util.Arrays;

class Main{
	public static void main(String[] args) {
		String a = "geeks";
		String b = "geeksfor";
		String c = "geeksforgeeks";

		System.out.println(LCS3Strings(a,b,c,0,0,0));

		int[][][] strg_arr = new int[a.length()][b.length()][b.length()];

		for(int i=0;i<strg_arr.length;i++){
			for(int j=0;j<strg_arr[0].length;j++){
				Arrays.fill(strg_arr[i][j] , -1);
			}
		}

		System.out.println(LCS3StringsTopDownDP(a,b,c,0,0,0,strg_arr));

		System.out.println(LCS3StringsBottomUpDP(a,b,c));
	}

	public static int LCS3Strings(String a , String b , String c , int vidx1, int vidx2 , int vidx3){
		if(a.length() == vidx1 || b.length() == vidx2 || c.length() == vidx3){
			return 0;
		}

		int ans = 0;

		if(a.charAt(vidx1) == b.charAt(vidx2) && b.charAt(vidx2) == c.charAt(vidx3)){
			ans = LCS3Strings(a,b,c,vidx1 + 1,vidx2 + 1,vidx3+1) + 1;
		}
		else{
			int option1 = LCS3Strings(a,b,c,vidx1 + 1,vidx2,vidx3);
			int option2 = LCS3Strings(a,b,c,vidx1,vidx2 + 1,vidx3);
			int option3 = LCS3Strings(a,b,c,vidx1,vidx2,vidx3 + 1);

			ans = Math.max(option1,Math.max(option2,option3));
		}
		return ans;
	}



	public static int LCS3StringsTopDownDP(String a , String b , String c , int vidx1, int vidx2 , int vidx3 , int[][][] strg_arr){
		if(a.length() == vidx1 || b.length() == vidx2 || c.length() == vidx3){
			return 0;
		}

		if(strg_arr[vidx1][vidx2][vidx3] != -1){
			return strg_arr[vidx1][vidx2][vidx3];
		}

		int ans = 0;

		if(a.charAt(vidx1) == b.charAt(vidx2) && b.charAt(vidx2) == c.charAt(vidx3)){
			ans = LCS3StringsTopDownDP(a,b,c,vidx1 + 1,vidx2 + 1,vidx3+1,strg_arr) + 1;
		}
		else{
			int option1 = LCS3StringsTopDownDP(a,b,c,vidx1 + 1,vidx2,vidx3,strg_arr);
			int option2 = LCS3StringsTopDownDP(a,b,c,vidx1,vidx2 + 1,vidx3,strg_arr);
			int option3 = LCS3StringsTopDownDP(a,b,c,vidx1,vidx2,vidx3 + 1,strg_arr);

			ans = Math.max(option1,Math.max(option2,option3));
		}

		strg_arr[vidx1][vidx2][vidx3] = ans;

		return ans;
	}


	public static int LCS3StringsBottomUpDP(String a, String b, String c){

		int[][][] strg_arr =  new int[a.length() + 1][b.length() + 1][c.length() + 1];

		for(int ai = a.length() - 1 ; ai >= 0 ; ai--){
			for(int bi = b.length() - 1 ; bi >= 0 ; bi--){
				for(int ci = c.length() - 1 ; ci >= 0 ; ci--){

					int ans = 0;

					if(a.charAt(ai) == b.charAt(bi) && b.charAt(bi) == c.charAt(ci)){
						ans = strg_arr[ai + 1][bi + 1][ci + 1]+ 1;
					}
					else{
						int option1 = strg_arr[ai + 1][bi][ci]; 
						int option2 = strg_arr[ai][bi + 1][ci];
						int option3 = strg_arr[ai][bi][ci + 1];

						ans = Math.max(option1,Math.max(option2,option3));
					}

					strg_arr[ai][bi][ci] = ans;
				}
			}
		}

		return strg_arr[0][0][0];
	}
}