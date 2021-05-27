

class Main{


    public static boolean isPangram(String  s){

        int freq[] = new int[26];


        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch >= 'A' && ch<= 'Z'){
                freq[ch-'A']++;
            }
            else if(ch >= 'a' && ch<= 'z'){
                freq[ch-'a']++;
            }

        }

        for(int i=0;i<26;i++){
            if(freq[i] == 0){
                return false ; // not a pangram

            }
        }

        return true; // pangram

    }


	public static void main(String[] args){

		String s1 = "The quick brown fox jumps over the lazy dog";
        String s2 = "Programmer";
        System.out.println(isPangram(s1));
        System.out.println(isPangram(s2));
	}
    	
}


/*

Solution : 

true
false

Complexity Analysis :
------------------

TC :  O(n)

SC :  O(26) or O(1).





*/