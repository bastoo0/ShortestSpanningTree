package spaning_tree;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
	

	public static void main(String[] args) {
			GraphConverter gc = new GraphConverter();
			try {
				gc.openFile("./graphes_col/" + args[0]);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ArrayList<ArrayList<Integer>> edges = gc.getEdges();
			Graph graph = new Graph();
			Graph graph2 = new Graph();
			Graph graph3 = new Graph();
			Graph graph4 = new Graph();
			
			for(int i = 0; i < edges.get(0).size(); i++) {
				graph.addEdge(edges.get(0).get(i), edges.get(1).get(i), edges.get(2).get(i));
				graph2.addEdge(edges.get(0).get(i), edges.get(1).get(i), edges.get(2).get(i));
				graph3.addEdge(edges.get(0).get(i), edges.get(1).get(i), edges.get(2).get(i));
				graph4.addEdge(edges.get(0).get(i), edges.get(1).get(i), edges.get(2).get(i));
			}
			
			//graph.printGraph();
			
			System.out.println("Calculs du Minimum Spanning Tree sur le graph " + args[0] + " :\n");
			
			Kruskal1 k1 = new Kruskal1(graph);
			System.out.println("MST pour Kruskal 1 : " + k1.getSPWeigth()+ 
					" - calculé en " + k1.getExeTime() + " ms.");
			
			Kruskal2 k2 = new Kruskal2(graph2);
			System.out.println("MST pour Kruskal 2 (Reverse-Delete) : " + k2.getSPWeigth()+ 
					" - calculé en " + k2.getExeTime() + " ms.");

			Prim prim = new Prim(graph3);
			System.out.println("MST pour Prim : " + prim.getSPWeigth() + 
					" - calculé en " + prim.getExeTime() + " ms.");
			
			DPrim dprim = new DPrim(graph4, 3);
			System.out.println("d-MST pour Prim : " + dprim.getSPWeigth() + " - calculé en " 
			+ dprim.getExeTime() + " ms avec une contrainte de degré de " + dprim.getMaxDegreeResult() + ".");
	}

}