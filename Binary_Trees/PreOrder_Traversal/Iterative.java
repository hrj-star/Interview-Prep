

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


import java.util.*;

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

        Stack<Node> stk = new Stack<Node>();
        stk.push(root);

        while(!stk.empty()){
          Node top = stk.peek();
          System.out.print(top.data+" ");
          stk.pop();

          // push right and left child - opposite push as stack
         
          if(top.right != null){
            stk.push(top.right);
          }

          if(top.left != null){
            stk.push(top.left);
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

    preOrder(root);
  }
      
}


/*

Solution : 1 2 4 5 3 6 8 7 9

TC : O(n) : n - total nodes in binary tree

SC : O(n) : aux space , n - total nodes in binary tree


*/