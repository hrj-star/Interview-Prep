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


	// find in BST
	public boolean find(int item){
		return find(this.root , item);
	}

	private boolean find(Node node , int item){
		// base case

		if(node == null){
			return false;
		}

		// go deep left - recursive

		if(item <node.data){
			return find(node.left , item);
		}

		// go deep right - recursive
		else if(item > node.data){
			return find(node.right , item);
		}
		// node found
		else{
			return true;
		}
	}


	// max in BST

	public int max(){
		return max(this.root);
	}
	
	private int max(Node root){

		// positive base case -- return node whose right is null as thats the max node
		if(root.right == null){
			return root.data;
		}

		// right child recursive
		return max(root.right);
	}

	// min in BST

	public int min(){
		return min(this.root);
	}
	
	private int min(Node root){

		// positive base case -- return node whose right is null as thats the min node
		if(root.left == null){
			return root.data;
		}

		// left child recursive
		return min(root.left);
	}


	// add new node in BST

	public void add(int item){
		add(this.root , item);
	}

	public void add(Node root , int item){
		if(item > root.data){
			if(root.right == null){ //can add new node
				Node newNode = new Node();
				newNode.data = item;
				root.right = newNode;
			}
			else{ // current node is somewhere in middle so recur right
				add(root.right , item);
			}
		}
		else {
			if(item < root.data){
				if(root.left == null){ //can add new node
					Node newNode = new Node();
					newNode.data = item;
					root.left = newNode;
				}
				else{ // current node is somewhere in middle so recur left
					add(root.left , item);
				}
			}
		}
	}

	// remove node in BST

	public void remove(int item){
		remove(this.root , null , false ,item);
	}

	private void remove(Node root , Node parent , boolean isLeftChild , int item){

		// if target node item is not present in tree , then return

		if(root == null){
			return;
		}
		// if item < current node , then recur left
		if(item < root.data){
			remove(root.left , root , true , item);
		}
		// if item > current node , then recur right
		else if(item > root.data){
			remove(root.right , root ,false , item); // false -as its not left child
		}
		else{
			// if target node is found -> then 3 cases 

			// 1. if target is leaf node , then if its left child , then set parent left = null else right = null

			if(root.left == null && root.right == null){
				if(isLeftChild){
					parent.left = null;
				}
				else{
					parent.right = null;
				}
			}

			// 2a. If target node to be deleted  has right subtree and left is null , then if its left child  , then append right subtree to parent's left else append right subtree to parent's right.

				else if(root.left == null && root.right != null){
					if(isLeftChild){
						parent.left = root.right;
					}
					else{
						parent.right = root.right;
					}
				}

			// 2b. Similar to 2a - but opposite case.

				else if(root.left != null && root.right == null){
					if(isLeftChild){
						parent.left = root.left;
					}
					else{
						parent.right = root.left;
					}
				}

			// 3. if both left , right are not null , then compute max from left subtree or min from right subtree (any one) , make it root node and then remove the max / min node.

				else{
					int max = max(root.left);
					root.data = max;

					remove(root.left , root , true,max); // item = max as need to remove max from subtree
				}

		}
	}

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50,60,70};

		BST b = new BST(arr);  // construct
		System.out.println("Displaying BST ............");
		b.display(); // display

		System.out.println(b.find(50)); // search / find

		System.out.println("Max : " + b.max()); // max

		System.out.println("Min : " + b.min()); // min

		System.out.println("Adding new node ............");
		b.add(55); // add new node
		b.display();

		System.out.println("Removing node ............");
		b.remove(40); // remove node
		b.display();
	}
}

/* 
Output :
---------------------

Displaying BST ............
20 -> 40 <- 60
10 -> 20 <- 30
. -> 10 <- .
. -> 30 <- .
50 -> 60 <- 70
. -> 50 <- .
. -> 70 <- .

true

Max : 70

Min : 10

Adding new node ............
20 -> 40 <- 60
10 -> 20 <- 30
. -> 10 <- .
. -> 30 <- .
50 -> 60 <- 70
. -> 50 <- 55
. -> 55 <- .
. -> 70 <- .

Removing node ............
20 -> 30 <- 60
10 -> 20 <- .
. -> 10 <- .
50 -> 60 <- 70
. -> 50 <- 55
. -> 55 <- .
. -> 70 <- .

*/