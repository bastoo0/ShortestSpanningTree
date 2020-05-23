package spaning_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


// Algorithme de Prim avec une contrainte de degrée
// Le résultat obtenu dépend de l'ordre de traitement des arcs
public class DPrim {

    private Graph graph;
    private Integer SPValue = 0;
    private Integer contrainte;
    private long exeTime;
    private Graph g = new Graph(); // Graph en sortie

    public DPrim(Graph graph, Integer degMax) {
    	this.contrainte = degMax;
        this.graph = graph;
        primAlgorithm();
    }

    public void primAlgorithm() {

        Set<Vertex> vertrices = graph.getGraph().keySet();
        // On se sert de la hashmap pour stocker les degrés des sommets
        Map<Vertex, Integer> degrees = new HashMap<>();
        for(Vertex v : vertrices) {
        degrees.put(v, 0);
        }
        List<Edge> edgesList = graph.getRandomOrderEdges();
        Set<Edge> graphFinal = new HashSet<>();
        ArrayList<Vertex> visited = new ArrayList<>();
        
        long startTime = System.currentTimeMillis();
        
        //on choisit un sommet quelconque dans le graph et on le marque comme visité
        visited.add(edgesList.get(0).getFrom());
        for(int i = 0; i< vertrices.size(); i++) {
        	// On r�cup�re l'arc de plus petite taille
        	Edge selected = selectMinimumWeight(edgesList, visited, degrees);
        	if(selected == null) continue; // Si aucun arc trouvé, on saute l'étape
        	// On ajoute l'arc trouvé au graph final
        	graphFinal.add(selected);
        	Edge back = new Edge(selected.getTo(), selected.getFrom(), selected.getWeight());
			graphFinal.add(back);
			// On ajoute son sommet à la liste des sommets visités
			visited.add(selected.getTo());
			
			// On incrémente les degrés associés aux deux sommets de l'arc ajouté
			degrees.put(selected.getFrom(),degrees.get(selected.getFrom()) + 1);
			degrees.put(selected.getTo(),degrees.get(selected.getTo()) + 1);
        }

        this.exeTime = System.currentTimeMillis() - startTime;
        
        // On reconstitue le graph (hors algo)
        
        for(Edge e : graphFinal) {
        	g.addEdge(e.getFrom().getValue(), e.getTo().getValue(), e.getWeight());
        }
        
        ///Pour afficher le degré de chaque sommet
       /* for(Vertex v : g.getAllVertex()) {
        	System.out.println(v.toString() + " : " + g.getDegree(v));
        }*/
        
    	SPValue = g.getWeight();
        //g.printGraph();
    }
    
    public Edge selectMinimumWeight(List<Edge> edges, ArrayList<Vertex> visited, Map<Vertex, Integer> degrees) {
    	// Arc par défaut, on lui donne une valeur infinie
        Edge selected = new Edge(new Vertex(0), new Vertex(0), Integer.MAX_VALUE);
        
        // On regarde tous les arcs du graph
    	for(Edge e : edges) {
    		// Si un arc est a un sommet A visité et B non visité et a un poids
    		// plus faible que l'arc en cours, on le sélectionne
    		// Si la valeur associée à un des sommet est supérieure à la contrainte on ne le prend pas 
    		// (on fait un test inférieur strict car la valeur est initialisée à 0 dans la hashmap)
    		if(e.getWeight() < selected.getWeight() && visited.contains(e.getFrom()) && !visited.contains(e.getTo())
    				&& degrees.get(e.getFrom()) < contrainte && degrees.get(e.getTo()) < contrainte)
    			selected = e;
    	}
    	
    	// S'il n'a pas trouvé d'arc on ne veut pas récupérer l'arc par défaut
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
	
	public Integer getMaxDegreeResult() {
		return g.getDegMax();
	}

}
