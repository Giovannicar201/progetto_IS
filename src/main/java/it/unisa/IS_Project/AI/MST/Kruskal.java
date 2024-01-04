package it.unisa.IS_Project.AI.MST;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import java.util.ArrayList;
import java.util.List;


public class Kruskal {

    public static float computaMaxSTCompletamenteConnesso(List<String> V, List<Arco> E) {
        Graph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for (String v : V)
            graph.addVertex(v);

        for (Arco arco : E) {
            String v = arco.getV();
            String w = arco.getW();
            double weight = arco.getWeight();
            graph.addEdge(v, w);
            graph.setEdgeWeight(graph.getEdge(v, w), weight);
        }

        KruskalMinimumSpanningTree<String, DefaultWeightedEdge> kruskalMST =
                new KruskalMinimumSpanningTree<>(graph);

        List<DefaultWeightedEdge> mstEdges = new ArrayList<>(kruskalMST.getSpanningTree().getEdges());

        List<DefaultWeightedEdge> maxSTEdges = new ArrayList<>();
        for (DefaultWeightedEdge edge : graph.edgeSet()) {
            if (!mstEdges.contains(edge)) {
                maxSTEdges.add(edge);
            }
        }

        double totalWeight = 0.0;
        for (DefaultWeightedEdge edge : maxSTEdges)
            totalWeight += graph.getEdgeWeight(edge);

        return (float) totalWeight;
    }

    public static float computaMinSTCompletamenteConnesso(List<String> V, List<Arco> E) {
        Graph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for (String v : V)
            graph.addVertex(v);

        for (Arco edge : E) {
            String v = edge.getV();
            String w = edge.getW();
            double weight = edge.getWeight();
            graph.addEdge(v,w);
            graph.setEdgeWeight(graph.getEdge(v,w), weight);
        }

        KruskalMinimumSpanningTree<String, DefaultWeightedEdge> kruskalMST = new KruskalMinimumSpanningTree<>(graph);

        SpanningTreeAlgorithm.SpanningTree<DefaultWeightedEdge> mst = kruskalMST.getSpanningTree();

        double totalWeight = 0.0;

        for (DefaultWeightedEdge edge : mst.getEdges())
            totalWeight += graph.getEdgeWeight(edge);

        return (float) totalWeight;
    }
}
