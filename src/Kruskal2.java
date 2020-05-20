import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Kruskal2 {

	private Graph graph;
	ArrayList<Edge> removedEdgeList = new ArrayList<>();
	Integer SPValue = 0;
	
	public Kruskal2(Graph g) {
		this.graph = g;
		calcul();
	}
	
	public void calcul() {
		List<Edge> edges = graph.getDescendingOrderEdges();
		
		for(Edge e : edges) {
			
			DFSCycle c = new DFSCycle(graph);
			if(!c.isCycle(e)) {
				removedEdgeList.add(e);
				graph.getAdjacencyList(e.getFrom()).remove(e);
				graph.getAdjacencyList(e.getTo()).remove(e);
			}
		}
		
		for(Vertex v : graph.getAllVertex()) {
			for(Edge e : graph.getAdjacencyList(v)) {
					SPValue += e.getWeight();
			}
		}
		graph.printGraph();
	}
	
	public Integer getSPWeigth() {
		return SPValue;
	}
	

   
}
