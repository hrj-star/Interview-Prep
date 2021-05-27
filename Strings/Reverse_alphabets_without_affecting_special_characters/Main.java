

class Main{


    public static void reverseString(char ch[]){

        // initialize pointers
        int n=ch.length;

        int left = 0 ,right = n-1;

        
        while(left < right){
           
            // ignore special characters

            if(!Character.isAlphabetic(ch[left])){
                left++;
            }
            else if(!Character.isAlphabetic(ch[right])){
                right--;
            }
            else{
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        
    	
}


	public static void main(String[] args){

		String str = "a,b$c";
	
        char[] charArray = str.toCharArray(); 

        reverseString(charArray);

        String revStr = new String(charArray); 
  
        System.out.println("Output string: " + revStr); 
	}
    	
}


/*

Output string: c,b$a

Complexity Analysis :
------------------

TC :  O(n) 

SC : O(1) 

*/