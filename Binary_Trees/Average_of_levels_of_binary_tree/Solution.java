import java.util.*;

//  BFS solution - Iterative version

class Node{
    int data;
    Node left=null , right=null;
    Node(int data){
        this.data=data;
    }
}

class Solution {
    public static List<Double> averageOfLevels(Node root) {

    	List<Double> list = new ArrayList<>();

    	if(root == null){
    		return list;
    	}

    	Queue<Node> queue  = new LinkedList<>();

    	queue.add(root);

    	while(!queue.isEmpty()){

    		int size = queue.size();
    		double sum=0.0;

    		for(int i=0;i<size;i++){
    			Node node = queue.poll();
    			sum+=node.data;

    			if(node.left != null){
    				queue.offer(node.left); // offer() - returns true on successful insertion else it returns false
    			}
    			if(node.right != null){
    				queue.offer(node.right);
    			}

    		} // end for 

    		list.add(sum/size);

    	} // end while

        return list;
    }



    public static void main(String[] args){

        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(averageOfLevels(root));
 

        
    }
}


/*


Complexity Analysis :
-----------------------------

TC :  O(n) where n is the number of nodes in the tree.
SC :  O(h) where h is the height of the tree.

*/
