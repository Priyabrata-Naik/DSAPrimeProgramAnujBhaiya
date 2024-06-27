package graph.session_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static graph.session_1.ImplementingGraph.addEdges;

public class BFSAlgorithm {
    static int V = 4;
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        addEdges(graph, 0, 1);
        addEdges(graph, 0, 2);
        addEdges(graph, 0, 3);
        addEdges(graph, 1, 2);

        boolean[] vis = new boolean[V];
        int dist[] = new int[V];
        int[] prec = new int[V];
//        bfs(graph, 0, vis);
//        bfsWithDistance(graph, 3, vis, dist, prec);
//
//        System.out.println("Distance");
//        for(int i = 0; i < dist.length; i++){
//            System.out.println(i + " -> " + dist[i]);
//        }

        findPath(graph, 1, 3);

    }
    static void bfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.println(cur);
            for(int neighbour: graph.get(cur)){
                if(!vis[neighbour]){
                    q.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
    }
    static void findPath(ArrayList<ArrayList<Integer>> graph, int src, int des){
        boolean vis[] = new boolean[V];
        int dist[] = new int[V];
        int prec[] = new int[V];
        bfsWithDistance(graph, src, vis, dist, prec);

        while(des != -1){
            System.out.println(des);
            des = prec[des];
        }
    }
    static void bfsWithDistance(ArrayList<ArrayList<Integer>> graph, int src, boolean[] vis, int[] dist, int[] prec){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        dist[src] = 0;
        prec[src] = -1;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int neighbour: graph.get(cur)){
                if(!vis[neighbour]){
                    q.add(neighbour);
                    vis[neighbour] = true;
                    dist[neighbour] = dist[cur] + 1;
                    prec[neighbour] = cur;
                }
            }
        }
    }
}
