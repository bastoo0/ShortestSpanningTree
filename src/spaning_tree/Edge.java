package spaning_tree;

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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((from == null) ? 0 : from.hashCode());
			result = prime * result + ((to == null) ? 0 : to.hashCode());
			result = prime * result + ((weight == null) ? 0 : weight.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Edge other = (Edge) obj;
			if (from == null) {
				if (other.from != null)
					return false;
			} else if (!from.equals(other.from))
				return false;
			if (to == null) {
				if (other.to != null)
					return false;
			} else if (!to.equals(other.to))
				return false;
			if (weight == null) {
				if (other.weight != null)
					return false;
			} else if (!weight.equals(other.weight))
				return false;
			return true;
		}

		/*public boolean equals(spaning_tree.Edge e) {
			if(e != null) {
			if((to == e.to && from == e.from) || (to == e.from && from == e.to))
				return true;
			}
			return false;
		}*/
	}
