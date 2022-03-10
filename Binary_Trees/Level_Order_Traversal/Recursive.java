

 /* 

Level order traversal of a tree is breadth first traversal for the tree. 

 Construct the following tree
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

class Recursive{


    public static int getHeight(Node root){
        if(root == null){
            return  0;
        }

        return  1 + Math.max(getHeight(root.left) , getHeight(root.right));
    }

    public static void levelOrder(Node root , int level){

        if(root == null){
            return;
        }

        else if(level == 0){
            System.out.print(root.data + " ");
        }
        else if(level > 0){
            levelOrder(root.left,level - 1);
            levelOrder(root.right,level - 1);
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

    int height = getHeight(root);
    for(int i = 0 ; i < height ; i++){
        levelOrder(root,i);
    }

  }
      
}


/*

Solution : 1 2 3 4 5 6 7 8 9



TC : O(n) : n - total nodes in binary tree ,  O(n^2) in worst case. For a skewed tree, it takes O(n) time where n is the number of nodes in the skewed tree. So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2). 

SC : O(logn) : average case - balanced (AVL , Red Black) , O(n) for worst case - skewed trees


*/