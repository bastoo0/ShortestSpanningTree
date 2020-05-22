package spaning_tree;

import java.util.List;
import java.util.Set;

public class Kruskal1 {

	private Graph graph;
	//ArrayList<spaning_tree.Edge> edgeList = new ArrayList<>();
	Integer SPValue = 0;
	
	public Kruskal1(Graph g) {
		this.graph = g;
		calcul();
	}
	
	public void calcul() {
		List<Edge> edges = graph.getAscendingOrderEdges();
		Set<Vertex> vectrices = graph.getAllVertex();
		for(Vertex v : vectrices) {
			graph.getGraph().get(v).clear();
		}
		Connexite c = new Connexite(graph);
		for(Edge e : edges) {
			
			if(!c.existsPathToDest(e)) {
				graph.getAdjacencyList(e.getFrom()).add(e);
				Edge back = new Edge(e.getTo(), e.getFrom(), e.getWeight());
				graph.getAdjacencyList(e.getTo()).add(back);

			}
		}
		SPValue = graph.getWeight();
		//graph.printGraph();
	}
	
	public Integer getSPWeigth() {
		return SPValue;
	}
	

   
}
