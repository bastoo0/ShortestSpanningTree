
import java.io.*;
import java.util.ArrayList;

public class GraphConverter {

	private ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
	private int min;

	public GraphConverter() {
	}

	public ArrayList<ArrayList<Integer>> getEdges() {
		return edges;
	}

	public void openFile(String url) throws IOException {

		File file = new File(url);
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line = "";

		edges.add(new ArrayList<Integer>());
		edges.add(new ArrayList<Integer>());
		edges.add(new ArrayList<Integer>());
		while((line = br.readLine()) != null){

			if(line.startsWith("p")){
                String [] words = line.split(" ");
                min = Integer.parseInt(words[2]);
                //System.out.println(size);
            }
			
			if(line.startsWith("e")){
				String [] e = line.substring(2).split(" ");
				edges.get(0).add(Integer.parseInt(e[0]));
				edges.get(1).add(Integer.parseInt(e[1]));
				edges.get(2).add(Integer.parseInt(e[2]));
				//System.out.println(edges[0][i] + " " + edges[1][i]" " + i);
				
			}
		}
		br.close();
	}
	
	public int getMinimumST() {
		return this.min;
	}
	
}
