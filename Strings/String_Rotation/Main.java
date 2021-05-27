

class Main{


    public static boolean isSubstring(String  s1 , String  s2){

        int len1 =  s1.length();
        int len2 =  s2.length();

        String s1s1 = s1+s1;

        return (len1 == len2 && s1s1.indexOf(s2) != -1);

        
    	
    }


	public static void main(String[] args){

		String s1 = "waterbottle";
		String s2  = "erbottlewat";
        System.out.println(isSubstring(s1,s2));
	}
    	
}


/*

Solution : true

Complexity Analysis :
------------------

TC :  O(n*m) as indexOf() , where n , m are lengths of 2 strings 
      or O(n)

SC : O(n) , for constructing s1s1 string.

Sources : https://stackoverflow.com/questions/12752274/java-indexofstring-str-method-complexity

To-do : Optimize using KMP 

*/