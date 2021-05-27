
import java.util.ArrayDeque;
import java.util.Queue;

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

class Iterative{


    public static void preOrder(Node root){

        if(root == null){
            return;
        }

        System.out.print(root.data+ " ");

        preOrder(root.left);
        preOrder(root.right);
      
    }

    public static void swap(Node root){
      if(root == null){
        return;
      }

      Node temp = root.left;
      root.left = root.right;
      root.right = temp;
    }

  public static void invert_tree(Node root){
    // base case
    if(root == null){
      return;
    }

    Queue<Node> q = new ArrayDeque<>();
    q.add(root);

    // loop till queue empty

    while(!q.isEmpty()){
      Node curr = q.poll();

      // swap the left child with the right child
      swap(curr);

      if(curr.left != null){
        q.add(curr.left);
      }

      if(curr.right != null){
        q.add(curr.right);
      }

    }
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
    
    invert_tree(root);

    preOrder(root);
  }
      
}


/*

Solution : 1 3 7 9 6 8 2 5 4 

TC : O(n) : n - total nodes in binary tree

SC : O(n) : extra space for storing nodes


*/