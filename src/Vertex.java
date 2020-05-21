import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
		private Integer value;
		
		private ArrayList<Edge> adjacences;
	    public Vertex(Integer value) {
	    	this.adjacences = new ArrayList<Edge>();
	        this.value = value;
	    }
	    
	    public String toString() {
	    	return value + "";
	    }
	    
	    public Integer getValue() {
	    	return value;
	    }

		@Override
		public int compareTo(Vertex v) {
			if (value < v.getValue()) {
	            return -1;
	        } else if (value > v.getValue()) {
	            return 1;
	        } else {
	            return 0;
	        }
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
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
			Vertex other = (Vertex) obj;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

	}