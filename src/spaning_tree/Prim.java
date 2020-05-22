package spaning_tree;

import java.util.List;

public class Prim {

    private Graph graph;
    Integer SPValue = 0;
    private long exeTime;

    public Prim(Graph graph) {
        this.graph = graph;
        primAlgorithm();
    }

    public void primAlgorithm() {

        long startTime = System.currentTimeMillis();

        //on choisit un sommet quelconque dans le graph
        Vertex vertex;
        vertex = graph.getGraph().keySet().iterator().next();
        System.out.println(vertex);

        List<Edge> edges = graph.getAdjacencyList(vertex);
        for(Edge e : edges){
            //on vérifie quelle arrête a le poids minimum
            // dans tous les sommets adjacents des sommets
            if(e.getWeight() < vertex.getValue()){
                graph.getAdjacencyList(e.getFrom()).add(e);
                graph.addVertex(e.getTo());
            }
        }

        this.exeTime = System.currentTimeMillis() - startTime;
        SPValue = graph.getWeight();
    }

    public Integer getSPWeigth() {
        return SPValue;
    }

}
