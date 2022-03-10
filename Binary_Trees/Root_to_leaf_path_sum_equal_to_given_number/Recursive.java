  /* Construct the following tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            8   4   5   6
               /   / \   \
             10   7   9   5
        */

/* Possible sum :  11,17,16,15 */

class Node{
    int data;
    Node left=null , right=null;
    Node(int data){
        this.data=data;
    }
}

class Recursive{

   
    public static boolean hasPathSum(Node root , int targetSum){

        // base case
        if(root == null){
            return false;
        }
        
        // until reaches leaf node and sum - curr.data is 0 , then we have exhausted targetSum fully
        if(root.left == null && root.right == null && targetSum - root.data == 0) {
            return true;
        }

        // recur 
        return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right , targetSum - root.data);
      
    

    }

    public static void main(String[] args){

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(8);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(10);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(9);
        root.right.right.right = new Node(5);

        int  sum = 16;

        if(hasPathSum(root , sum)){
            System.out.println("Tree has root to leaf path equal to given sum: "+sum);

        }
        else{
            System.out.println("Tree does not have root to leaf path equal to given sum: "+sum);
        }
    }
        
}

/*

Tree has root to leaf path equal to given sum: 16



TC : O(n) : n - total nodes in binary tree

SC : O(h) : h- height of tree 



To-do :
Iterative version



*/

