package spaning_tree;

import java.util.List;
import java.util.Set;

public class Kruskal1 {

	private Graph graph;
	Integer SPValue = 0;
	private long exeTime;

	public Kruskal1(Graph g) {
		this.graph = g;
		calcul();
	}
	
	public void calcul() {

		// La récupération et le nettoyage des arcs n'est pas pris en
		// compte dans le temps de calcul de l'algorithme
		List<Edge> edges = graph.getAscendingOrderEdges();
		Set<Vertex> vectrices = graph.getAllVertex();
		// Retire tous les arcs du graph
		for(Vertex v : vectrices) {
			graph.getGraph().get(v).clear();
		}
		
		long startTime = System.currentTimeMillis();
		
		Connexite c = new Connexite(graph);
		// Pour chaque arc
		for(Edge e : edges) { // O(N)
			// Si l'arc ne crée pas de cycle, on l'ajoute
			if(!c.existsPathToDest(e)) {
				graph.getAdjacencyList(e.getFrom()).add(e);
				Edge back = new Edge(e.getTo(), e.getFrom(), e.getWeight());
				graph.getAdjacencyList(e.getTo()).add(back);

			}
		}

		this.exeTime = System.currentTimeMillis() - startTime;
		SPValue = graph.getWeight();
		//graph.printGraph();
	}
	
	public Integer getSPWeigth() {
		return SPValue;
	}

	public long getExeTime() {
		return exeTime;
	}
	

   
}
