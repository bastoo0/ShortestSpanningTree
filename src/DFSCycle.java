import java.util.ArrayList;

public class DFSCycle {

	private Graph graph;
	
	public DFSCycle(Graph g) {
		this.graph = g;
	}
	
	
	public boolean existsPathToDest(Edge e)
    {
		
		// Pour chaque sommet adjacent d'un des sommets de l'arc
            for(Edge ed : graph.getAdjacencyList(e.getFrom()))
            {
            	// On vérifie si il n'y existe pas un autre chemin vers l'autre sommet de l'arc
                if(findPathRecurs(e.getTo(), ed, new ArrayList<Vertex>()))
                {
                    return true;
                }
            }
        return false;
    }
	
	public boolean findPathRecurs(Vertex dest, Edge e, ArrayList<Vertex> vList) {
		// Ajoute le sommet dans la liste des visités
		vList.add(e.getTo());
		
		// Si le sommet que l'on visite est égal à celui qu'on doit trouver
		// (L'autre sommet de l'arc d'origine), on a un cycle
		if(e.getTo().equals(dest)) {
			return true;
		}
		

		// Tant qu'il y a des adjacences (récursivement), on les explore
		for(Edge edge : graph.getAdjacencyList(e.getTo())) {
			// On ne veut pas visiter plusieurs fois les mêmes sommets (récursion infinie)
			if(vList.contains(edge.getTo())) continue; 
			
			if(findPathRecurs(dest, edge, vList)) return true;
		}
		
		return false;
	}
	
	// Tentative infructueuse de Deep First Search
	/*
	 private boolean CycleRecurs(Vertex v, ArrayList<Vertex> visited, Vertex parent) 
	    { 
	        visited.add(v); 
	        //System.out.println("v:" + v.toString());
	        ArrayList<Edge> adj = graph.getAdjacencyList(v); 
	        
	        for (Edge i : adj) { 
	        	//adj.add(new Edge(i.getTo(), i.getFrom(), i.getWeight()));
	         System.out.print(i.toString() + " ; ");
	       // System.out.println(v + ":" + i);
	            if (!visited.contains(i.getTo()) && CycleRecurs(i.getTo(), visited, v)) 
	            { 
	                return true;
	        	}
	            if(!i.getTo().equals(parent)) {
	            	return true;
	            }
	        } 
	        return false; 
	    } 
	  
	    public boolean isCycle(Edge e) 
	    { 
	        ArrayList<Vertex> visited = new ArrayList<>();
	        
	        if (CycleRecurs(e.getFrom(), visited, null)) 
	            return true; 
	        
	        return false; 
	    } 
	    */
	   
}
