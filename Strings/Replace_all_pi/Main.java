import java.util.*;
public class Main {

	public String replacePI(String s){
		int len = s.length();

		if(len<=1){
			return s;
		}

		String output = "";
		for(int i=0;i<len;i++){
			if(i+1 < len && s.charAt(i) == 'p' && s.charAt(i+1) == 'i'){
				output += "3.14";
				i++;
			}
			else{
				output += s.charAt(i);
			}
		}
		return output;
	}
	
    public static void main(String args[]) {

		Main m = new Main();
			
		System.out.println(m.replacePI("xpix"));
		System.out.println(m.replacePI("xabpixx3.15x"));
		System.out.println(m.replacePI("xpipippixx"));


    }
}

/* 
Output 
---------------------

x3.14x
xab3.14xx3.15x
x3.143.14p3.14xx

Time Complexity  : O(N) - N is length of String.

*/