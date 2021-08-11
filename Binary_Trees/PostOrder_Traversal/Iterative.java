

 /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
                   /     \
                  8       9


Iterative version : Using 2 stacks.
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

    public static void postOrder(Node root){

        if(root == null){
            return;
        }

        Stack<Node> stk = new Stack<Node>();
        stk.push(root);

        // second Stack
        Stack<Integer>  output = new Stack<Integer>();
        while(!stk.empty()){

          Node curr = stk.pop();
          output.push(curr.data);

          if(curr.left != null){
            stk.push(curr.left);
          }

          if(curr.right != null){
            stk.push(curr.right);
          }

        }

        while(!output.empty()){
          System.out.print(output.pop()+" ");
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

    postOrder(root);

  }
      
}


/*

Solution : 4 5 2 8 6 9 7 3 1 



TC : O(n) : n - total nodes in binary tree

SC : O(logn) : average case - balanced (AVL , Red Black) , O(n) for worst case - skewed trees


*/