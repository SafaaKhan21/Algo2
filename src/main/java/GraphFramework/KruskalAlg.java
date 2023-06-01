/*Group members : Safaa Khan , 2110828 ,B0B
                Noof Patwa , 2111058 , B8
                Rania Daghestani , 2105893 , B8
                Dina Ghulam Saeed , 2110468 ,B8
For Prim Algorithm :https://www.learnerslesson.com/Data-Structures-and-Algorithms/Prim's-Algorithm-Minimum-Spanning-Tree-Code.htm
For Kruskal Algoritm :https://www.learnerslesson.com/Data-Structures-and-Algorithms/Prim's-Algorithm-Minimum-Spanning-Tree-Code.htm*/

package GraphFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class KruskalAlg extends MSTAlgorithm {

    Map<String , Node> map ;
    List<Edge> resultEdge ;
    KruskalAlg kruskalMST ;
    int total ;
    List<Edge> edgeList ;
        Graph graph;
        Vertex[] v;
       
    
    
 public KruskalAlg(Graph graph) {
     this.graph =graph ;
     
     v =graph.getVertex();
     map = new HashMap< >();
     resultEdge = new ArrayList< >();
    edgeList = new LinkedList< >();
     int total =0; 
     MSTResultList= new ArrayList();
   
 }
// this method is used to insert the all edes to list to sort
    void insertEdge() {
        
        Edge help=null;
            for (int i =0 ;i<v.length;i++){
                if (v[i] !=null)
               help =(v[i].getEdges().getHead());
     
                  while (help !=null){
                    help.setSource(v[i]);
                    edgeList.add(help);
                     help= help.getNext();
      }
              
    }
    }
     //-------------------------------------------------------------
    // Create groups with only one vertex.
    public void createSet(String  data){

        Node node = new Node();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        map.put(data, node);
    }
     //-------------------------------------------------------------
    //Combines two groups into one. Does union by rank.
    public void union(String  vertex1, String  vertex2){

        Node node1 = map.get(vertex1);
        Node node2 = map.get(vertex2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        //If they are in the same group, do nothing.
        if(parent1.data.equals( parent2.data)) {

            return;
        }
        //Else whose rank is higher becomes parent of other.
        if (parent1.rank <= parent2.rank) {

            //Increment rank only if both sets have same rank.
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        }
        else {

            parent1.parent = parent2;
        }
    }
     //-------------------------------------------------------------
    // Find the representative of this set

    public String  findSet(String  data){

        return findSet(map.get(data)).data;
    }

    // Finds the leader/representative recursivly and does PATH COMPRESSION as well.
    private Node findSet(Node node){

        Node parent = node.parent;
        if (parent == node) {

            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

     //-------------------------------------------------------------
    // Find Minimum Spanning Tree using Kruskal's Algorithm.
    public void  KruskalMST() {

        //Sort all edges in Ascending order.
        insertEdge();
        Collections.sort(edgeList);
        kruskalMST = new KruskalAlg(graph);

        //Create as many groups as the total vertices.
        for (int i =0; i<v.length;i++) {
            if (v[i] !=null)
                //(char)(v[i].getLabel()+65)+""
            kruskalMST.createSet(v[i].getLabel());
        }

       
       
        for (Edge edge : edgeList) {

            //Get the sets of two vertices of the edge.       
           String root1 = kruskalMST.findSet(edge.getSource().getLabel());
            String  root2 = kruskalMST.findSet(edge.getTarget().getLabel());

            //check if the vertices are on the same or different set.
            //If vertices are in the same set then ignore the edge.
            if (root1.equals(root2)) {

                continue;
            }
            else {
                
                 //((Line )edge).setLength(edge.getWeight()*5);  
                resultEdge.add(edge);
                MSTResultList.add(edge);
                total +=edge.getWeight();
                String source =(edge.getSource().getLabel());    
                String  target =(edge.getTarget().getLabel());
                kruskalMST.union(source ,target);
            }
        }
       
    }
       //-------------------------------------------------------------  
   

    @Override
     //-------------------------------------------------------------
// ///this method is used to display the result of thee Kruskal  Algorithm 
   
    public void displayResultingMST() {
        System.out.println("\n\n--------------------------------------------------------\n");
           System.out.println("\nThe phone network (minimum spanning tree) generated by Kruskal algorithm is as follows:\n");
    for (Edge edge : MSTResultList ) { 
         int i=0;
            for ( ;i<v.length;i++ ){
           if (v[i] !=null)
               if(v[i].getLabel().equals(edge.getSource().getLabel())){
                   //displayInfo() from  vertex class
                    v[i].displayInfo();
                  break;
               }
            }
          //displayInfo() from  Edge class
           edge.displayInfo();
           System.out.println();
    }
      System.out.println("The cost of designed phone network:"+total  );
  
}
 //-------------------------------------------------------------   
    public int getTotal() {
        return total;
    }
 //-------------------------------------------------------------
    public void setTotal(int total) {
        this.total = total;
    }
    
    
     }

    
    
