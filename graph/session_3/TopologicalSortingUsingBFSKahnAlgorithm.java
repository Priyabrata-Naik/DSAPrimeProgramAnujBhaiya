package graph.session_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortingUsingBFSKahnAlgorithm {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 6;

        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        addEdges(graph, 0, 2);
        addEdges(graph, 0, 3);
        addEdges(graph, 2, 1);
        addEdges(graph, 2, 3);
        addEdges(graph, 3, 1);
        addEdges(graph, 4, 5);
        addEdges(graph, 4, 1);
        addEdges(graph, 5, 1);

        topologicalOrderingKahnAlgo(graph, V);

    }

    static void topologicalOrderingKahnAlgo(ArrayList<ArrayList<Integer>> graph, int V){
        Queue<Integer> q = new LinkedList<>();
        int inDegree[] = new int[V];

        for(int i = 0; i < V; i++){
            for(int e: graph.get(i)){
                inDegree[e]++;
            }
        }

        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur+" ");
            for(int neighbour: graph.get(cur)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) q.add(neighbour);
            }
        }
        System.out.println();
    }
    static void addEdges(ArrayList<ArrayList<Integer>> graph, int a, int b){
        if(graph.get(a).contains(b)) return;
        graph.get(a).add(b);
    }
}
