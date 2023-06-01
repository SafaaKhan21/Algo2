/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package GraphFramework;

import PhoneNetworkApp.BluePrintsGraph;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class phase2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        BluePrintsGraph   g =new BluePrintsGraph();
//        g.readFromFile("Graph2.txt");
 //ShortestPathAlgorithm  d =new ShortestPathAlgorithm (g);
      DBAllSourceSPAlg dijkstra = new DBAllSourceSPAlg(g);
//              dijkstra.computeDijkstraBasedSPAlg();
//          dijkstra.display();
//          
System.out.println("--------------------------------------------------------------------------\n\n");  
Scanner input =new Scanner (System.in);
int n=0;int m=0;
        System.out.println("Enter your choice: ");
int choice =input.nextInt();
 switch (choice) {
                  case 1: {
                    n=2000;
                    m=10000;
                }
                break;
                case 2: {
                   n=3000;
                   m=15000;
                }
                break;
                case 3: {
                    n=4000;
                    m=20000;
                }
                break;
                case 4: {
                   n=5000;
                   m=25000;
                }
                break;
                case 5: {
                    n=6000 ;
                    m=30000;
                }
                break;
 }



          
          
     g.makeGraph(n, m);
     
     dijkstra = new DBAllSourceSPAlg(g);
        dijkstra.computeDijkstraBasedSPAlg();
         // dijkstra.displayTotal();

    }
    
    
    }

    

