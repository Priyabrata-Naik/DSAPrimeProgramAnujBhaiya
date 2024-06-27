package graph.session_3;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class TopologicalSorting {
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

        topologicalOrdering(graph, V);

    }

    static void topologicalOrdering(ArrayList<ArrayList<Integer>> graph, int V){
        ArrayDeque<Integer> ansStack = new ArrayDeque<>();
        boolean vis[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(graph, vis, i, ansStack);
            }
        }
        while(!ansStack.isEmpty()){
            System.out.print(ansStack.pop()+" ");
        }
        System.out.println();
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int cur, ArrayDeque<Integer> ansStack){
        vis[cur] = true;

        for(int neighbour: graph.get(cur)){
            if(!vis[neighbour]){
                dfs(graph, vis, neighbour, ansStack);
            }
        }
        ansStack.push(cur);
    }

    static void addEdges(ArrayList<ArrayList<Integer>> graph, int a, int b){
        if(graph.get(a).contains(b)) return;
        graph.get(a).add(b);
    }
}
