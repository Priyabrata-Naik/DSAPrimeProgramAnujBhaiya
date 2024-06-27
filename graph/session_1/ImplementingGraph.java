package graph.session_1;

import java.util.ArrayList;

public class ImplementingGraph {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 4;

        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        addEdges(graph, 0, 1);
        addEdges(graph, 0, 2);
        addEdges(graph, 0, 3);
        addEdges(graph, 1, 2);


//        int graphMat[][] = new int[V][V];
//
//        addEdgesMat(graphMat, 0, 1, 3);
//        addEdgesMat(graphMat, 0, 2, 5);
//        addEdgesMat(graphMat, 0, 3, 2);
//        addEdgesMat(graphMat, 1, 2, 1);

    }
    static void addEdgesMat(int graphMat[][], int src, int dest, int wt){
        graphMat[src][dest] = wt;
//        graphMat[dest][src] = wt;
    }
    static void addEdges(ArrayList<ArrayList<Integer>> graph, int a, int b){
        if(graph.get(a).contains(b)) return;
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
}
