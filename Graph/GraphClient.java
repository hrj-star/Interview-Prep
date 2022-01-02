import java.util.*;

public class GraphClient{
	public static void main(String[] args) {
	
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");

		g.addEdge("A","B",2);
		g.addEdge("A","D",3);
		g.addEdge("B","C",1);
		g.addEdge("C","D",8);
		g.addEdge("D","E",10);
		g.addEdge("E","F",45);
		g.addEdge("E","G",7);
		g.addEdge("F","G",18);

		g.display();

		System.out.println(g.noOfVertices());

		System.out.println(g.noOfEdges());

		System.out.println(g.containsVertex("A"));
		System.out.println(g.containsVertex("Z"));

		
		System.out.println(g.containsEdge("E","F"));
		System.out.println(g.containsEdge("A","C"));

		//g.removeEdge("A","B");
		//g.display();

		//g.removeVertex("G");
		//g.display();

		//g.addVertex("K");

		//g.addEdge("A","K",10);
		//g.display();

		System.out.println(g.hasPath("A","B",new HashMap<>()));

		System.out.println(g.BFS("A","F"));


		System.out.println(g.DFS("A","E"));

		g.BFT();

		g.DFT();

		System.out.println(g.isCyclic());

	
		System.out.println(g.isConnected()); // true

		//g.removeEdge("D","E");

		//System.out.println(g.isConnected()); // false

		System.out.println(g.isTree()); // false

		g.removeEdge("B","C"); // removing cycles
		g.removeEdge("F","G"); // removing cycles
		System.out.println(g.isTree()); // true

		// get connected components
		System.out.println(g.getCC()); // [[A, B, D, C, E, F, G]]
		g.removeEdge("D","E"); // breaking edge for between 2 components
		g.addVertex("H"); // adding new vertex for another component 
		System.out.println(g.getCC()); // [[A, B, D, C], [E, F, G], [H]]



		// krushkal

		g.krushkal();


	}
	


}