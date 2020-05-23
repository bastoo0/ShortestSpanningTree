package spaning_tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prim {

    private Graph graph;
    private Integer SPValue = 0;
    private long exeTime;

    public Prim(Graph graph) {
        this.graph = graph;
        primAlgorithm();
    }

    public void primAlgorithm() {

        Set<Vertex> vertrices = graph.getGraph().keySet();
        List<Edge> edgesList = graph.getRandomOrderEdges();
        Set<Edge> graphFinal = new HashSet<>();
        ArrayList<Vertex> visited = new ArrayList<>();
        
        long startTime = System.currentTimeMillis();
        
        //on choisit un sommet quelconque dans le graph et on le marque comme visité
        visited.add(edgesList.get(0).getFrom());
        for(int i = 0; i< vertrices.size(); i++) {
        	// On récupère l'arc de plus petite taille
        	Edge selected = selectMinimumWeight(edgesList, visited);
        	if(selected == null) break; // Si aucun arc trouvé, fin de l'algorithme
        	
        	// On ajoute l'arc trouvé au graph final
        	graphFinal.add(selected);
        	Edge back = new Edge(selected.getTo(), selected.getFrom(), selected.getWeight());
			graphFinal.add(back);
			// On ajoute son sommet à la liste des sommets visités
			visited.add(selected.getTo());
        }

        this.exeTime = System.currentTimeMillis() - startTime;
        
        // On reconstitue le graph (hors algo)
        Graph g = new Graph();
        for(Edge e : graphFinal) {
        	g.addEdge(e.getFrom().getValue(), e.getTo().getValue(), e.getWeight());
        }
    	SPValue = g.getWeight();
        //g.printGraph();
    }
    
    public Edge selectMinimumWeight(List<Edge> edges, ArrayList<Vertex> visited) {
    	// Arc par défaut, on lui donne une valeur infinie
        Edge selected = new Edge(new Vertex(0), new Vertex(0), Integer.MAX_VALUE);
        
        // On regarde tous les arcs du graph
    	for(Edge e : edges) {
    		// Si un arc est a un sommet A visité et B non visité et a un poids
    		// plus faible que l'arc en cours, on le sélectionne
    		if(e.getWeight() < selected.getWeight() && visited.contains(e.getFrom()) && !visited.contains(e.getTo()))
    			selected = e;
    	}
    	
    	// S'il n'a pas trouvé d'arc, on ne veut pas récupérer l'arc par défaut
    	if(selected.getFrom().getValue() != 0)
    		return selected;    
    	else return null;
    	}

    public Integer getSPWeigth() {
        return SPValue;
    }

	public long getExeTime() {
		return exeTime;
	}

}
