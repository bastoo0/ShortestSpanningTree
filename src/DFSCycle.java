import java.util.ArrayList;

public class DFSCycle {

	private Graph graph;
	
	public DFSCycle(Graph g) {
		this.graph = g;
	}
	
	 private boolean CycleRecurs(Edge e, ArrayList<Edge> visited, Edge parent) 
	    { 
	        visited.add(e); 
	        ArrayList<Edge> adj = graph.getAdjacencyList(e.getTo()); 
	        //System.out.println(v + ":" + parent + " = " + adj.toString());
	        for (Edge i : adj) {
	        //	System.out.println(v + ":" + i);
	            if (!visited.contains(i)) 
	            { 
	                if (CycleRecurs(i, visited, e))
	                    return true; 
	            } 
	  
	            else if (!i.equals(parent)) 
	                return true; 
	        } 
	        return false; 
	    } 
	  
	    public boolean isCycle(Edge e) 
	    { 
	        ArrayList<Edge> visited = new ArrayList<>();
	  
	        if (CycleRecurs(e, visited, null)) 
	            return true; 
	  
	        return false; 
	    } 
}
