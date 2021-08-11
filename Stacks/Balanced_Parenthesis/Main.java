import java.util.Stack;

class Main{

	public static boolean balParenthesis(String str){

		// if length is not of even , then return false
		if(str.length() % 2  == 1 ){
			return false;
		}

		Stack<Character> stack = new Stack<>();

		char[] ch = str.toCharArray();
		for(char c : ch){
			if(c == '{' || c== '[' || c=='('){
				stack.push(c);
			}
			else if ( !stack.isEmpty() && (  ( c == '}' && stack.peek() == '{')
										  || ( c == ']' && stack.peek() == '[')
										  || ( c == ')' && stack.peek() == '(')
										  ))
			{
				stack.pop();
			}
			else{
				return false;
			}
		}
		return stack.empty();
	}

	public static void main(String[] args){
		String exp = "{()}[{}]";
 
        if (balParenthesis(exp)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
	}
}

/*

Output :
----------------------
Yes


Complexity Analysis :
---------------------------
Time Complexity  : O(n)
Space Complexity : O(n) - as stack  used. 

*/