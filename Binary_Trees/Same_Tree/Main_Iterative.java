
import java.util.*;
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

class Main_Iterative{


    public static boolean isIdentical(Node p, Node q){
     
     // if both trees are empty, return true
      if(p == null && q == null)
        return true;

    // Return false if one is empty and other is not
      if (p == null || q == null) 
        return false;

      Stack<Node>  pstack = new Stack<Node>();
      Stack<Node>  qstack = new Stack<Node>();
      
      if(p != null)
        pstack.add(p);

      if(q != null)
        qstack.add(q);

      while(!pstack.isEmpty() && !qstack.isEmpty()){
        // pop front
        p = pstack.pop();
        q = qstack.pop();
        
        // check for same
        if(p.data != q.data){
          return false;
        }

        // push left child of both

        if(p.left != null && q.left != null){
          pstack.add(p.left);
          qstack.add(q.left);
        }
        
        // if size unequal, return false

        if(pstack.size() != qstack.size()){
          return false;
        }


         // push right child of both

        if(p.right != null && q.right != null){
          pstack.add(p.right);
          qstack.add(q.right);
        }

        // if size unequal, return false

        if(pstack.size() != qstack.size()){
          return false;
        }

      }
      

    return pstack.size() == qstack.size();
    
    }


  public static void main(String[] args){

// Construct first tree

    Node p = new Node(1);
    p.left = new Node(2);
    p.right= new Node(3);
    p.left.left = new Node(4);
    p.left.right = new Node(5);
    p.right.left = new Node(6);
    p.right.right = new Node(7);
    p.right.left.left = new Node(8);
    p.right.right.right = new Node(9);

// Construct second tree
    
    Node q = new Node(1);
    q.left = new Node(2);
    q.right= new Node(3);
    q.left.left = new Node(4);
    q.left.right = new Node(5);
    q.right.left = new Node(6);
    q.right.right = new Node(7);
    q.right.left.left = new Node(8);
    q.right.right.right = new Node(9);
    

    if(isIdentical(p,q)){
      System.out.println("Two trees are identical");
    }
    else{
      System.out.println("Two trees are not identical");
    }

  }
      
}


/*

Solution : Two trees are identical



TC : O(n) : n - total nodes in smaller tree , i.e n < m nodes of corresponding trees.
            or O(min(m, n)) where m and n are number of nodes in two trees.
            
SC : O(n) - stack space

*/