
import java.util.ArrayDeque;
import java.util.Deque;

 /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
                   /     \
                  8       9
 */



class Node{
	int data;
	Node left=null , right=null;
	Node(int data){
		this.data=data;
	}
}

class Main{

   

    public static boolean isLeafNode(Node node){
    	return (node.left == null && node.right == null);
    }

    public static void printRootToLeaf(Node node , Deque<Integer> path){

        // base case

    	if(node == null){
    		return;
    	}
        
        // include the current node to the path

    	path.addLast(node.data);

    	// if a leaf node is found, print the path
    	if(isLeafNode(node)){
    		System.out.println(path);
    	}
    	

        // recur for the left and right subtree
    	printRootToLeaf(node.left,path);
    	printRootToLeaf(node.right,path);
        

        // remove the current / last node after the left, and right subtree are done
    	path.removeLast();


    }


    public static void printRootToLeaf(Node node){
    	Deque<Integer> path = new ArrayDeque<>();
    	printRootToLeaf(node , path);
    }


	public static void main(String[] args){

		Node root = new Node(1);
		root.left = new Node(2);
		root.right= new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
        root.right.right.right = new Node(9);

        printRootToLeaf(root);
	}
    	
}


/*

[1, 2, 4]
[1, 2, 5]
[1, 3, 6, 8]
[1, 3, 7, 9]

TC : O(n) : n - total nodes in binary tree

SC : O(h) : h - extra space for call stack.



Todo : Iterative version

*/