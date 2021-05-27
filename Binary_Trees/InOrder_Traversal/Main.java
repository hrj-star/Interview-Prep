

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


    public static void inOrder(Node root){

        if(root == null){
            return;
        }

        inOrder(root.left);

        System.out.print(root.data+ " ");

        
        inOrder(root.right);
      
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

    inOrder(root);

  }
      
}


/*

Solution : 4 2 5 1 8 6 3 7 9



TC : O(n) : n - total nodes in binary tree

SC : O(logn) : average case - balanced (AVL , Red Black) , O(n) for worst case - skewed trees

*/