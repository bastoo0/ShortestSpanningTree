
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
			
			for(int i = 0; i < edges.get(0).size(); i++) {
				graph.addEdge(edges.get(0).get(i), edges.get(1).get(i), edges.get(2).get(i));
			}
			
			//graph.printGraph();
			Kruskal1 k1 = new Kruskal1(graph);
			System.out.println("Kruskal 1 : " + k1.getSPWeigth());
			
			Kruskal2 k2 = new Kruskal2(graph);
			System.out.println("Kruskal 2 : " + k2.getSPWeigth());
	}

}
