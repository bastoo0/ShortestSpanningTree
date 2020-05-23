package spaning_tree;

import java.util.HashSet;

public class Connexite {

	private Graph graph;
	
	public Connexite(Graph g) {
		this.graph = g;
	}
	
	
	public boolean existsPathToDest(Edge e)
    {
		// Pour chaque sommet adjacent d'un des sommets de l'arc
            for(Edge ed : graph.getAdjacencyList(e.getFrom()))
            {
            	// On vérifie si il n'y existe pas un autre chemin vers l'autre sommet de l'arc
                if(findPathRecurs(e.getTo(), ed, new HashSet<Vertex>())) return true;
            }
        return false;
    }
	
	public boolean findPathRecurs(Vertex dest, Edge e, HashSet<Vertex> vList) {
		// Ajoute le sommet dans la liste des visités
		vList.add(e.getTo());
		
		// Si le sommet que l'on visite est égal à celui qu'on doit trouver
		// (L'autre sommet de l'arc d'origine), on a un cycle
		if(e.getTo().equals(dest)) return true;
		
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
	 private boolean CycleRecurs(spaning_tree.Vertex v, ArrayList<spaning_tree.Vertex> visited, spaning_tree.Vertex parent)
	    { 
	        visited.add(v); 
	        //System.out.println("v:" + v.toString());
	        ArrayList<spaning_tree.Edge> adj = graph.getAdjacencyList(v);
	        
	        for (spaning_tree.Edge i : adj) {
	        	//adj.add(new spaning_tree.Edge(i.getTo(), i.getFrom(), i.getWeight()));
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
	  
	    public boolean isCycle(spaning_tree.Edge e)
	    { 
	        ArrayList<spaning_tree.Vertex> visited = new ArrayList<>();
	        
	        if (CycleRecurs(e.getFrom(), visited, null)) 
	            return true; 
	        
	        return false; 
	    } 
	    */
	   
}
