

 /* Construct the following tree
                                   
                  1                           
                /   \                        
              2       3     
             / \     / \                     
            4   5   6   7                 
                   /     \                
                  8       9 
 */



/* Recursive */

class Node{
  int data;
  Node left=null , right=null;
  Node(int data){
    this.data=data;
  }
}

class Main{
  static int getHeight(Node root){
    // base case
    if(root == null){
      return 0;
    }
    return 1+Math.max(getHeight(root.left) , getHeight(root.right));
  }


  public static void main(String[] args){

    Node p = new Node(1);
    p.left = new Node(2);
    p.right= new Node(3);
    p.left.left = new Node(4);
    p.left.right = new Node(5);
    p.right.left = new Node(6);
    p.right.right = new Node(7);
    p.right.left.left = new Node(8);
    p.right.right.right = new Node(9);

    int height = getHeight(p);
    System.out.println("Height is : "+height);

  }
      
}


/*

Solution :
----------------------
Height is : 4

Complexity Analysis :
-----------------------------
TC : O(n)
SC : O(n) - recursion stack





*/