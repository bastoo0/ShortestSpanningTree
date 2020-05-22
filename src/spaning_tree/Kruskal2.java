package spaning_tree;

import java.util.List;

public class Kruskal2 {

	private Graph graph;
	Integer SPValue = 0;
	private long exeTime;

	public Kruskal2(Graph g) {
		this.graph = g;
		calcul();
	}
	
	public void calcul() {
		long startTime = System.currentTimeMillis();

		List<Edge> edges = graph.getDescendingOrderEdges();
		
		Connexite c = new Connexite(graph);
		
		for(Edge e : edges) {
			
			// On retire l'arc du graph
			graph.getAdjacencyList(e.getFrom()).remove(e);
			Edge back = new Edge(e.getTo(), e.getFrom(), e.getWeight());
			graph.getAdjacencyList(e.getFrom()).remove(back);
			
			// Si il n'y a plus de chemin disponible d'un bout � l'autre de l'arc
			//  on remet l'arc dans le graph
			if(!c.existsPathToDest(e)) {
				graph.getAdjacencyList(e.getFrom()).add(e);
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
	

   
}
