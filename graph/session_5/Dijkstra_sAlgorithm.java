package graph.session_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_sAlgorithm {
    public static void main(String[] args) {

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        int V = 6;

        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        addEdges(graph, 0, 1, 1); addEdges(graph, 0, 4, 1);
        addEdges(graph, 1, 2, 2); addEdges(graph, 4, 1, 2);
        addEdges(graph, 3, 4, 2); addEdges(graph, 3, 1, 3);
        addEdges(graph, 2, 3, 3); addEdges(graph, 5, 1, 5);
        addEdges(graph, 3, 5, 6); addEdges(graph, 5, 4, 6);
        addEdges(graph, 5, 0, 9);

        int src = 0;

        int ans[] = minDistanceDijkstra_s(graph, V, src);

        for(int i = 0; i < V; i++){
            System.out.println("0" + " - " + i + " -> " + ans[i]);
        }

    }

    static int[] minDistanceDijkstra_s(ArrayList<ArrayList<Pair>> graph, int V, int src){
        int ans[] = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        boolean vis[] = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(-1, src, 0));

        while(!pq.isEmpty()){
            Edge edges = pq.poll();
            int cur = edges.dest;
            if(vis[cur]) continue;
            vis[cur] = true;

            ArrayList<Pair> curNeighbors = graph.get(cur);
            for(Pair neighbor: curNeighbors){
                if(!vis[neighbor.v]){
                    if(ans[cur] != Integer.MAX_VALUE && ans[neighbor.v] > neighbor.w + ans[cur]){
                        ans[neighbor.v] = ans[cur] + neighbor.w;
                        pq.add(new Edge(cur, neighbor.v, ans[neighbor.v]));
                    }
                }
            }
        }

        return ans;
    }

    static class Edge implements Comparable<Edge>{
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge that) {
            return this.wt - that.wt;
        }
    }

    static void addEdges(ArrayList<ArrayList<Pair>> graph, int src, int dest, int wt){
        graph.get(src).add(new Pair(dest, wt));
        graph.get(dest).add(new Pair(src, wt));
    }
}


