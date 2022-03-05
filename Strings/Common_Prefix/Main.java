

class Main{


    public static void common_prefix(String  s1 , String  s2){

        int len1 =  s1.length();
        int len2 =  s2.length();

        int min_len =  Math.min(len1,len2);

        String prefix = "";

        for(int i = 0 ; i < min_len ; i++){
        	if(s1.charAt(i) != s2.charAt(i)){ 
        		prefix = s1.substring(0,i);
        		break;
        	}
        }

        System.out.println(prefix);
    	
    }


	public static void main(String[] args){

		String s1 = "GoogleEarth";
		String s2  = "GoogleKeep";
        common_prefix(s1,s2);
	}
    	
}


/*

Solution : Google



*/