package spaning_tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Graph {

	private Map<Vertex, ArrayList<Edge>> graph = new HashMap<>();

	
	public Graph(){

	}

	public Map<Vertex, ArrayList<Edge>> getGraph() {
		return graph;
	}

	public void addEdge(Integer source, Integer dest, Integer weight) {
		Vertex vSource = new Vertex(source);
		Vertex vDest = new Vertex(dest);
		addVertex(vSource);
		addVertex(vDest);
		Edge e1 = new Edge(vSource, vDest, weight);
		Edge e2 = new Edge(vDest,vSource , weight);
		if(!graph.get(vSource).contains(e1))
			graph.get(vSource).add(e1);
		if(!graph.get(vDest).contains(e2))
			graph.get(vDest).add(e2);

	}
	
	public int getNbSommets() {
		return this.graph.size();
	}

	public void addVertex(Vertex v) {
		graph.putIfAbsent(v, new ArrayList<Edge>());
	}

	public void printGraph() {
		System.out.println(this.toString());
	}
	

	public String toString() {

		StringBuilder builder = new StringBuilder(); 
			Collection<ArrayList<Edge>> arr = this.getAllEdges();
			for(ArrayList<Edge> arrEdges : arr) {
			for (Edge a : arrEdges) { 
				builder.append("e " + a.getFrom() + " " + a.getTo() + " " + a.getWeight() + "\n"); 
			} 
			}
			builder.append("\n"); 
		return builder.toString();
	}
	
	public Set<Vertex> getAllVertex() {
		return this.graph.keySet();
	}
	
	public Collection<ArrayList<Edge>> getAllEdges(){
		return this.graph.values();
	}
	
	public int edgesCount(Vertex vertex) {
		if(graph.containsKey(vertex)) {
			return graph.get(vertex).size();
		}
		else return 0;
	}
	
	public ArrayList<Edge> getAdjacencyList(Vertex vertex) {
		if(graph.containsKey(vertex)) {
			return graph.get(vertex);
		}
		else return null;
	}
	
	public ArrayList<Vertex> getAdjacentVertex(Vertex v){
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		ArrayList<Edge> adj = getAdjacencyList(v);
		for(Edge e : adj) {
			//System.out.println(e);
				result.add(e.getTo());
		}
		return result;
		
	}
	
	public Integer getWeight() {
		Collection<ArrayList<Edge>> edges = getAllEdges();
		Integer weight = 0;
		
		for(ArrayList<Edge> edgeList : edges) {
			for(Edge e : edgeList) {
				weight += e.getWeight();
			}
		}
		return weight/2;
	}
	/*
	private static <K, V extends Comparable<V>> TreeMap<K, V> sortByValuesDesc(final Map<K, V> map) {
	    Comparator<K> valueComparator =  new Comparator<K>() {
	        public int compare(K k1, K k2) {
	            int compare = map.get(k2).compareTo(map.get(k1));
	            if (compare == 0) return 1;
	            else return compare;
	        }
	    };
	    TreeMap<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	}
	
	public List<Integer> getRandomOrderVertex() {
		List<Integer> list = new ArrayList<>(getAllVertex());
		Collections.shuffle(list);
		return list;
	}

	
	// Ordonne les vertex en fonction de leur nombre d'adjacences dans l'ordre d�croissant
	public List<Integer> getDescendingOrderVertex() {
		Set<Integer> vertex = getAllVertex();
		
		HashMap<Integer, Integer> associations = new HashMap<>();
		for(Integer v : vertex) {
			associations.put(v, edgesCount(v));
		}
		
		TreeMap<Integer, Integer> orderedVertex = sortByValuesDesc(associations);
    	//System.out.println(orderedVertex.size());
		/*for(Entry<Integer, Integer> v : orderedVertex.entrySet()) {
			System.out.println(v.getKey() + " " + v.getValue());
		}
		
		return new ArrayList<Integer>(orderedVertex.keySet());
	}
	*/
	public List<Edge> getAscendingOrderEdges(){
		Collection<ArrayList<Edge>> edges = getAllEdges();
		ArrayList<Edge> sortedEdges = new ArrayList<Edge>();
		for (List<Edge> connections : edges) {
		    sortedEdges.addAll(connections);
		}
		Collections.sort(sortedEdges);
		return sortedEdges;
	}
	
	public List<Edge> getDescendingOrderEdges(){
		Collection<ArrayList<Edge>> edges = getAllEdges();
		ArrayList<Edge> sortedEdges = new ArrayList<Edge>();
		for (List<Edge> connections : edges) {
		    sortedEdges.addAll(connections);
		}
		Collections.sort(sortedEdges, Collections.reverseOrder());
		return sortedEdges;
	}
}
