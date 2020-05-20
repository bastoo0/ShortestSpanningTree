import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Kruskal1 {

	private Graph graph;
	ArrayList<Edge> edgeList = new ArrayList<>();
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
		
		for(Edge e : edges) {
			
			DFSCycle c = new DFSCycle(graph);
			if(!c.isCycle(e)) {
				edgeList.add(e);
				graph.getAdjacencyList(e.getFrom()).add(e);
				graph.getAdjacencyList(e.getTo()).add(e);
				SPValue += e.getWeight();
			}
		}
		graph.printGraph();
	}
	
	public Integer getSPWeigth() {
		return SPValue;
	}
	

   
}
