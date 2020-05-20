
public class Edge implements Comparable<Edge>{
	    private Vertex from;
	    private Vertex to;
	    private Integer weight;

	    public Edge(Vertex from, Vertex to, Integer weight) {
	        this.from = from;
	        this.to = to;
	        this.weight = weight;
	    }
	    
	    public String toString() {
			return from.toString() + "--->"+ to.toString() + " : "  + weight;  
	    }
	    
	    public Integer getWeight() {
	    	return weight;
	    }
	    
	    public Vertex getTo() {
	    	return to;
	    }

	    public Vertex getFrom() {
	    	return from;
	    }

		@Override
		public int compareTo(Edge e) {
			if (weight < e.getWeight()) {
	            return -1;
	        } else if (weight > e.getWeight()) {
	            return 1;
	        } else {
	            return 0;
	        }
		}
	}