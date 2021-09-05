class BST{

	private class Node{
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] arr){
		this.root = constructBST(arr , 0 , arr.length -1);
	}

	// construct BST

	private Node constructBST(int[] arr , int left , int right){ // type Node as every subtree will construct tree below it and return its root address
		
		// base case
		if(left > right){
			return null;
		}

		// mid
		int mid = left + (right - left) / 2;

		// create a new node
		Node newNode = new Node();
		newNode.data = arr[mid];
		newNode.left = constructBST(arr , left ,mid - 1);
		newNode.right = constructBST(arr,mid + 1 , right);

		// return node address
		return newNode;

	}

	// display BST

	public void display(){
		display(this.root);
	}

	private void display(Node root){

		// base case

		if(root == null){
			return;
		}

		// Self-work
		String str = "";

		if(root.left == null){
			str += ".";
		}
		else{
			str += root.left.data;
		}

		str += " -> " + root.data + " <- ";

		if(root.right == null){
			str += ".";
		}
		else{
			str += root.right.data;
		}

		// print ans

		System.out.println(str);

		// left subtree recursive
		display(root.left);

		// right subtree recursive
		display(root.right);
	}

	
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};

		BST b = new BST(arr);
		b.display();
	}
}

/* 
Output :
---------------------

20 -> 40 <- 60
10 -> 20 <- 30
. -> 10 <- .
. -> 30 <- .
50 -> 60 <- 70
. -> 50 <- .
. -> 70 <- .

*/