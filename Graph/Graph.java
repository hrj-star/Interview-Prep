import java.util.*;

public class Graph {



    private class Vertex { // single vertex containing hashmap of eg : A,1 as key - value pair for their neighbours - ngbrs hashmap 
        HashMap < String, Integer > ngbrs = new HashMap < > ();
    }

    // now graph will have own set of vertices , Eg : A - 2k address

    HashMap < String, Vertex > vertices;

    // initialize new vertex
    public Graph() {
        vertices = new HashMap < > ();
    }

    // count no of vertices 

    public int noOfVertices() {
        return this.vertices.size();
    }

    // check if given vertex exists

    public boolean containsVertex(String ver) {
        return this.vertices.containsKey(ver);
    }

    // add new vertex
    public void addVertex(String new_vertex) {
        Vertex v = new Vertex();
        vertices.put(new_vertex, v);
    }

    // remove vertex
    /*

    1. Find neighbours of A 
    2. Remove A from neighbours hashmap
    3. Now remove A from vertices hashmap.
    */

    public void removeVertex(String vname) {
        Vertex v = vertices.get(vname);

        ArrayList < String > keys = new ArrayList < > (v.ngbrs.keySet());

        for (String key: keys) {
            Vertex ngbrVertex = vertices.get(key);

            ngbrVertex.ngbrs.remove(vname); // removed from neighbours
        }

        vertices.remove(vname); // removed from vertices
    }

    public void display() { // display 

        System.out.println("----------------------------------");
        ArrayList < String > keys = new ArrayList < > (vertices.keySet());

        for (String key: keys) {
            Vertex v = vertices.get(key);
            System.out.println(key + " " + v.ngbrs);
        }

        System.out.println("----------------------------------");
    }



    // count no of edges

    public int noOfEdges() {
        int count = 0;

        ArrayList < String > keys = new ArrayList < String > (vertices.keySet()); // get keys of vertexex eg : A,B

        for (String key: keys) { // loop through each key and capture their  value i.e number of Vertex
            Vertex v = vertices.get(key);
            count += v.ngbrs.size();
        }

        return count / 2; // as count has same edge counted from both the vertex
    }

    // check if given edge exists

    public boolean containsEdge(String vname1, String vname2) {
        Vertex v1 = vertices.get(vname1); // get address i.e vertex value for vname1 key
        Vertex v2 = vertices.get(vname2); // get address i.e vertex value for vname2 key

        if (v1 == null || v2 == null || !v1.ngbrs.containsKey(vname2)) {
            return false;
        }

        return true;
    }

    // add edges between 2 vertices with given cose

    public void addEdge(String vname1, String vname2, int cost) {
        // let vname1 = A , vname2 = C

        Vertex v1 = vertices.get(vname1); // get address i.e vertex value for A - 2k
        Vertex v2 = vertices.get(vname2); // get address i.e vertex value for C - 4k

        // if either of vertex is not present , then cant add edge - return
        // return if edge already exists between them as no need to add again

        if (v1 == null || v2 == null || v1.ngbrs.containsKey(vname2)) {
            return;
        }

        // else add edge
        v1.ngbrs.put(vname2, cost); // at neighbour of 2k - put C with given cost
        v2.ngbrs.put(vname1, cost); // at neighbour of 4k - put A with given cost
    }


    // remove edges between 2 vertices 

    public void removeEdge(String vname1, String vname2) {
        // let vname1 = A , vname2 = C

        Vertex v1 = vertices.get(vname1); // get address i.e vertex value for A - 2k
        Vertex v2 = vertices.get(vname2); // get address i.e vertex value for C - 4k

        // if either of vertex is not present , then cant remove edge - return
        // return if no edge exists as it is already removed

        if (v1 == null || v2 == null || !v1.ngbrs.containsKey(vname2)) {
            return;
        }

        // else remove existing edge
        v1.ngbrs.remove(vname2); // from 2k - remove C 
        v2.ngbrs.remove(vname1); // from 4k - remove A
    }

    // HasPath

    public boolean hasPath(String vname1, String vname2, HashMap < String, Boolean > processed) {

        // put current in processed Hashmap

        processed.put(vname1, true);

        // if direct path

        if (containsEdge(vname1, vname2)) {
            return true;
        }

        // if direct path does not exists ,  then pass the work to neighbour

        Vertex v = vertices.get(vname1); // get address value for neighbours hashmap

        ArrayList < String > nbrs = new ArrayList < > (vertices.keySet()); // get neighbours key

        for (String nbr: nbrs) { // check if haspath() among neighbours
            if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed)) {
                return true;
            }
        }

        // if path does not exists from any of above 

        return false;

    }


    // BFS : Breadth First Search

    private class Pair {
        String vname;
        String path_so_far;
    }

    public boolean BFS(String src, String dest) {

        // Hashmap to store visited / processed vertexes
        HashMap < String, Boolean > processed = new HashMap < > ();

        LinkedList < Pair > queue = new LinkedList < > ();

        // create a new pair
        Pair p = new Pair();
        p.vname = src;
        p.path_so_far = src;

        // put the new pair in queue -- will use addLast() & removeFirst() function as they are of O(1)
        queue.addLast(p);

        //  while queue not empty , keep doing the following work

        while (!queue.isEmpty()) {

            // remove pair at first from queue
            Pair remove_pair = queue.removeFirst();

            // if different pair but same vertex encountered then ignore that , do not process again eg: ABC , ADC , process C only once
            if (processed.containsKey(remove_pair.vname)) {
                continue; // will skip below lines and go to above while(!q.isEmpty()) line 
            }

            // put removed in processed map
            processed.put(remove_pair.vname, true);

            // if direct edge exists between src and dest
            if (containsEdge(remove_pair.vname, dest)) {
                System.out.println(remove_pair.path_so_far + "" + dest);
                return true;
            }

            // else go to neighbours (breadth wise) 
            // 1. Get value (neighbours address) for removed vertex .


            Vertex removed_vertex = vertices.get(remove_pair.vname);
            ArrayList < String > nbrs = new ArrayList < > (removed_vertex.ngbrs.keySet());

            // 2. Process only unvisited neighbours
            // 3. Put new neighbour pair in queue
            for (String nbr: nbrs) {
                if (!processed.containsKey(nbr)) {
                    Pair new_pair = new Pair();
                    new_pair.vname = nbr;
                    new_pair.path_so_far = remove_pair.path_so_far + nbr;
                    queue.addLast(new_pair);
                }
            }


        }

        return false; // if not containsEdge anywhere
    }

    // DFS

    public boolean DFS(String src, String dest) {

        // Hashmap to store visited / processed vertexes
        HashMap < String, Boolean > processed = new HashMap < > ();

        LinkedList < Pair > stack = new LinkedList < > ();

        // create a new pair
        Pair p = new Pair();
        p.vname = src;
        p.path_so_far = src;

        // put the new pair in stack -- will use addFirst() & removeFirst() function as they are of O(1)
        stack.addFirst(p);

        //  while stack not empty , keep doing the following work

        while (!stack.isEmpty()) {

            // remove pair at first from stack
            Pair remove_pair = stack.removeFirst();

            // if different pair but same vertex encountered then ignore that , do not process again eg: ABC , ADC , process C only once
            if (processed.containsKey(remove_pair.vname)) {
                continue; // will skip below lines and go to above while(!q.isEmpty()) line 
            }

            // put removed in processed map
            processed.put(remove_pair.vname, true);

            // if direct edge exists between src and dest
            if (containsEdge(remove_pair.vname, dest)) {
                System.out.println(remove_pair.path_so_far + "" + dest);
                return true;
            }

            // else go to neighbours (breadth wise) 
            // 1. Get value (neighbours address) for removed vertex .


            Vertex removed_vertex = vertices.get(remove_pair.vname);
            ArrayList < String > nbrs = new ArrayList < > (removed_vertex.ngbrs.keySet());

            // 2. Process only unvisited neighbours
            // 3. Put new neighbour pair in stack
            for (String nbr: nbrs) {
                if (!processed.containsKey(nbr)) {
                    Pair new_pair = new Pair();
                    new_pair.vname = nbr;
                    new_pair.path_so_far = remove_pair.path_so_far + nbr;
                    stack.addFirst(new_pair);
                }
            }


        }

        return false; // if not containsEdge anywhere
    }

    // BFT = Breadth First Traversal

    public void BFT() {

        // Hashmap to store visited / processed vertexes
        HashMap < String, Boolean > processed = new HashMap < > ();

        LinkedList < Pair > queue = new LinkedList < > ();

        ArrayList < String > keys = new ArrayList < > (vertices.keySet());

        // for every node repeat the process

        for (String key: keys) {

            // for each component 
            if (processed.containsKey(key)) {
                continue;
            }

            // create a new pair
            Pair p = new Pair();
            p.vname = key;
            p.path_so_far = key;

            // put the new pair in queue -- will use addLast() & removeFirst() function as they are of O(1)
            queue.addLast(p);

            //  while queue not empty , keep doing the following work

            while (!queue.isEmpty()) {

                // remove pair at first from queue
                Pair remove_pair = queue.removeFirst();

                // if different pair but same vertex encountered then ignore that , do not process again eg: ABC , ADC , process C only once
                if (processed.containsKey(remove_pair.vname)) {
                    continue; // will skip below lines and go to above while(!q.isEmpty()) line 
                }

                // put removed in processed map
                processed.put(remove_pair.vname, true);

                // if direct edge exists between src and dest

                System.out.println(remove_pair.vname + " via " + remove_pair.path_so_far);


                // else go to neighbours (breadth wise) 
                // 1. Get value (neighbours address) for removed vertex .


                Vertex removed_vertex = vertices.get(remove_pair.vname);
                ArrayList < String > nbrs = new ArrayList < > (removed_vertex.ngbrs.keySet());

                // 2. Process only unvisited neighbours
                // 3. Put new neighbour pair in queue
                for (String nbr: nbrs) {
                    if (!processed.containsKey(nbr)) {
                        Pair new_pair = new Pair();
                        new_pair.vname = nbr;
                        new_pair.path_so_far = remove_pair.path_so_far + nbr;
                        queue.addLast(new_pair);
                    }
                }

            }

        } // for close 

    }



    //  DFT - Depth First Traversal

    public void DFT() {

        // Hashmap to store visited / processed vertexes
        HashMap < String, Boolean > processed = new HashMap < > ();

        LinkedList < Pair > stack = new LinkedList < > ();

        ArrayList < String > keys = new ArrayList < > (vertices.keySet());

        // for every node repeat the process

        for (String key: keys) {

            // for each component 
            if (processed.containsKey(key)) {
                continue;
            }

            // create a new pair
            Pair p = new Pair();
            p.vname = key;
            p.path_so_far = key;

            // put the new pair in stack -- will use addFirst() & removeFirst() function as they are of O(1)
            stack.addLast(p);

            //  while stack not empty , keep doing the following work

            while (!stack.isEmpty()) {

                // remove pair at first from stack
                Pair remove_pair = stack.removeFirst();

                // if different pair but same vertex encountered then ignore that , do not process again eg: ABC , ADC , process C only once
                if (processed.containsKey(remove_pair.vname)) {
                    continue; // will skip below lines and go to above while(!q.isEmpty()) line 
                }

                // put removed in processed map
                processed.put(remove_pair.vname, true);

                // if direct edge exists between src and dest

                System.out.println(remove_pair.vname + " via " + remove_pair.path_so_far);


                // else go to neighbours (breadth wise) 
                // 1. Get value (neighbours address) for removed vertex .


                Vertex removed_vertex = vertices.get(remove_pair.vname);
                ArrayList < String > nbrs = new ArrayList < > (removed_vertex.ngbrs.keySet());

                // 2. Process only unvisited neighbours
                // 3. Put new neighbour pair in stack
                for (String nbr: nbrs) {
                    if (!processed.containsKey(nbr)) {
                        Pair new_pair = new Pair();
                        new_pair.vname = nbr;
                        new_pair.path_so_far = remove_pair.path_so_far + nbr;
                        stack.addFirst(new_pair);
                    }
                }


            }

        } // for close 

    } // DFT() close



    // Determine if Graph is cyclic or not - same logic as BFT

    /*

    IF paths to C more than 1 , ABC , ADC then there exists a cycle . In normal BFT , one C is processed and other one is ignored . If ignored path exists then CYCLE EXISTS is graph.
    */

    public boolean isCyclic() {

        // Hashmap to store visited / processed vertexes
        HashMap < String, Boolean > processed = new HashMap < > ();

        LinkedList < Pair > queue = new LinkedList < > ();

        ArrayList < String > keys = new ArrayList < > (vertices.keySet());

        // for every node repeat the process

        for (String key: keys) {

            // for each component 
            if (processed.containsKey(key)) {
                continue;
            }

            // create a new pair
            Pair p = new Pair();
            p.vname = key;
            p.path_so_far = key;

            // put the new pair in queue -- will use addLast() & removeFirst() function as they are of O(1)
            queue.addLast(p);

            //  while queue not empty , keep doing the following work

            while (!queue.isEmpty()) {

                // remove pair at first from queue
                Pair remove_pair = queue.removeFirst();

                // if different pair but same vertex encountered then ignore that , do not process again eg: ABC , ADC , process C only once
                if (processed.containsKey(remove_pair.vname)) {
                    return true; // cycle exists
                }

                // put removed in processed map
                processed.put(remove_pair.vname, true);

                // if direct edge exists between src and dest

                //	System.out.println(remove_pair.vname+" via "+ remove_pair.path_so_far);


                // else go to neighbours (breadth wise) 
                // 1. Get value (neighbours address) for removed vertex .


                Vertex removed_vertex = vertices.get(remove_pair.vname);
                ArrayList < String > nbrs = new ArrayList < > (removed_vertex.ngbrs.keySet());

                // 2. Process only unvisited neighbours
                // 3. Put new neighbour pair in queue
                for (String nbr: nbrs) {
                    if (!processed.containsKey(nbr)) {
                        Pair new_pair = new Pair();
                        new_pair.vname = nbr;
                        new_pair.path_so_far = remove_pair.path_so_far + nbr;
                        queue.addLast(new_pair);
                    }
                }

            }

        } // for close 

        return false; // no cycle found
    } // isCyclic() end


    // isConnected - same logic as BFT
    public boolean isConnected() {

        // initialize flag = 0 ;
        int flag = 0;

        // Hashmap to store visited / processed vertexes
        HashMap < String, Boolean > processed = new HashMap < > ();

        LinkedList < Pair > queue = new LinkedList < > ();

        ArrayList < String > keys = new ArrayList < > (vertices.keySet());

        // for every node repeat the process

        for (String key: keys) {

            // for each component 
            if (processed.containsKey(key)) {
                continue;
            }

            // will execute this region from below if graph is not connected and have more than 2 components ,hence initialize from new component vertex altogether
            flag++;

            // create a new pair
            Pair p = new Pair();
            p.vname = key;
            p.path_so_far = key;

            // put the new pair in queue -- will use addLast() & removeFirst() function as they are of O(1)
            queue.addLast(p);

            //  while queue not empty , keep doing the following work

            while (!queue.isEmpty()) {

                // remove pair at first from queue
                Pair remove_pair = queue.removeFirst();

                // if different pair but same vertex encountered then ignore that , do not process again eg: ABC , ADC , process C only once
                if (processed.containsKey(remove_pair.vname)) {
                    continue; // cycle exists
                }

                // put removed in processed map
                processed.put(remove_pair.vname, true);

                // if direct edge exists between src and dest

                //	System.out.println(remove_pair.vname+" via "+ remove_pair.path_so_far);


                // else go to neighbours (breadth wise) 
                // 1. Get value (neighbours address) for removed vertex .


                Vertex removed_vertex = vertices.get(remove_pair.vname);
                ArrayList < String > nbrs = new ArrayList < > (removed_vertex.ngbrs.keySet());

                // 2. Process only unvisited neighbours
                // 3. Put new neighbour pair in queue
                for (String nbr: nbrs) {
                    if (!processed.containsKey(nbr)) {
                        Pair new_pair = new Pair();
                        new_pair.vname = nbr;
                        new_pair.path_so_far = remove_pair.path_so_far + nbr;
                        queue.addLast(new_pair);
                    }
                }

            }

        } // for close 

        // if flag>=2 , then atleast 2 different component exists hence not conn else conn.

        if (flag >= 2) {
            return false;
        } else {
            return true;
        }
    }


    // isTree() : Is Tree - if no cycle exists && graph is connected then True else False.
    public boolean isTree() {
        return (!isCyclic() && isConnected());
    }

    // Get connected components

    public ArrayList < ArrayList < String >> getCC() {

        ArrayList < ArrayList < String >> ans = new ArrayList < > (); // for final ans

        // Hashmap to store visited / processed vertexes
        HashMap < String, Boolean > processed = new HashMap < > ();

        LinkedList < Pair > queue = new LinkedList < > ();

        ArrayList < String > keys = new ArrayList < > (vertices.keySet());

        // for every node repeat the process

        for (String key: keys) {

            // for each component 
            if (processed.containsKey(key)) {
                continue;
            }

            // new component gets created here-- initialize with ArrayList and add all its connected vertices to it
            ArrayList < String > subans = new ArrayList < > ();

            // create a new pair
            Pair p = new Pair();
            p.vname = key;
            p.path_so_far = key;

            // put the new pair in queue -- will use addLast() & removeFirst() function as they are of O(1)
            queue.addLast(p);

            //  while queue not empty , keep doing the following work

            while (!queue.isEmpty()) {

                // remove pair at first from queue
                Pair remove_pair = queue.removeFirst();

                // if different pair but same vertex encountered then ignore that , do not process again eg: ABC , ADC , process C only once
                if (processed.containsKey(remove_pair.vname)) {
                    continue; // will skip below lines and go to above while(!q.isEmpty()) line 
                }

                // put removed in processed map
                processed.put(remove_pair.vname, true);

                // if direct edge exists between src and dest

                // put in subsans arraylist

                subans.add(remove_pair.vname);

                // else go to neighbours (breadth wise) 
                // 1. Get value (neighbours address) for removed vertex .


                Vertex removed_vertex = vertices.get(remove_pair.vname);
                ArrayList < String > nbrs = new ArrayList < > (removed_vertex.ngbrs.keySet());

                // 2. Process only unvisited neighbours
                // 3. Put new neighbour pair in queue
                for (String nbr: nbrs) {
                    if (!processed.containsKey(nbr)) {
                        Pair new_pair = new Pair();
                        new_pair.vname = nbr;
                        new_pair.path_so_far = remove_pair.path_so_far + nbr;
                        queue.addLast(new_pair);
                    }
                }
            }

            ans.add(subans); // add subans arraylist in final ans

        } // for close 
        return ans; // return final ans arraylist
    } // getCC() end



    private class PrimsPair{
    	String vname;
    	String acquiring_vname;
    	int cost;
    }

    public Graph prims(){
    	Graph mst = new Graph();
    	
    }



    public class DisjointSet {

        HashMap < String, Node > map = new HashMap < > ();

        private class Node {
            String data;
            Node parent;
            int rank;
        }

        public void create(String value) {
            Node newNode = new Node();
            newNode.data = value;
            newNode.parent = newNode; // if first node in any set , then its parent of itself
            newNode.rank = 0;

            map.put(value, newNode);
        }

        public void union(String value1, String value2) {
            Node n1 = map.get(value1);
            Node n2 = map.get(value2);

            Node rep1 = find(n1);
            Node rep2 = find(n2);

            if (rep1.data.equals(rep2.data)) {
                return;
            } else {
                if (rep1.rank == rep2.rank) {
                    rep2.parent = rep1;
                    rep1.rank = rep1.rank + 1;
                } else if (rep1.rank > rep2.rank) {
                    rep2.parent = rep1;
                } else {
                    rep1.parent = rep2;
                }
            }
        }

        public String find(String value) {
            return find(map.get(value)).data;
        }

        private Node find(Node node) {
            if (node == node.parent) { // move till upward and reached to root node 
                return node;
            }

            Node result = find(node.parent);
            node.parent = result; // path compression of create , union , find - in O(1) complexity
            return result;
        }
	} // DisjointSet class end

        private class EdgePair implements Comparable < EdgePair > {
            String v1;
            String v2; // 2 vertices having edge between them
            int cost; // cost of edge between them

            public int compareTo(EdgePair o) {
                return this.cost - o.cost;
            }

            public String toString() {
                return v1 + " - " + v2 + " : " + cost;
            }
        } // class EdgePair end

        // function that stores edges in arraylist
        public ArrayList < EdgePair > getAllEdges() {
            ArrayList < EdgePair > edges = new ArrayList < > ();

            for (String vname: vertices.keySet()) {
                Vertex v = vertices.get(vname);

                for (String nbr: v.ngbrs.keySet()) {
                    EdgePair ep = new EdgePair();
                    ep.v1 = vname;
                    ep.v2 = nbr;
                    ep.cost = v.ngbrs.get(nbr);

                    edges.add(ep);
                }
            }
            return edges;
        } //getAllEdges() end


        public void krushkal() {
            // sort the edges in increasing order of weight
            ArrayList < EdgePair > edges = getAllEdges();
            Collections.sort(edges);
            System.out.println(edges);

        }// krushkal() end


    


}