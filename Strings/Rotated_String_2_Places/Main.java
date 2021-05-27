

class Main{


    public static boolean isRotated(String  s1 , String  s2){

        if(s1.length() != s2.length())
            return false;

        if(s1.length() < 2)
            return s1.equals(s2);

        int len2=s2.length();
        String clockwise = s2.substring(2) + s2.substring(0,2);
        String anticlockwise = s2.substring(len2-2,len2) + s2.substring(0,len2-2);

        return (s1.equals(clockwise)) || (s1.equals(anticlockwise));

        

        
    	
    }


	public static void main(String[] args){

		String s1 = "amazon";
        String s2 = "azonam";
        System.out.println(isRotated(s1,s2));
	}
    	
}


/*

Solution : true

Complexity Analysis :
------------------

TC :  O(n)

SC :  O(1)





*/