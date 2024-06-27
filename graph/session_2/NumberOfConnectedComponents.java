package graph.session_2;

import java.util.ArrayList;

public class NumberOfConnectedComponents {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 8;

        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        addEdges(graph, 0, 1);
        addEdges(graph, 0, 2);
        addEdges(graph, 5, 2);
        addEdges(graph, 1, 5);
//        addEdges(graph, 7, 5);
        addEdges(graph, 7, 4);
        addEdges(graph, 7, 6);
        addEdges(graph, 6, 3);

        boolean[] vis = new boolean[V];

        System.out.println(numberOfConnectedComponent(graph, V));

    }
    static int numberOfConnectedComponent(ArrayList<ArrayList<Integer>> graph, int V){
        int count = 0;
        boolean[] vis = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                count++;
                dfs(graph, vis, i);
            }
        }
        return count;
    }
    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int cur){
        vis[cur] = true;
//        System.out.println(cur);
        for(int neighbour: graph.get(cur)){
            if(!vis[neighbour]){
                dfs(graph, vis, neighbour);
            }
        }
    }
    static void addEdges(ArrayList<ArrayList<Integer>> graph, int a, int b){
        if(graph.get(a).contains(b)) return;
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
}
